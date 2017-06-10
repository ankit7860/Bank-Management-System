package com.cts.bankmanagement.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.cts.bankmanagement.controller.PerformTransactionController;
import com.cts.bankmanagement.dao.PerformTransactionDAO;
import com.cts.bankmanagement.dao.UserDAO;
import com.cts.bankmanagement.exception.BankManagementException;
import com.cts.bankmanagement.vo.TransactionVO;
import com.cts.bankmanagement.vo.UserVO;

@Service("performTransactionService")
public class PerformTransactionServiceImpl implements PerformTransactionService {
	static Logger log = Logger.getLogger(PerformTransactionController.class.getName());
	@Autowired
	private PerformTransactionDAO performTransactionDAO;

	private final static String DEPOSIT = "Deposit";
	private final static String WITHDRAWAL = "Withdrawal";

	@Autowired
	private UserDAO userDAO;

	@Transactional
	@Override
	public void init() {
		if (CollectionUtils.isEmpty(userDAO.getUsersDetails())) {
			log.info("adding User Details to User_details table");
			UserVO user1 = new UserVO(1000000000000001L, "Salary", "Ankit Pal", 20000D);
			UserVO user2 = new UserVO(1000000000000002L, "Saving", "Ambesh Sharma", 30000D);
			UserVO user3 = new UserVO(1000000000000003L, "Saving", "Aviral Sharma", 40000D);
			UserVO user4 = new UserVO(1000000000000004L, "Salary", "shubham Khare", 50000D);
			UserVO user5 = new UserVO(1000000000000005L, "Salary", "Tanuj Tripathy", 20000D);
			userDAO.addUserDetails(user1);
			userDAO.addUserDetails(user2);
			userDAO.addUserDetails(user3);
			userDAO.addUserDetails(user4);
			userDAO.addUserDetails(user5);
		}
	}

	@Transactional
	@Override
	public Double updateTransactionDetails(TransactionVO transactionVO) throws BankManagementException {
		Long transactionId = setTransactionId(transactionVO);
		transactionVO.setTransactionId(transactionId);
		log.info("checking validation");
		validateData(transactionVO);

		UserVO userVO = userDAO.getUserDetails(transactionVO.getAccountNumber());
		if (userVO == null) {
			log.warn("account number does not exists in usertable");
			throw new BankManagementException("Account No: " + transactionVO.getAccountNumber() + " does not exist!");
		}

		Double accountBalance = userVO.getAccountBalance() == null ? 0 : userVO.getAccountBalance();
		Double transactionAmount = (double) transactionVO.getTransactionAmount();
		String accountType = userVO.getAccountType();
		log.info("validation for accountType and transactionType");
		if (userVO.getAccountHolderName().equalsIgnoreCase(transactionVO.getCustomerName())) {
			if (DEPOSIT.equalsIgnoreCase(transactionVO.getTransactionType())) {
				accountBalance += transactionAmount;
				userVO.setAccountBalance(accountBalance);
				userDAO.updateUserDetails(userVO);
			} else if (WITHDRAWAL.equalsIgnoreCase(transactionVO.getTransactionType())) {
				if (accountBalance < transactionAmount) {
					throw new BankManagementException("Withdrawal amount can not exceed account balance");
				} else {
					if (accountType.equalsIgnoreCase("salary")) {
						accountBalance -= transactionAmount;
					} else {
						Double remaining_balance = accountBalance - transactionAmount;
						if (remaining_balance >= 5000) {
							accountBalance -= transactionAmount;
						} else {
							throw new BankManagementException("Remaining balance must be greater than the 5000 Rupees");
						}
					}
					userVO.setTransactionId(transactionId);
					userVO.setAccountBalance(accountBalance);
					userDAO.updateUserDetails(userVO);
				}
			}
		} else {
			log.warn("Customer Name does not exists");
			throw new BankManagementException("Customer Name does not exists");
		}
		performTransactionDAO.updateTransactionDetails(transactionVO);
		return userVO.getAccountBalance();
	}

	@Override
	public void validateData(TransactionVO transactionVO) throws BankManagementException {
		if (getLength(transactionVO.getAccountNumber()) != 16) {
			log.warn("Account Number is not Valid!");
			throw new BankManagementException("Account Number is not Valid!");
		}

		if (!(transactionVO.getTransactionType().equalsIgnoreCase("Deposit")
				|| transactionVO.getTransactionType().equalsIgnoreCase("Withdrawal"))) {
			throw new BankManagementException("Transaction Type is not valid");
		}

		if (transactionVO.getTransactionAmount() == null && transactionVO.getTransactionAmount() < 0) {
			throw new BankManagementException("Transaction amount must be greater than 0");
		}
	}

	public int getLength(Long n) {
		log.info("method for getting number of digits");
		int i = 0;
		while (n > 0) {
			n = n / 10;
			++i;
		}
		return i;
	}

	@Override
	public Long setTransactionId(TransactionVO transactionVO) throws BankManagementException {
		log.info("method for generate transaction Id");
		Long count = performTransactionDAO.getTransactionCount();
		Long transactionId = 1000000001 + count;
		return transactionId;
	}

}

package com.cts.bankmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cts.bankmanagement.dao.ViewTransactionDAO;
import com.cts.bankmanagement.exception.BankManagementException;
import com.cts.bankmanagement.vo.TransactionVO;

@Service("viewTransactionService")
public class ViewTransactionServiceImpl implements ViewTransactionService {
	boolean result = false;
	@Autowired
	ViewTransactionDAO viewTransactionDAO;

	@Override
	@Transactional
	public List<TransactionVO> retreiveTransactionDetails(Long accountNumber, Long transactionId)
			throws BankManagementException {
		result = validateData(accountNumber, transactionId);
		if (result = false) {
			throw new BankManagementException("FATAL ERROR OCCURED!");
		}
		return viewTransactionDAO.retreiveTransactionDetails(accountNumber, transactionId);
	}

	public boolean validateData(Long accountNumber, Long transactionId) throws BankManagementException {
		boolean result = false;
		if (accountNumber != null && (transactionId != null)) {
			if (getLength(accountNumber) == 16) {
				if (getLength(transactionId) == 10) {
					result = true;
				} else {
					throw new BankManagementException("Transaction Id is not valid!");
				}
			} else {
				throw new BankManagementException("Account number is not valid!");
			}

		} else if (accountNumber != null && transactionId == null) {
			if (getLength(accountNumber) == 16) {
				result = true;
			} else {
				throw new BankManagementException("Account number is not valid!");
			}
		} else if (transactionId != null && accountNumber == null) {
			if (getLength(transactionId) == 10) {
				result = true;
			} else {
				throw new BankManagementException("Transaction Id is not valid!");
			}
		} else {
			throw new BankManagementException("Enter atleast one value");
		}

		return result;
	}

	public int getLength(Long n) {
		return n.toString().length();
	}
}
package test.java;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.cts.bankmanagement.exception.BankManagementException;
import com.cts.bankmanagement.service.PerformTransactionService;
import com.cts.bankmanagement.service.UserService;
import com.cts.bankmanagement.vo.TransactionVO;
import com.cts.bankmanagement.vo.UserVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:bms_test-context.xml" })
public class PerformTransactionServiceTest {

	@Autowired
	private PerformTransactionService performTransactionService;

	@Autowired
	private UserService userService;

	@Rollback(true)
	@Test
	public void testInit() {
		UserVO userVO = new UserVO(1234567891234567L, "Salary", "Ankit Pal", 80000000D);
		performTransactionService.init();
		UserVO user_VO = userService.getUserDetails(1234567891234567L);
		assertThat(userVO.getAccountHolderName(), is(user_VO.getAccountHolderName()));
		assertThat(userVO.getAccountType(), is(user_VO.getAccountType()));
	}

	@Rollback(true)
	@Transactional
	@Test
	public void testDeposit() throws BankManagementException {
		TransactionVO transactionVO = new TransactionVO(1234567891234567L, "Ankit Pal", "Deposit", 4000D, "none");
		UserVO userVO = userService.getUserDetails(1234567891234567L);
		Double account_balance = performTransactionService.updateTransactionDetails(transactionVO);
		Double initAccountBalance = userVO.getAccountBalance();
		Double expectedAccountBalance = null;
		expectedAccountBalance = initAccountBalance + transactionVO.getTransactionAmount();
		assertThat(expectedAccountBalance, is(account_balance));
	}

	@Rollback(true)
	@Transactional
	@Test(expected = BankManagementException.class)
	public void testDepositException() throws BankManagementException {
		TransactionVO transactionVO = new TransactionVO(1234567891234000L, "Ankit Pal", "Deposit", 2000D, "none");
		UserVO userVO = userService.getUserDetails(1234567891234567L);
		Double account_balance = performTransactionService.updateTransactionDetails(transactionVO);
		Double initAccountBalance = userVO.getAccountBalance();
		Double expectedAccountBalance = null;
		expectedAccountBalance = initAccountBalance + transactionVO.getTransactionAmount();
		assertThat(expectedAccountBalance, is(account_balance));
	}

	@Rollback(true)
	@Transactional
	@Test
	public void testWithdrawalSalary() throws BankManagementException {
		TransactionVO transactionVO = new TransactionVO(1234567891234567L, "Ankit Pal", "Withdrawal", 1000D, "none");
		UserVO userVO = userService.getUserDetails(1234567891234567L);
		Double account_balance = performTransactionService.updateTransactionDetails(transactionVO);
		Double initAccountBalance = userVO.getAccountBalance();
		Double expectedAccountBalance = null;
		expectedAccountBalance = initAccountBalance - transactionVO.getTransactionAmount();
		assertThat(expectedAccountBalance, is(account_balance));
	}

	@Rollback(true)
	@Transactional
	@Test(expected = BankManagementException.class)
	public void testFailWithdrawalSalary() throws BankManagementException {
		TransactionVO transactionVO = new TransactionVO(1234567891234567L, "Ankit Pal", "Withdrawal", 8000000D, "none");
		UserVO userVO = userService.getUserDetails(1234567891234567L);
		Double account_balance = performTransactionService.updateTransactionDetails(transactionVO);
		Double expectedAccountBalance = userVO.getAccountBalance() - transactionVO.getTransactionAmount();
		assertThat(expectedAccountBalance, is(account_balance));
	}

	@Rollback(true)
	@Transactional
	@Test
	public void testWithdrawalOther() throws BankManagementException {
		TransactionVO transactionVO = new TransactionVO(1234567891234561L, "Ank Pal", "Withdrawal", 100D, "none");
		UserVO userVO = userService.getUserDetails(1234567891234567L);
		Double account_balance = performTransactionService.updateTransactionDetails(transactionVO);
		Double initAccountBalance = userVO.getAccountBalance();
		Double expectedAccountBalance = null;
		expectedAccountBalance = initAccountBalance - transactionVO.getTransactionAmount();
		assertThat(expectedAccountBalance, is(account_balance));
	}

	@Rollback(true)
	@Transactional
	@Test(expected = BankManagementException.class)
	public void testFailWithdrawalOther() throws BankManagementException {
		TransactionVO transactionVO = new TransactionVO(1234567891234567L, "Ankit Pal", "Withdrawal", 2800000D, "none");
		UserVO userVO = userService.getUserDetails(1234567891234567L);
		Double account_balance = performTransactionService.updateTransactionDetails(transactionVO);
		Double expectedAccountBalance = userVO.getAccountBalance() - transactionVO.getTransactionAmount();
		assertThat(expectedAccountBalance, is(account_balance));
	}
}

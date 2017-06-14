package com.cts.bankmanagement.service;

import com.cts.bankmanagement.exception.BankManagementException;
import com.cts.bankmanagement.vo.TransactionVO;

public interface PerformTransactionService {

	void init();

	Double updateTransactionDetails(TransactionVO transactionVO) throws BankManagementException;

	void validateData(TransactionVO transactionVO) throws BankManagementException;

	void setTransactionId(TransactionVO transactionVO) throws BankManagementException;

}

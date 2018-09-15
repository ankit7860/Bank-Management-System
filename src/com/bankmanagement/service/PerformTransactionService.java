package com.bankmanagement.service;

import com.bankmanagement.exception.BankManagementException;
import com.bankmanagement.vo.TransactionVO;

public interface PerformTransactionService {

	void init();

	Double updateTransactionDetails(TransactionVO transactionVO) throws BankManagementException;

	void validateData(TransactionVO transactionVO) throws BankManagementException;

	void setTransactionId(TransactionVO transactionVO) throws BankManagementException;

}

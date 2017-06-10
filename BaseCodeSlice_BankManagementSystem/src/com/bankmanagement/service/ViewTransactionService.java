package com.bankmanagement.service;

import java.util.List;

import com.bankmanagement.exception.BankManagementException;
import com.bankmanagement.vo.TransactionVO;

public interface ViewTransactionService {
	public List<TransactionVO> retreiveTransactionDetails(Long accountNumber, Long transactionId)
			throws BankManagementException;
}
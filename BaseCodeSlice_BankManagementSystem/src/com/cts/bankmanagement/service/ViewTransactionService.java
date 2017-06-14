package com.cts.bankmanagement.service;

import java.util.List;

import com.cts.bankmanagement.exception.BankManagementException;
import com.cts.bankmanagement.vo.TransactionVO;

public interface ViewTransactionService {
	public List<TransactionVO> retreiveTransactionDetails(Long accountNumber, Long transactionId)
			throws BankManagementException;
}
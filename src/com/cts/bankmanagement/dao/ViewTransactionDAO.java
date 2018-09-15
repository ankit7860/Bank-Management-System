package com.cts.bankmanagement.dao;

import java.util.List;

import com.cts.bankmanagement.vo.TransactionVO;

public interface ViewTransactionDAO {

	List<TransactionVO> retreiveTransactionDetails(Long accountNumber, Long transactionId);

	TransactionVO getUserDetails(Long transactionId, Long accountNumber);

	List<TransactionVO> getTrasactionDetails(Long accountNumber);

	List<TransactionVO> getTransactionDetails(Long transactionId);

}
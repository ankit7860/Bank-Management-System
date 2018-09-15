package com.bankmanagement.dao;

import com.bankmanagement.vo.TransactionVO;

public interface PerformTransactionDAO {
	public Long updateTransactionDetails(TransactionVO transactionVO);

	Long getTransactionId();
}

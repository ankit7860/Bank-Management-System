package com.cts.bankmanagement.dao;

import com.cts.bankmanagement.vo.TransactionVO;

public interface PerformTransactionDAO {
	public Long updateTransactionDetails(TransactionVO transactionVO);

	Long getTransactionId();
}

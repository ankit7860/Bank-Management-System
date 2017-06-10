package com.bankmanagement.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bankmanagement.entity.TransactionUser;
import com.bankmanagement.vo.TransactionVO;

@Repository("performTransactionDAO")
public class PerformTransactionDAOImpl implements PerformTransactionDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private TransactionUser addPerformTransaction(TransactionVO transactionVO) {
		return new TransactionUser(transactionVO.getTransactionId(), transactionVO.getAccountNumber(),
				transactionVO.getDesciption(), transactionVO.getTransactionType(),
				transactionVO.getTransactionAmount());
	}

	@Override
	public Long updateTransactionDetails(TransactionVO transactionVO) {
		TransactionUser transaction = addPerformTransaction(transactionVO);
		Long transactionId = (Long) sessionFactory.getCurrentSession().save(transaction);
		return transactionId;
	}

	@Override
	public Long getTransactionId() {
		Query query = sessionFactory.getCurrentSession()
				.createQuery("Select count(TRANSACTION_ID) from TransactionUser");
		Long count = (Long) query.uniqueResult();
		return count;
	}
}

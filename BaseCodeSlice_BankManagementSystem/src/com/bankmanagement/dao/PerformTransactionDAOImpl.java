package com.cts.bankmanagement.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cts.bankmanagement.entity.TransactionUser;
import com.cts.bankmanagement.vo.TransactionVO;

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
		sessionFactory.getCurrentSession()
				.createQuery("update TransactionUser set transactionId = :transactionId where transactionId = :transId")
				.setParameter("transactionId", transactionVO.getTransactionId()).setParameter("transId", transactionId)
				.executeUpdate();
		return transactionId;
	}

	@Override
	public Long getTransactionCount() {
		Query query = sessionFactory.getCurrentSession()
				.createQuery("Select count(TRANSACTION_ID) from TransactionUser");
		Long count = (Long) query.uniqueResult();
		return count;
	}
}

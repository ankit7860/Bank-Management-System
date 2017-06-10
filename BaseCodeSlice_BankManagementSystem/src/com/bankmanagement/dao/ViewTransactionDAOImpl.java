package com.bankmanagement.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.bankmanagement.entity.TransactionUser;
import com.bankmanagement.vo.TransactionVO;

@Repository("viewTransactionDAO")
public class ViewTransactionDAOImpl implements ViewTransactionDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<TransactionVO> retreiveTransactionDetails(Long accountNumber, Long transactionId) {
		if (transactionId != null && accountNumber == null) {
			return getTransactionDetails(transactionId);
		} else if (transactionId == null && accountNumber != null) {
			return getTrasactionDetails(accountNumber);
		} else if (transactionId != null && accountNumber != null) {
			return Arrays.asList(getUserDetails(transactionId, accountNumber));
		} else {
			return null;
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public TransactionVO getUserDetails(Long transactionId, Long accountNumber) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from TransactionUser where transactionId = :transactionId and accountNumber = :accountNumber");
		query.setParameter("transactionId", transactionId);
		query.setParameter("accountNumber", accountNumber);
		List<TransactionUser> users = query.list();
		if (!CollectionUtils.isEmpty(users)) {
			return getTransactionVO(users.get(0));
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TransactionVO> getTrasactionDetails(Long accountNumber) {
		Query query = sessionFactory.getCurrentSession()
				.createQuery("from TransactionUser where accountNumber = :accountNumber");
		query.setParameter("accountNumber", accountNumber);
		return getTransactionVO((List<TransactionUser>) query.list());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TransactionVO> getTransactionDetails(Long transactionId) {
		Query query = sessionFactory.getCurrentSession()
				.createQuery("from TransactionUser where transactionId = :transactionId");
		query.setParameter("transactionId", transactionId);
		return getTransactionVO((List<TransactionUser>) query.list());
	}

	private List<TransactionVO> getTransactionVO(List<TransactionUser> users) {
		if (CollectionUtils.isEmpty(users)) {
			return Collections.emptyList();
		}
		List<TransactionVO> usersVO = new ArrayList<TransactionVO>(users.size());
		for (TransactionUser transactionUser : users) {
			usersVO.add(getTransactionVO(transactionUser));
		}
		return usersVO;
	}

	private TransactionVO getTransactionVO(TransactionUser transactionUser) {
		if (transactionUser != null) {
			return new TransactionVO(transactionUser.getTransactionId(), transactionUser.getAccountNumber(),
					transactionUser.getDescription(), transactionUser.getTransactionType(),
					transactionUser.getTransactionAmount());
		}
		return null;
	}

}

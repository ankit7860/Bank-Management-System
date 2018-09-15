package com.cts.bankmanagement.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.cts.bankmanagement.entity.TransactionUser;
import com.cts.bankmanagement.vo.TransactionVO;
import com.cts.bankmanagement.vo.UserVO;

@Repository("viewTransactionDAO")
public class ViewTransactionDAOImpl implements ViewTransactionDAO {

	@Autowired
	private UserDAO userDao;

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
				"from TransactionUser tu inner join fetch tu.user as u where u.accountNumber = :accountNumber and tu.transactionId = :transactionId");
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
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from TransactionUser tu inner join fetch tu.user as u where u.accountNumber = :accountNumber");
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

	private List<TransactionVO> getTransactionVO(List<TransactionUser> transactionUserList) {
		if (CollectionUtils.isEmpty(transactionUserList)) {
			return Collections.emptyList();
		}
		List<TransactionVO> transactionVoList = new ArrayList<TransactionVO>(transactionUserList.size());
		for (TransactionUser transactionUser : transactionUserList) {
			transactionVoList.add(getTransactionVO(transactionUser));
		}
		return transactionVoList;
	}

	private TransactionVO getTransactionVO(TransactionUser transactionUser) {
		if (transactionUser != null) {
			UserVO userVO = userDao.prepareUserVO(transactionUser.getUser());
			return new TransactionVO(transactionUser.getTransactionId(), userVO, transactionUser.getDescription(),
					transactionUser.getTransactionType(), transactionUser.getTransactionAmount());
		}
		return null;
	}

}

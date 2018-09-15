package com.cts.bankmanagement.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cts.bankmanagement.entity.User;
import com.cts.bankmanagement.vo.UserVO;

@Repository("userDao")
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void updateUserDetails(UserVO userVO) {
		sessionFactory.getCurrentSession()
				.createQuery("update User set accountBalance = :accountBalance where accountNumber = :accountNumber")
				.setParameter("accountBalance", userVO.getAccountBalance())
				.setParameter("accountNumber", userVO.getAccountNumber()).executeUpdate();
	}

	@Override
	public Long addUserDetails(UserVO userVO) {
		User user = prepareUser(userVO);
		Long accountNumber = (Long) sessionFactory.getCurrentSession().save(user);
		return accountNumber;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserVO> getUsersDetails() {
		List<User> users = sessionFactory.getCurrentSession().createCriteria(User.class).list();
		List<UserVO> usersVO = new ArrayList<UserVO>(users.size());
		for (User user : users) {
			usersVO.add(prepareUserVO(user));
		}
		return usersVO;
	}

	@Override
	public UserVO getUserDetails(Long accountNo) {
		return prepareUserVO((User) sessionFactory.getCurrentSession().get(User.class, accountNo));
	}

	@Override
	public Long getCount(Long accountNo) {
		return (Long) sessionFactory.getCurrentSession()
				.createQuery("select count(*) from User where accountNumber = :accountNumber")
				.setParameter("accountNumber", accountNo).uniqueResult();
	}

	private User prepareUser(UserVO userVO) {
		return new User(userVO.getAccountNumber(), userVO.getAccountType(), userVO.getAccountHolderName(),
				userVO.getAccountBalance());
	}

	@Override
	public UserVO prepareUserVO(User user) {
		if (user == null) {
			return null;
		}
		return new UserVO(user.getAccountNumber(), user.getAccountType(), user.getAccountHolderName(),
				user.getAccountBalance());
	}

}
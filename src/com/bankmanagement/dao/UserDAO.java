package com.bankmanagement.dao;

import java.util.List;

import com.bankmanagement.vo.UserVO;

public interface UserDAO {
	Long addUserDetails(UserVO user);

	List<UserVO> getUsersDetails();

	UserVO getUserDetails(Long accountNo);

	Long getCount(Long accountNo);

	void updateUserDetails(UserVO userVO);
}
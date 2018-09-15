package com.cts.bankmanagement.vo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

public class TransactionVO {

	@Range(min = 1000000000000000l, max = 9999999999999999l, message = "Account number should have 16 digits")
	private Long accountNumber;
	private Long transactionId;

	@NotNull(message = "Account holder name can't be empty")
	@Size(min = 8, max = 16, message = "Account holder name should have between 8 and 16 characters")
	private String customerName;

	@Pattern(regexp = "(?i)Deposit|(?i)Withdrawal", message = "Empty or invalid transaction type")
	private String transactionType;

	@NotNull(message = "Transaction Amount should be greater 0")
	@Range(min = 1, message = "Transaction Amount should be greater 0")
	private Double transactionAmount;
	private String description;
	private Double accountBalance;
	private UserVO userVO;

	public TransactionVO() {
		super();
	}

	public TransactionVO(Long transactionId, UserVO userVO, String description, String transactionType,
			Double transactionAmount) {
		super();
		this.transactionId = transactionId;
		this.userVO = new UserVO(userVO.getAccountNumber(), userVO.getAccountType(), userVO.getAccountHolderName(),
				userVO.getAccountBalance());
		this.transactionAmount = transactionAmount;
		this.accountNumber = this.userVO.getAccountNumber();
		this.transactionType = transactionType;
		this.description = description;
	}

	
	public TransactionVO(Long accountNumber, String customerName, String transactionType, Double transactionAmount,
			String description) {
		super();
		this.accountNumber = accountNumber;
		this.customerName = customerName;
		this.transactionType = transactionType;
		this.transactionAmount = transactionAmount;
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public UserVO getUserVO() {
		return userVO;
	}

	public void setUserVO(UserVO userVO) {
		this.userVO = userVO;
	}

	public TransactionVO(Long accountNumber, Long transactionId) {
		this.accountNumber = accountNumber;
		this.transactionId = transactionId;
	}

	public TransactionVO(Long transactionId, Long accountNumber, String description, String transactionType,
			Double accountBalance) {
		super();
		this.accountNumber = accountNumber;
		this.transactionId = transactionId;
		this.transactionType = transactionType;
		this.accountBalance = accountBalance;
		this.description = description;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public Double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(Double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public String getDesciption() {
		return description;
	}

	public void setDesciption(String desciption) {
		this.description = desciption;
	}

	public Double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(Double accountBalance) {
		this.accountBalance = accountBalance;
	}

}

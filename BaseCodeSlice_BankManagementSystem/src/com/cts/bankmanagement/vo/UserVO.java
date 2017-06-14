/**
 * This is our entity class and it corresponds to USER_DETAILS table in database
 * @author de007ra
 */

package com.cts.bankmanagement.vo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

public class UserVO {

	@Range(min = 1000000000000000l, max = 9999999999999999l, message = "Account number should have 16 digits")
	private Long accountNumber;

	@Pattern(regexp = "Salary|Saving", message = "Empty or invalid account type")
	private String accountType;

	@NotNull(message = "Account holder name can't be empty")
	@Size(min = 8, max = 16, message = "Account holder name should have between 8 and 16 characters")
	private String accountHolderName;

	@NotNull(message = "Account Balance name can't be empty")
	private Double accountBalance;

	private Long transactionId;
	private String description;
	
	@Pattern(regexp = "Deposit|Withrawal", message = "Empty or invalid transaction type")
	private String transactionType;

	public UserVO() {
		super();
	}

	public UserVO(Long accountNumber, String accountType, String accountHolderName, Double accountBalance) {
		super();
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.accountHolderName = accountHolderName;
		this.accountBalance = accountBalance;
	}

	public UserVO(Long transactionId, Long accountNumber, String desciption, String transactionType,
			Double accountBalance) {
		super();
		this.transactionId = transactionId;
		this.accountNumber = accountNumber;
		this.description = desciption;
		this.transactionType = transactionType;
		this.accountBalance = accountBalance;

	}

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public String getDesciption() {
		return description;
	}

	public void setDesciption(String desciption) {
		this.description = desciption;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public Double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(Double accountBalance) {
		this.accountBalance = accountBalance;
	}
}
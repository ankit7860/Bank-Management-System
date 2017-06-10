/**
 * This is our entity class and it corresponds to USER_DETAILS table in database
 * @author de007ra
 */

package com.bankmanagement.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TRANSACTION_DETAILS")
public class TransactionUser implements Serializable {

	private static final long serialVersionUID = 1898989899898L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "TRANSACTION_ID")
	private Long transactionId;

	@Column(name = "ACCOUNT_NUMBER")
	private Long accountNumber;

	@Column(name = "TRANSACTION_DESCRIPTION")
	private String description;

	@Column(name = "TRANSACTION_TYPE")
	private String transactionType;

	@Column(name = "TRANSACTION_BALANCE")
	private Double transactionAmount;

	public TransactionUser() {
		super();
	}

	public TransactionUser(Long transactionId, Long accountNumber, String description, String transactionType,
			Double transactionAmount) {
		super();
		this.transactionId = transactionId;
		this.accountNumber = accountNumber;
		this.description = description;
		this.transactionType = transactionType;
		this.transactionAmount = transactionAmount;
	}

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
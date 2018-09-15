/**
 * This is our entity class and it corresponds to USER_DETAILS table in database
 * @author de007ra
 */

package com.cts.bankmanagement.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TRANSACTION_DETAILS")
public class TransactionUser implements Serializable {

	private static final long serialVersionUID = 1898989899898L;

	@Id
	@Column(name = "TRANSACTION_ID")
	private Long transactionId;

	@ManyToOne
	@JoinColumn(name = "ACCOUNT_NUMBER")
	private User user;

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
		this.user = new User(accountNumber);
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
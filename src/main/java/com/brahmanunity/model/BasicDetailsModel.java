package com.brahmanunity.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity(name="BasicDetails")
public class BasicDetailsModel {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO,generator="native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name="id")
	private int id;
	
	@Column(name="candidateId")
	private int candidateId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="birthDate")
	private Date birthDate;
	
	@Column(name="height")
	private String height;
	
	@Column(name="education")
	private String education;
	
	@Column(name="income")
	private String income;
	
	@Column(name="lastLogin")
	private Date lastLogin;
	
	@Column(name="addressCount")
	private int addressCount;
	
	@Column(name="subscriptionDate")
	private Date subscriptionDate;
	
	@Column(name="payment")
	private String payment;
	
	@Column(name="status")
	private String status;
	
	@Column(name="transactionId")
    private String transactionId;
	
	@Column(name="registered")
	private String registered;
	
	public String getRegistered() {
		return registered;
	}

	public void setRegistered(String registered) {
		this.registered = registered;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public Date getSubscriptionDate() {
		return subscriptionDate;
	}

	public void setSubscriptionDate(Date subscriptionDate) {
		this.subscriptionDate = subscriptionDate;
	}

	public int getAddressCount() {
		return addressCount;
	}

	public void setAddressCount(int addressCount) {
		this.addressCount = addressCount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getIncome() {
		return income;
	}

	public void setIncome(String income) {
		this.income = income;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}
	
	
	

}

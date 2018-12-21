package com.brahmanunity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity(name="FamilyDetails")
public class FamilyDetailsModel {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO,generator="native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name="id")
	private int id;
	
	@Column(name="candidateId")
	private int candidateId;
	
	@Column(name="father")
	private String father;
	
	@Column(name="fatherDescription")
	private String fatherDescription;
	
	@Column(name="mother")
	private String mother;
	
	@Column(name="motherDescription")
	private String motherDescription;
	
	@Column(name="sisters")
	private String sisters;
	
	@Column(name="sisterDescription")
	private String sisterDescription;
	
	@Column(name="brothers")
	private String brothers;
	
	public String getBrothers() {
		return brothers;
	}

	public void setBrothers(String brothers) {
		this.brothers = brothers;
	}

	public String getBrotherDescription() {
		return brotherDescription;
	}

	public void setBrotherDescription(String brotherDescription) {
		this.brotherDescription = brotherDescription;
	}

	@Column(name="brotherDescription")
	private String brotherDescription;

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

	public String getFather() {
		return father;
	}

	public void setFather(String father) {
		this.father = father;
	}

	public String getFatherDescription() {
		return fatherDescription;
	}

	public void setFatherDescription(String fatherDescription) {
		this.fatherDescription = fatherDescription;
	}

	public String getMother() {
		return mother;
	}

	public void setMother(String mother) {
		this.mother = mother;
	}

	public String getMotherDescription() {
		return motherDescription;
	}

	public void setMotherDescription(String motherDescription) {
		this.motherDescription = motherDescription;
	}

	public String getSisters() {
		return sisters;
	}

	public void setSisters(String sisters) {
		this.sisters = sisters;
	}

	public String getSisterDescription() {
		return sisterDescription;
	}

	public void setSisterDescription(String sisterDescription) {
		this.sisterDescription = sisterDescription;
	}
	
}

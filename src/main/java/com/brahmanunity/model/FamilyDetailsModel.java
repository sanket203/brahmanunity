package com.brahmanunity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="FamilyDetails")
public class FamilyDetailsModel {

	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="candidateId")
	private int candidateid;
	
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCandidateid() {
		return candidateid;
	}

	public void setCandidateid(int candidateid) {
		this.candidateid = candidateid;
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

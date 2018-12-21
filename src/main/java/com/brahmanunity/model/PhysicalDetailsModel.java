package com.brahmanunity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;


@Entity(name="PhysicalDetails")
public class PhysicalDetailsModel {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO,generator="native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name="id")
	private int id;
	
	@Column(name="candidateId")
	private int candidateId;
	
	@Column(name="height")
	private String height;
	
	@Column(name="weight")
	private String weight;
	
	@Column(name="complexion")
	private String complexion;
	 
	@Column(name="bodyForm")
	private String bodyform;
	
	@Column(name="spects")
	private String spects;
	
	@Column(name="bloodGroup")
	private String bloodGroup;
	
	@Column(name="medicalSurgary")
	private String medicalSurgary;
	
	@Column(name="disability")
	private String disability;
	
	@Column(name="otherRemarks")
	private String otherRemarks;

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

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getComplexion() {
		return complexion;
	}

	public void setComplexion(String complexion) {
		this.complexion = complexion;
	}

	public String getBodyform() {
		return bodyform;
	}

	public void setBodyfom(String bodyform) {
		this.bodyform = bodyform;
	}

	public String getSpects() {
		return spects;
	}

	public void setSpects(String spects) {
		this.spects = spects;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getMedicalSurgary() {
		return medicalSurgary;
	}

	public void setMedicalSurgary(String medicalSurgary) {
		this.medicalSurgary = medicalSurgary;
	}

	public String getDisability() {
		return disability;
	}

	public void setDisability(String disability) {
		this.disability = disability;
	}

	public String getOtherRemarks() {
		return otherRemarks;
	}

	public void setOtherRemarks(String otherRemarks) {
		this.otherRemarks = otherRemarks;
	}
	
}

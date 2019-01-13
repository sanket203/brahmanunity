package com.brahmanunity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity(name="Expectations")
public class Expectations {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO,generator="native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name="id")
	private int id;
	
	@Column(name="candidateId")
	private int candidateId;
	
	@Column(name="minHeight")
	private String minHeight;
	
	@Column(name="maxHeight")
	private String maxHeight;
	
	@Column(name="minAge")
	private String minAge;
	
	@Column(name="maxAge")
	private String maxAge;
	
	@Column(name="subCaste")
	private String subCaste;
	
	@Column(name="degree")
	private String degree;
	
	@Column(name="workingLocation")
	private String workingLocation;
	
	@Column(name="parentsLocation")
	private String parentsLocation;
	
	@Column(name="packageLimit")
	private String packageLimit;
	
	@Column(name="patrikaMatching")
	private String patrikaMatching;
	
	@Column(name="other")
	private String other;

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

	public String getMinHeight() {
		return minHeight;
	}

	public void setMinHeight(String minHeight) {
		this.minHeight = minHeight;
	}

	public String getMaxHeight() {
		return maxHeight;
	}

	public void setMaxHeight(String maxHeight) {
		this.maxHeight = maxHeight;
	}

	public String getMinAge() {
		return minAge;
	}

	public void setMinAge(String minAge) {
		this.minAge = minAge;
	}

	public String getMaxAge() {
		return maxAge;
	}

	public void setMaxAge(String maxAge) {
		this.maxAge = maxAge;
	}

	public String getSubCaste() {
		return subCaste;
	}

	public void setSubCaste(String subCaste) {
		this.subCaste = subCaste;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getWorkingLocation() {
		return workingLocation;
	}

	public void setWorkingLocation(String workingLocation) {
		this.workingLocation = workingLocation;
	}

	public String getParentsLocation() {
		return parentsLocation;
	}

	public void setParentsLocation(String parentsLocation) {
		this.parentsLocation = parentsLocation;
	}

	public String getPackageLimit() {
		return packageLimit;
	}

	public void setPackageLimit(String packageLimit) {
		this.packageLimit = packageLimit;
	}

	public String getPatrikaMatching() {
		return patrikaMatching;
	}

	public void setPatrikaMatching(String patrikaMatching) {
		this.patrikaMatching = patrikaMatching;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}
	
	

}

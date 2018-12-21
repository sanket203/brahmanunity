package com.brahmanunity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity(name="Qualification")
public class QualificationModel {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO,generator="native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name="id")
	private int id;
	
	@Column(name="candidateId")
	private int candidateId;
	
	@Column(name="degree")
	private String degree;
	
	@Column(name="passYear")
	private String passYear;
	
	@Column(name="college")
	private String college;
	
	@Column(name="university")
	private String university;
	
	@Column(name="stream")
	private String stream;
	
	@Column(name="remarks")
	private String remarks;

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

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getPassYear() {
		return passYear;
	}

	public void setPassYear(String passYear) {
		this.passYear = passYear;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public String getStream() {
		return stream;
	}

	public void setStream(String stream) {
		this.stream = stream;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	
}

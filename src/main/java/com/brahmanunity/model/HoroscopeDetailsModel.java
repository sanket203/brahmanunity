package com.brahmanunity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="HoroscopeDetails")
public class HoroscopeDetailsModel {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="candidateId")
	private int candidateId;
	
	@Column(name="caste")
	private String caste;
	
	@Column(name="subCaste")
	private String subCaste;
	
	@Column(name="shakha")
	private String shakha;
	
	@Column(name="rashi")
	private String rashi;
	
	@Column(name="nakshatra")
	private String nakshatra;
	
	@Column(name="naadi")
	private String naadi;
	
	@Column(name="gana")
	private String gana;
	
	@Column(name="charan")
	private String charan;
	
	@Column(name="gotra")
	private String gotra;
	
	@Column(name="mangal")
	private String mangal;
	
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

	public String getCaste() {
		return caste;
	}

	public void setCaste(String caste) {
		this.caste = caste;
	}

	public String getSubCaste() {
		return subCaste;
	}

	public void setSubCaste(String subCaste) {
		this.subCaste = subCaste;
	}

	public String getShakha() {
		return shakha;
	}

	public void setShakha(String shakha) {
		this.shakha = shakha;
	}

	public String getRashi() {
		return rashi;
	}

	public void setRashi(String rashi) {
		this.rashi = rashi;
	}

	public String getNakshatra() {
		return nakshatra;
	}

	public void setNakshatra(String nakshatra) {
		this.nakshatra = nakshatra;
	}

	public String getNaadi() {
		return naadi;
	}

	public void setNaadi(String naadi) {
		this.naadi = naadi;
	}

	public String getGana() {
		return gana;
	}

	public void setGana(String gana) {
		this.gana = gana;
	}

	public String getCharan() {
		return charan;
	}

	public void setCharan(String charan) {
		this.charan = charan;
	}

	public String getGotra() {
		return gotra;
	}

	public void setGotra(String gotra) {
		this.gotra = gotra;
	}

	public String getMangal() {
		return mangal;
	}

	public void setMangal(String mangal) {
		this.mangal = mangal;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
}

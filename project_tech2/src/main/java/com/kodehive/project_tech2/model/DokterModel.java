package com.kodehive.project_tech2.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="t_dokter")
public class DokterModel {

	@Id
	@Column(name="kodeDokter")
	private String kodeDokter;
	
	@Column(name="namaDokter")
	private String namaDokter;
	
	@Column(name="specialistDokter")
	private String specialistDokter;
	
	@Column(name="salaryDokter")
	private int salaryDokter;

	@OneToMany(mappedBy = "dokterPasien")
	private List<PasienModel> pasienModel;
	
	public String getKodeDokter() {
		return kodeDokter;
	}

	public void setKodeDokter(String kodeDokter) {
		this.kodeDokter = kodeDokter;
	}

	public String getNamaDokter() {
		return namaDokter;
	}

	public void setNamaDokter(String namaDokter) {
		this.namaDokter = namaDokter;
	}

	public String getSpecialistDokter() {
		return specialistDokter;
	}

	public void setSpecialistDokter(String specialistDokter) {
		this.specialistDokter = specialistDokter;
	}

	public int getSalaryDokter() {
		return salaryDokter;
	}

	public void setSalaryDokter(int salaryDokter) {
		this.salaryDokter = salaryDokter;
	}

	
	
	
}

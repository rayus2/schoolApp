package com.kodehive.project_tech2.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="t_pasien")
public class PasienModel {
	
	@Id
	@Column(name="noPasien")
	private String noPasien;
	
	@Column(name="namaPasien")
	private String namaPasien;

	@Column(name="genderPasien")
	private String genderPasien;
	
	@Column(name="kategoriPasien")
	private String kategoriPasien;
	
	@Column(name="biayaPasien")
	private int biayaPasien;

	@Column(name="ttlPasien")
	private Date ttlPasien;
	
	@Id
	@ManyToOne
	@PrimaryKeyJoinColumn(name="dokter", referencedColumnName="kodeDokter")
	private DokterModel dokterModel;

	public String getNoPasien() {
		return noPasien;
	}

	public void setNoPasien(String noPasien) {
		this.noPasien = noPasien;
	}

	public String getNamaPasien() {
		return namaPasien;
	}

	public void setNamaPasien(String namaPasien) {
		this.namaPasien = namaPasien;
	}

	public String getGenderPasien() {
		return genderPasien;
	}

	public void setGenderPasien(String genderPasien) {
		this.genderPasien = genderPasien;
	}

	public String getKategoriPasien() {
		return kategoriPasien;
	}

	public void setKategoriPasien(String kategoriPasien) {
		this.kategoriPasien = kategoriPasien;
	}

	public int getBiayaPasien() {
		return biayaPasien;
	}

	public void setBiayaPasien(int biayaPasien) {
		this.biayaPasien = biayaPasien;
	}

	public Date getTtlPasien() {
		return ttlPasien;
	}

	public void setTtlPasien(Date ttlPasien) {
		this.ttlPasien = ttlPasien;
	}

	
}

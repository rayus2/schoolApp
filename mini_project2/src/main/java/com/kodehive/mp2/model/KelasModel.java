package com.kodehive.mp2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_kelas")
public class KelasModel {
	
	@Id
	@Column(name="kode_kelas")
	private String kode_kelas;
	
	@Column(name="nama_kelas")
	private String nama_kelas;
	
	@Column(name="tingkat_kelas")
	private String tingkat_kelas;
	
	@Column(name="wali_kelas")
	private String wali_kelas;
	
	@Column(name="ruang_kelas")
	private String ruang_kelas;

	public String getKode_kelas() {
		return kode_kelas;
	}

	public void setKode_kelas(String kode_kelas) {
		this.kode_kelas = kode_kelas;
	}

	public String getNama_kelas() {
		return nama_kelas;
	}

	public void setNama_kelas(String nama_kelas) {
		this.nama_kelas = nama_kelas;
	}

	public String getTingkat_kelas() {
		return tingkat_kelas;
	}

	public void setTingkat_kelas(String tingkat_kelas) {
		this.tingkat_kelas = tingkat_kelas;
	}

	public String getWali_kelas() {
		return wali_kelas;
	}

	public void setWali_kelas(String wali_kelas) {
		this.wali_kelas = wali_kelas;
	}

	public String getRuang_kelas() {
		return ruang_kelas;
	}

	public void setRuang_kelas(String ruang_kelas) {
		this.ruang_kelas = ruang_kelas;
	}
	
}

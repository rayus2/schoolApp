package com.kodehive.mp2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_guru")
public class GuruModel {
	
	@Id
	@Column(name="nip_guru")
	private String nip_guru;
	
	@Column(name="nama_guru")
	private String nama_guru;
	
	@Column(name="telepon_guru")
	private String telepon_guru;
	
	@Column(name="gender_guru")
	private String gender_guru;
	
	@Column(name="gelar_guru")
	private String gelar_guru;
	
	@Column(name="alamat_guru")
	private String alamat_guru;

	public String getNip_guru() {
		return nip_guru;
	}

	public void setNip_guru(String nip_guru) {
		this.nip_guru = nip_guru;
	}

	public String getNama_guru() {
		return nama_guru;
	}

	public void setNama_guru(String nama_guru) {
		this.nama_guru = nama_guru;
	}

	public String getTelepon_guru() {
		return telepon_guru;
	}

	public void setTelepon_guru(String telepon_guru) {
		this.telepon_guru = telepon_guru;
	}

	public String getGender_guru() {
		return gender_guru;
	}

	public void setGender_guru(String gender_guru) {
		this.gender_guru = gender_guru;
	}

	public String getGelar_guru() {
		return gelar_guru;
	}

	public void setGelar_guru(String gelar_guru) {
		this.gelar_guru = gelar_guru;
	}

	public String getAlamat_guru() {
		return alamat_guru;
	}

	public void setAlamat_guru(String alamat_guru) {
		this.alamat_guru = alamat_guru;
	}
	
	

}

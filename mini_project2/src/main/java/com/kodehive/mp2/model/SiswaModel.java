package com.kodehive.mp2.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="t_siswa")
public class SiswaModel {
	
	@Id
	@Column(name="nim_siswa")
	private String nim_siswa;
	
	@Column(name="nama_siswa")
	private String nama_siswa;
	
	@Column(name="gender_siswa")
	private String gender_siswa;

	@DateTimeFormat(pattern="dd-MMMM-yyyy")
	@Column(name="tgllahir_siswa")
	private Date tgllahir_siswa;

	@Column(name="tempatlahir_siswa")
	private String tempatlahir_siswa;
	
	@Column(name="wali_siswa")
	private String wali_siswa;

	@Column(name="pekerjaan_wali_siswa")
	private String pekerjaan_wali_siswa;

	@Column(name="telp_wali_siswa")
	private String telp_wali_siswa;

	@Column(name="alamat_siswa")
	private String alamat_siswa;
	
	@Column(name="kelas_siswa")
	private String kelas_siswa;


	public String getNim_siswa() {
		return nim_siswa;
	}

	public void setNim_siswa(String nim_siswa) {
		this.nim_siswa = nim_siswa;
	}

	public String getNama_siswa() {
		return nama_siswa;
	}

	public void setNama_siswa(String nama_siswa) {
		this.nama_siswa = nama_siswa;
	}

	public String getGender_siswa() {
		return gender_siswa;
	}

	public void setGender_siswa(String gender_siswa) {
		this.gender_siswa = gender_siswa;
	}

	public Date getTgllahir_siswa() {
		return tgllahir_siswa;
	}

	public void setTgllahir_siswa(Date tgllahir_siswa) {
		this.tgllahir_siswa = tgllahir_siswa;
	}

	public String getTempatlahir_siswa() {
		return tempatlahir_siswa;
	}

	public void setTempatlahir_siswa(String tempatlahir_siswa) {
		this.tempatlahir_siswa = tempatlahir_siswa;
	}

	public String getWali_siswa() {
		return wali_siswa;
	}

	public void setWali_siswa(String wali_siswa) {
		this.wali_siswa = wali_siswa;
	}

	public String getPekerjaan_wali_siswa() {
		return pekerjaan_wali_siswa;
	}

	public void setPekerjaan_wali_siswa(String pekerjaan_wali_siswa) {
		this.pekerjaan_wali_siswa = pekerjaan_wali_siswa;
	}

	public String getTelp_wali_siswa() {
		return telp_wali_siswa;
	}

	public void setTelp_wali_siswa(String telp_wali_siswa) {
		this.telp_wali_siswa = telp_wali_siswa;
	}

	public String getAlamat_siswa() {
		return alamat_siswa;
	}

	public void setAlamat_siswa(String alamat_siswa) {
		this.alamat_siswa = alamat_siswa;
	}

	public String getKelas_siswa() {
		return kelas_siswa;
	}

	public void setKelas_siswa(String kelas_siswa) {
		this.kelas_siswa = kelas_siswa;
	}
	
	
}

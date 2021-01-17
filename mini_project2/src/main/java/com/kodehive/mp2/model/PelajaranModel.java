package com.kodehive.mp2.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_pelajaran")
public class PelajaranModel {

	@Id
	@Column(name="kode_pelajaran")
	private String kode_pelajaran;
	
	@Column(name="nama_pelajaran")
	private String nama_pelajaran;
	
	@Column(name="jam_ajar_pelajaran")
	private int jam_ajar_pelajaran;
	
	@Column(name="tingkat_pelajaran")
	private int tingkat_pelajaran;
	
	@Column(name="keterangan_pelajaran")
	private String keterangan_pelajaran;

	public String getKode_pelajaran() {
		return kode_pelajaran;
	}

	public void setKode_pelajaran(String kode_pelajaran) {
		this.kode_pelajaran = kode_pelajaran;
	}

	public String getNama_pelajaran() {
		return nama_pelajaran;
	}

	public void setNama_pelajaran(String nama_pelajaran) {
		this.nama_pelajaran = nama_pelajaran;
	}

	public int getJam_ajar_pelajaran() {
		return jam_ajar_pelajaran;
	}

	public void setJam_ajar_pelajaran(int jam_ajar_pelajaran) {
		this.jam_ajar_pelajaran = jam_ajar_pelajaran;
	}

	public int getTingkat_pelajaran() {
		return tingkat_pelajaran;
	}

	public void setTingkat_pelajaran(int tingkat_pelajaran) {
		this.tingkat_pelajaran = tingkat_pelajaran;
	}

	public String getKeterangan_pelajaran() {
		return keterangan_pelajaran;
	}

	public void setKeterangan_pelajaran(String keterangan_pelajaran) {
		this.keterangan_pelajaran = keterangan_pelajaran;
	}
	
}

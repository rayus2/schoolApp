package com.kodehive.mp2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_barang")

public class BarangModel {
	
	
	@Id
	@Column(name="kd_barang")
	private String kdBarang;
	
	@Column(name="nama_barang")
	private String namaBarang;
	
	@Column(name="satuan")
	private String satuan;
	
	@Column(name="harga_siswa")
	private long hargaSiswa;
	
	@Column(name="keterangan")
	private String keterangan;

	public String getKdBarang() {
		return kdBarang;
	}

	public void setKdBarang(String kdBarang) {
		this.kdBarang = kdBarang;
	}

	public String getNamaBarang() {
		return namaBarang;
	}

	public void setNamaBarang(String namaBarang) {
		this.namaBarang = namaBarang;
	}

	public String getSatuan() {
		return satuan;
	}

	public void setSatuan(String satuan) {
		this.satuan = satuan;
	}

	public long getHargaSiswa() {
		return hargaSiswa;
	}

	public void setHargaSiswa(long hargaSiswa) {
		this.hargaSiswa = hargaSiswa;
	}

	public String getKeterangan() {
		return keterangan;
	}

	public void setKeterangan(String keterangan) {
		this.keterangan = keterangan;
	}
	
	
	



}

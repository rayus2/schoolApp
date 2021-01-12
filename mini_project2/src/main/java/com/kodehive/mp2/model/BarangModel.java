package com.kodehive.mp2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="T_BARANG") 

public class BarangModel {
	
	@Id
	@Column(name="T_KD_BARANG")
	private String kdBarang;
	
	@Column(name="T_NAMA_BARANG")
	private String namaBarang;
	
	@Column(name="T_SATUAN")
	private String satuan;
	
	@Column(name="T_HARGA_SISWA")
	private long hargaSiswa;
	
	@Column(name="T_KETRANGAN")
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
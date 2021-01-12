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

	/**
	 * @return the kdBarang
	 */
	public String getKdBarang() {
		return kdBarang;
	}

	/**
	 * @param kdBarang the kdBarang to set
	 */
	public void setKdBarang(String kdBarang) {
		this.kdBarang = kdBarang;
	}

	/**
	 * @return the namaBarang
	 */
	public String getNamaBarang() {
		return namaBarang;
	}

	/**
	 * @param namaBarang the namaBarang to set
	 */
	public void setNamaBarang(String namaBarang) {
		this.namaBarang = namaBarang;
	}

	/**
	 * @return the satuan
	 */
	public String getSatuan() {
		return satuan;
	}

	/**
	 * @param satuan the satuan to set
	 */
	public void setSatuan(String satuan) {
		this.satuan = satuan;
	}

	/**
	 * @return the hargaSiswa
	 */
	public long getHargaSiswa() {
		return hargaSiswa;
	}

	/**
	 * @param hargaSiswa the hargaSiswa to set
	 */
	public void setHargaSiswa(long hargaSiswa) {
		this.hargaSiswa = hargaSiswa;
	}

	/**
	 * @return the keterangan
	 */
	public String getKeterangan() {
		return keterangan;
	}

	/**
	 * @param keterangan the keterangan to set
	 */
	public void setKeterangan(String keterangan) {
		this.keterangan = keterangan;
	}
	
	
	

}
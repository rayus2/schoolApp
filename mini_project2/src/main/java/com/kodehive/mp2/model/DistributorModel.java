package com.kodehive.mp2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="T_DISTRIBUTOR") 

public class DistributorModel {
	
	
	@Id
	@Column(name="T_KD_DISTRIBUTOR")
	private String kdDistributor;
	
	@Column(name="T_NAMA_DISTRIBUTOR")
	private String namaDistributor;
	
	@Column(name="T_TIPE_DISTRIBUTOR")
	private String tipeDistributor;
	
	@Column(name="T_TELEPON")
	private String telepon;
	
	@Column(name="T_ALAMAT")
	private String alamat;

	public String getKdDistributor() {
		return kdDistributor;
	}

	public void setKdDistributor(String kdDistributor) {
		this.kdDistributor = kdDistributor;
	}

	public String getNamaDistributor() {
		return namaDistributor;
	}

	public void setNamaDistributor(String namaDistributor) {
		this.namaDistributor = namaDistributor;
	}

	public String getTipeDistributor() {
		return tipeDistributor;
	}

	public void setTipeDistributor(String tipeDistributor) {
		this.tipeDistributor = tipeDistributor;
	}

	public String getTelepon() {
		return telepon;
	}

	public void setTelepon(String telepon) {
		this.telepon = telepon;
	}

	public String getAlamat() {
		return alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}
	
	
	
	
	

}

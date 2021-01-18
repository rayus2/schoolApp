package com.kodehive.mp2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_distributor") 

public class DistributorModel {
	
	
	@Id
	@Column(name="kd_distributor")
	private String kdDistributor;
	
	@Column(name="nama_distributor")
	private String namaDistributor;
	
	@Column(name="tipe_distributor")
	private String tipeDistributor;
	
	@Column(name="telepon")
	private String telepon;
	
	@Column(name="alamat")
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

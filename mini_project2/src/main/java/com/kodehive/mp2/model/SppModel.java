package com.kodehive.mp2.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="t_sppsiswa")
public class SppModel {

	@Id
	@Column(name="no_spp")
	private String no_spp;
	
	@Column(name="tgl_spp")
	private Date tgl_spp;
	
	@Column(name="bulan_spp")
	private String bulan_spp;
	
	@Column(name="tahunajar_spp")
	private String tahunajar_spp;
	
	@Column(name="jumlah_spp")
	private int jumlah_spp;
	
	@Column(name="tipebayar_spp")
	private String tipebayar_spp;
	
	@Column(name="bayar_spp")
	private int bayar_spp;

	@Column(name="kembalian_spp")
	private int kembalian_spp;

	@OneToMany(targetEntity=SiswaModel.class, cascade = CascadeType.ALL)
	@JoinColumn(name="siswa_spp", referencedColumnName="no_spp")
	private List<SiswaModel> siswaModel;
	
	public String getNo_spp() {
		return no_spp;
	}

	public void setNo_spp(String no_spp) {
		this.no_spp = no_spp;
	}

	public Date getTgl_spp() {
		return tgl_spp;
	}

	public void setTgl_spp(Date tgl_spp) {
		this.tgl_spp = tgl_spp;
	}

	public String getBulan_spp() {
		return bulan_spp;
	}

	public void setBulan_spp(String bulan_spp) {
		this.bulan_spp = bulan_spp;
	}

	public String getTahunajar_spp() {
		return tahunajar_spp;
	}

	public void setTahunajar_spp(String tahunajar_spp) {
		this.tahunajar_spp = tahunajar_spp;
	}

	public int getJumlah_spp() {
		return jumlah_spp;
	}

	public void setJumlah_spp(int jumlah_spp) {
		this.jumlah_spp = jumlah_spp;
	}

	public String getTipebayar_spp() {
		return tipebayar_spp;
	}

	public void setTipebayar_spp(String tipebayar_spp) {
		this.tipebayar_spp = tipebayar_spp;
	}

	public int getBayar_spp() {
		return bayar_spp;
	}

	public void setBayar_spp(int bayar_spp) {
		this.bayar_spp = bayar_spp;
	}

	public int getKembalian_spp() {
		return kembalian_spp;
	}

	public void setKembalian_spp(int kembalian_spp) {
		this.kembalian_spp = kembalian_spp;
	}
	
	
}

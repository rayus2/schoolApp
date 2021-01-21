package com.kodehive.mp2.model;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="t_jadwalguru")
public class PenjadwalanModel {
	
	@Id
	@Column(name="no_sk")
	private String no_sk;
	
	@Column(name="tgl_jadwal")
	private Date tgl_jadwal;
		
	@OneToMany(targetEntity=SiswaModel.class, cascade = CascadeType.ALL)
	@JoinColumn(name="guru_pelajaran_jadwal", referencedColumnName="no_sk")
	private List<PelajaranModel> pelajaranModel;
	
	@OneToMany(targetEntity=GuruModel.class, cascade = CascadeType.ALL)
	@JoinColumn(name="guru_jadwal", referencedColumnName="no_sk")
	private List<GuruModel> guruModel;
	
	@Column(name="hari")
	private String hari;
	
	@OneToMany(targetEntity=KelasModel.class, cascade = CascadeType.ALL)
	@JoinColumn(name="kelas_jadwal", referencedColumnName="no_sk")
	private List<KelasModel> kelasModel;
		
	@Column(name="jam_mulai")
	private Time jam_mulai;	
	
	@Column(name="jam_akhir")
	private Time jam_akhir;
	
	@Column(name="kurikulum")
	private String kurikulum;
	

	public String getNo_sk() {
		return no_sk;
	}

	public void setNo_sk(String no_sk) {
		this.no_sk = no_sk;
	}

	public Date getTgl_jadwal() {
		return tgl_jadwal;
	}

	public void setTgl_jadwal(Date tgl_jadwal) {
		this.tgl_jadwal = tgl_jadwal;
	}

	public List<PelajaranModel> getPelajaranModel() {
		return pelajaranModel;
	}

	public void setPelajaranModel(List<PelajaranModel> pelajaranModel) {
		this.pelajaranModel = pelajaranModel;
	}

	public List<GuruModel> getGuruModel() {
		return guruModel;
	}

	public void setGuruModel(List<GuruModel> guruModel) {
		this.guruModel = guruModel;
	}

	public String getKurikulum() {
		return kurikulum;
	}

	public void setKurikulum(String kurikulum) {
		this.kurikulum = kurikulum;
	}

	public Time getJam_mulai() {
		return jam_mulai;
	}

	public void setJam_mulai(Time jam_mulai) {
		this.jam_mulai = jam_mulai;
	}

	public Time getJam_akhir() {
		return jam_akhir;
	}

	public void setJam_akhir(Time jam_akhir) {
		this.jam_akhir = jam_akhir;
	}
	
	
	
}

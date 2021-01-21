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
@Table(name="t_nilaisiswa")
public class NilaiModel {
	
	@Id
	@Column(name="kode_nilai")
	private String kode_nilai;
	
	@Column(name="tgl_ujian")
	private Date tgl_ujian;
	
	@Column(name="tgl_penilaian")
	private Date tgl_penilaian;
	
	@OneToMany(targetEntity=SiswaModel.class, cascade = CascadeType.ALL)
	@JoinColumn(name="siswa_pelajaran", referencedColumnName="kode_nilai")
	private List<PelajaranModel> pelajaranModel;
	
	@Column(name="tipe_ujian")
	private String tipe_ujian;
	
	@OneToMany(targetEntity=SiswaModel.class, cascade = CascadeType.ALL)
	@JoinColumn(name="siswa_nilai", referencedColumnName="kode_nilai")
	private List<SiswaModel> siswaModel;
	
	@Column(name="nilai_ujian")
	private String nilai_ujian;
	
	@Column(name="keterangan_ujian")
	private String keterangan_ujian;

	public String getKode_nilai() {
		return kode_nilai;
	}

	public void setKode_nilai(String kode_nilai) {
		this.kode_nilai = kode_nilai;
	}

	public Date getTgl_ujian() {
		return tgl_ujian;
	}

	public void setTgl_ujian(Date tgl_ujian) {
		this.tgl_ujian = tgl_ujian;
	}

	public Date getTgl_penilaian() {
		return tgl_penilaian;
	}

	public void setTgl_penilaian(Date tgl_penilaian) {
		this.tgl_penilaian = tgl_penilaian;
	}

	public List<PelajaranModel> getPelajaranModel() {
		return pelajaranModel;
	}

	public void setPelajaranModel(List<PelajaranModel> pelajaranModel) {
		this.pelajaranModel = pelajaranModel;
	}

	public String getTipe_ujian() {
		return tipe_ujian;
	}

	public void setTipe_ujian(String tipe_ujian) {
		this.tipe_ujian = tipe_ujian;
	}

	public List<SiswaModel> getSiswaModel() {
		return siswaModel;
	}

	public void setSiswaModel(List<SiswaModel> siswaModel) {
		this.siswaModel = siswaModel;
	}

	public String getNilai_ujian() {
		return nilai_ujian;
	}

	public void setNilai_ujian(String nilai_ujian) {
		this.nilai_ujian = nilai_ujian;
	}

	public String getKeterangan_ujian() {
		return keterangan_ujian;
	}

	public void setKeterangan_ujian(String keterangan_ujian) {
		this.keterangan_ujian = keterangan_ujian;
	}
	
	
	
}

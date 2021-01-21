package com.kodehive.mp2.model;

import java.util.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "jadwal")
public class JadwalModel_Transaksi {
    @Id
    @Column(name = "id")
    private String id;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "nip_guru")
    private GuruModel guruModel;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "kode_pelajaran")
    private PelajaranModel pelajaranModel;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "kode_kelas")
    private KelasModel kelasModel;
    
    @Column(name = "date")
    private Date date;
    
    @Column(name = "hari")
    private String hari;
    
    @Column(name = "jam_mulai")
    private Time jam_mulai;
    
    @Column(name = "jam_akhir")
    private Time jam_akhir;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public GuruModel getGuruModel() {
		return guruModel;
	}

	public void setGuruModel(GuruModel guruModel) {
		this.guruModel = guruModel;
	}

	public PelajaranModel getPelajaranModel() {
		return pelajaranModel;
	}

	public void setPelajaranModel(PelajaranModel pelajaranModel) {
		this.pelajaranModel = pelajaranModel;
	}

	public KelasModel getKelasModel() {
		return kelasModel;
	}

	public void setKelasModel(KelasModel kelasModel) {
		this.kelasModel = kelasModel;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getHari() {
		return hari;
	}

	public void setHari(String hari) {
		this.hari = hari;
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

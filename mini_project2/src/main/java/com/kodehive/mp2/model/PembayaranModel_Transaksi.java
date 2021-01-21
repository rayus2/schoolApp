package com.kodehive.mp2.model;


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
@Table(name = "pembayaran")
public class PembayaranModel_Transaksi {
    @Id
    @Column(name = "id")
    private String id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "kdBarang")
    private BarangModel barangModel;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "nim_siswa")
    private SiswaModel siswaModel;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BarangModel getBarangModel() {
		return barangModel;
	}

	public void setBarangModel(BarangModel barangModel) {
		this.barangModel = barangModel;
	}

	public SiswaModel getSiswaModel() {
		return siswaModel;
	}

	public void setSiswaModel(SiswaModel siswaModel) {
		this.siswaModel = siswaModel;
	}
    
	// others using generate setters in edit/ sources
    


}
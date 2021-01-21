package com.kodehive.mp2.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kodehive.mp2.dto.PenjadwalanDTO_Transaksi;
import com.kodehive.mp2.model.GuruModel;
import com.kodehive.mp2.model.JadwalModel_Transaksi;
import com.kodehive.mp2.repo.GuruRepository;
import com.kodehive.mp2.repo.JadwalRepository_Transaksi;
import com.kodehive.mp2.repo.KelasRepository;
import com.kodehive.mp2.repo.PelajaranRepo;

@Service
@Transactional
public class JadwalService_Transaksi {
	
	@Autowired
    private GuruRepository guruRepository;
	
	@Autowired
	private PelajaranRepo pelajaranRepository;
	
	@Autowired
	private KelasRepository kelasRepository;
	
	@Autowired
	private JadwalRepository_Transaksi jadwalanRepository;

	public JadwalModel_Transaksi saveJadwal(PenjadwalanDTO_Transaksi penjadwalanDTO) {
		// TODO Auto-generated method stub
        JadwalModel_Transaksi jadwalModel = new JadwalModel_Transaksi();
        GuruModel guruModel = guruRepository.getId(penjadwalanDTO.getNip_guru());
        jadwalModel.setGuruModel(guruModel);
        jadwalModel.setDate(new Date());
        

        return jadwalanRepository.save(jadwalModel);
	}

	public List<JadwalModel_Transaksi> findAll() {
		// TODO Auto-generated method stub
		return jadwalanRepository.findAll();
	}

	public void deleteProduct(String nip_guru) {
		// TODO Auto-generated method stub
		jadwalanRepository.deleteById(nip_guru);
	}

	public void submitJadwal(String id) {
		// TODO Auto-generated method stub
		 JadwalModel_Transaksi jadwalModel = jadwalanRepository.getId(id);
		 jadwalModel.setId("PURCHASED");
	     jadwalanRepository.save(jadwalModel);
	}



}

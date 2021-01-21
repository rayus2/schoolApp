package com.kodehive.mp2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kodehive.mp2.dto.PenjadwalanDTO_Transaksi;
import com.kodehive.mp2.model.JadwalModel_Transaksi;
import com.kodehive.mp2.service.JadwalService_Transaksi;

@RestController
@RequestMapping("/jadwal")
public class JadwalController_Transaksi {
	
	 @Autowired
	 private JadwalService_Transaksi jadwalService;
	 
	 
	    @RequestMapping(method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	    public JadwalModel_Transaksi addGuruItem(@RequestBody PenjadwalanDTO_Transaksi penjadwalanDTO) {
	        return jadwalService.saveJadwal(penjadwalanDTO);
	    }


	    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
	    public List<JadwalModel_Transaksi> getAll(){
	        return jadwalService.findAll();
	    }


	    @RequestMapping(method = RequestMethod.DELETE, value ="/{nip_guru}")
	    public void deleteItem(@PathVariable("nip_guru") String nip_guru) {
	    	jadwalService.deleteProduct(nip_guru);
	    }

	    @RequestMapping(method = RequestMethod.POST, value = "/submit/{nip_guru}")
	    public void submitJadwal(@PathVariable("nip_guru") String nip_guru) {
	    	jadwalService.submitJadwal(nip_guru);
	    }
}

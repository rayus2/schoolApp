package com.kodehive.mp2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kodehive.mp2.dto.PembayaranDTO_Transaksi;
import com.kodehive.mp2.model.PembayaranModel_Transaksi;
import com.kodehive.mp2.service.PembayaranService_Transaksi;



@RestController
@RequestMapping("/pembayaran")
public class PembayaranController_Transaksi {

	 @Autowired
	 private PembayaranService_Transaksi pembayaranService;


	    @RequestMapping(method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	    public PembayaranModel_Transaksi addBarangItem(@RequestBody PembayaranDTO_Transaksi pembayaranDTO) {
	        return pembayaranService.savePembayaran(pembayaranDTO);
	    }


	    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
	    public List<PembayaranModel_Transaksi> getAll(){
	        return pembayaranService.findAll();
	    }


	    @RequestMapping(method = RequestMethod.DELETE, value ="/{kdBarang}")
	    public void deleteItem(@PathVariable("kdBarang") String kdBarang) {
	    	pembayaranService.deleteProduct(kdBarang);
	    }

	    @RequestMapping(method = RequestMethod.POST, value = "/submit/{kdBarang}")
	    public void submitPembayaran(@PathVariable("kdBarang") String kdBarang) {
	    	pembayaranService.submitPembayaran(kdBarang);
	    }
}
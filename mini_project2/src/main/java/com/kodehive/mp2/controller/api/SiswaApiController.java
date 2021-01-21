package com.kodehive.mp2.controller.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kodehive.mp2.model.SiswaModel;
import com.kodehive.mp2.model.SppModel;
import com.kodehive.mp2.service.SiswaService;
import com.kodehive.mp2.service.SppRequest;

@RestController
public class SiswaApiController {

	@Autowired
	private SiswaService siswaService;
	
	@Autowired
	private SppRequest sppRequest;
	
	
	@PostMapping("/siswa/api_post")
	public Map<String, Object> post_siswa(@RequestBody SiswaModel siswaModel){
		
		this.siswaService.tambah_data(siswaModel);
		Map<String, Object> map = new HashMap<String, Object>();
	
		map.put("Success", Boolean.TRUE);
		map.put("Pesan", "Data Berhasil Ditambahkan");
		
		return map;
	}
	
	@GetMapping("/siswa/api_get")
	public Page<SiswaModel> getAll_siswa(Pageable pageable){
		
		Page<SiswaModel> siswaModelList = this.siswaService.listSiswa(pageable);
		
		return siswaModelList;
	}
	
	@GetMapping("/siswa/api_getById")
	public SiswaModel getById_siswa(@RequestParam String nim_siswa){
		
		SiswaModel siswaModel = new SiswaModel();
		siswaModel = this.siswaService.detail_data(nim_siswa);
		
		return siswaModel;
	}
	
	@PutMapping("/siswa/api_put")
	public Map<String, Object> put_siswa(@RequestBody SiswaModel siswaModel){
		
		this.siswaService.save_edit(siswaModel);
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("Success", Boolean.TRUE);
		map.put("Pesan", "Data Berhasil Di Update");
		
		return map;
	}
	
	@DeleteMapping("/siswa/api_delete")
	public Map<String, Object> delete_siswa(@RequestParam String nim_siswa) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		this.siswaService.delete_data(nim_siswa);
		map.put("Success", Boolean.TRUE);
		map.put("Pesan", "Data Berhasil Di Hapus");
		
		return map;
	}
	
	@PostMapping("/transaksi/spp")
	public Map<String, Object> transaksi_spp(@RequestBody SppModel sppModel) {
		
		this.sppRequest.saveRequest(sppModel);
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("Success", Boolean.TRUE);
		map.put("Pesan", "Data Berhasil Ditambahkan");
		
		return map;
	}
	
	@GetMapping("/transaksi/siswa")
	public List<SiswaModel> getSiswa(SiswaModel siswaModel) {
		
		List<SiswaModel> siswaModelList = new ArrayList<SiswaModel>();
		siswaModelList = this.siswaService.siswaTransaksi();
		
		return siswaModelList;
	}
}

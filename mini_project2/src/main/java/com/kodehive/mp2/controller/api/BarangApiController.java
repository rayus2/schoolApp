package com.kodehive.mp2.controller.api;

import java.util.HashMap;
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

import com.kodehive.mp2.model.BarangModel;
import com.kodehive.mp2.service.BarangService;

  
@RestController
public class BarangApiController {
	
	@Autowired
	private BarangService barangService;
	
	
	@PostMapping("/barang/api_post")
	public Map<String, Object> post_barang(@RequestBody BarangModel barangModel) { 

		this.barangService.tambah_data(barangModel);
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("success", Boolean.TRUE);
		map.put("pesan","data barang berhasil ditambahkan");
		
		return map;
	}  
	
	@GetMapping("/barang/api_get")
	public Page<BarangModel> getAll_barang(Pageable pageable){
		
		Page<BarangModel> barangModelList = this.barangService.listBarang(pageable);
		
		return barangModelList;
	}
	
	@GetMapping("/barang/api_getById")
	public BarangModel getByKdBarang(@RequestParam String kdBarang){
		
		BarangModel barangModel = new BarangModel();
		barangModel = this.barangService.detail_data(kdBarang);
		
		return barangModel;
	}
	
	
	@PutMapping("/barang/api_put")
	public Map<String, Object> put_barang(@RequestBody BarangModel barangModel){
		
		this.barangService.save_edit(barangModel);
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("success", Boolean.TRUE);
		map.put("pesan", "data barang berhasil di update");
		
		return map;
	}
	
	@DeleteMapping("/barang/api_delete")
	public Map<String, Object> delete_barang(@RequestParam String kdBarang) {
		this.barangService.delete_data(kdBarang);
		
		Map<String, Object> map = new HashMap<String, Object>();		
		map.put("success", Boolean.TRUE);
		map.put("pesan", "data barang berhasil di hapus");
		
		return map;
	}

}

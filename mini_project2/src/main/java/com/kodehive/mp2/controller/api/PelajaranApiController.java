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

import com.kodehive.mp2.model.PelajaranModel;
import com.kodehive.mp2.service.PelajaranService;

@RestController
public class PelajaranApiController {

	@Autowired
	private PelajaranService pelajaranService;
	
	@PostMapping("/pelajaran/api_post")
	public Map<String, Object> post_pelajaran(@RequestBody PelajaranModel pelajaranModel){
		
		this.pelajaranService.tambah_data(pelajaranModel);
		Map<String, Object> map = new HashMap<String, Object>();
	
		map.put("Success", Boolean.TRUE);
		map.put("Pesan", "Data Berhasil Ditambahkan");
		
		return map;
	}
	
	@GetMapping("/pelajaran/api_get")
	public Page<PelajaranModel> getAll_pelajaran(Pageable pageable){
		
		 Page<PelajaranModel> pelajaranModelList = this.pelajaranService.listPelajaran(pageable);
		
		return pelajaranModelList;
	}
	
	@GetMapping("/pelajaran/api_getById")
	public PelajaranModel getById_pelajaran(@RequestParam String kode_pelajaran){
		
		PelajaranModel pelajaranModel = new PelajaranModel();
		pelajaranModel = this.pelajaranService.detail_data(kode_pelajaran);
		
		return pelajaranModel;
	}
	
	@PutMapping("/pelajaran/api_put")
	public Map<String, Object> put_pelajaran(@RequestBody PelajaranModel siswaModel){
		
		this.pelajaranService.save_edit(siswaModel);
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("Success", Boolean.TRUE);
		map.put("Pesan", "Data Berhasil Di Update");
		
		return map;
	}
	
	@DeleteMapping("/pelajaran/api_delete")
	public Map<String, Object> delete_pelajaran(@RequestParam String kode_pelajaran) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		this.pelajaranService.delete_data(kode_pelajaran);
		map.put("Success", Boolean.TRUE);
		map.put("Pesan", "Data Berhasil Di Hapus");
		
		return map;
	}
}

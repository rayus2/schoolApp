package com.kodehive.mp2.controller.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.kodehive.mp2.model.BarangModel;
import com.kodehive.mp2.service.BarangService;


public class BarangAPIController {
	
	/*
	 *       API   | CRUD   | QUERY 
	 * -------------------------------- 
	 *      POST   | CREATE | INSERT
	 *      GET    | READ   | SELECT
	 *      PUT    | UPDATE | UPDATE
	 *      DELETE | DELETE | DROP
	 *      
	 *      
	 */
	
	@Autowired
	private BarangService barangService;
	

	
	@PostMapping("/post")
	public Map<String, Object> postApi(@RequestBody BarangModel barangModel) {  //K untuk Key, V untuk Value

		this.barangService.barangSave(barangModel);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", Boolean.TRUE);
		map.put("pesan","data barang berhasil dimasukkan");
		
		return map;
	}  
	
	@GetMapping("/getAll")
	@ResponseStatus(code = HttpStatus.OK)
	public List<BarangModel> getApi(){
		
		List<BarangModel> barangModelList = new ArrayList<BarangModel>();
		barangModelList = this.barangService.temukan();

		return barangModelList;
	}
	
	@PutMapping("/put")
	public Map<String, Object> putApi(@RequestBody BarangModel barangModel) {

		this.barangService.barangUpdate(barangModel);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", Boolean.TRUE);
		map.put("pesan", "data barang berhasil diperbarui");
		
		return map;
	}
	
	// Delete
	@DeleteMapping("/delete")
	public Map<String, Object> deleteapi1(@RequestBody String kdbarang){

		this.barangService.barangHapus(kdbarang);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.remove("succes", Boolean.TRUE);
		map.remove("pesan", "data barang telah dihapus");
		
		return map;
		
	}

}

package com.kodehive.mp2.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kodehive.mp2.model.BarangModel;
import com.kodehive.mp2.service.BarangService;


@Controller
public class BarangController {
	
	@Autowired
	private BarangService barangService;

	@RequestMapping("/barang/list")
	public String barangList(Model model) {
		
		List<BarangModel> barangModelList = new ArrayList<BarangModel>();
		barangModelList = barangService.temukan();
		model.addAttribute("barangModelList", barangModelList);
		
		return "/barang/list";
	}
	
	@RequestMapping("/barang/detail")
	public String barangDetail(HttpServletRequest request, Model model) {
		String idBarang = request.getParameter("idBarang");
		
		BarangModel barangModel = new BarangModel();
		barangModel = this.barangService.barangIDBaca(idBarang);
		
		model.addAttribute("barangModel", barangModel);
		
		return "/barang/detail";
	}
	
	
	@RequestMapping("/barang/tambah")  
	public String barangTambah() {
		return "/barang/tambah";
	}
	
	
	@RequestMapping(value="/barang/buat")
	public String barangBuat(HttpServletRequest request, Model model) { //request -> menerima, Model -> melempar
		
		String kdBarang = request.getParameter("kdBarang");
		String namaBarang = request.getParameter("namaBarang");
		String satuan = request.getParameter("satuan");
		long hargaSiswa = Long.valueOf(request.getParameter("hargaSiswa"));
		String keterangan = request.getParameter("keterangan");
		
		
		BarangModel barangModel = new BarangModel();
		barangModel.setKdBarang(kdBarang);
		barangModel.setNamaBarang(namaBarang);
		barangModel.setSatuan(satuan);
		barangModel.setHargaSiswa(hargaSiswa);
		barangModel.setKeterangan(keterangan);
		
		
		barangService.barangSave(barangModel);
		
		model.addAttribute("barangModel", barangModel);
		
		return "redirect:/barang/list";
	}
	

	@RequestMapping("/barang/update")
	public String barangUpdate(HttpServletRequest request, Model model) {
		
		String kdBarang = request.getParameter("kdBarang");
		String namaBarang = request.getParameter("namaBarang");
		String satuan = request.getParameter("satuan");
		long hargaSiswa = Long.valueOf(request.getParameter("hargaSiswa"));
		String keterangan = request.getParameter("keterangan");
		
		
		BarangModel barangModel = new BarangModel();
		barangModel.setKdBarang(kdBarang);
		barangModel.setNamaBarang(namaBarang);
		barangModel.setSatuan(satuan);
		barangModel.setHargaSiswa(hargaSiswa);
		barangModel.setKeterangan(keterangan);
		
		barangService.barangUpdate(barangModel);
		
		model.addAttribute("barangModel", barangModel);
	
		return "redirect:/barang/list/";
	}
	
	@RequestMapping("/barang/delete")
	public String barangDelete(HttpServletRequest request, Model model) {
		
		String kdBarang = request.getParameter("BarangID");
		BarangModel barangModel = new BarangModel(); 
		this.barangService.barangHapus(kdBarang);
		model.addAttribute(barangModel);
		
		return "redirect:/barang/list";
	}
	
	

}

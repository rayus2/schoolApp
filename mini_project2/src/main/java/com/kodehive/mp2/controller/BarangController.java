package com.kodehive.mp2.controller;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kodehive.mp2.model.BarangModel;
import com.kodehive.mp2.service.BarangService;


@Controller
public class BarangController {
	
	@Autowired
	private BarangService barangService;
	
	@RequestMapping("barang/sidenav")
	public String p_sidenav() {
		return "/components/sidenav";
	}
	
	@RequestMapping("barang/topnav")
	public String p_topnav() {
		return "/components/topnav";
	}

	@RequestMapping("barang/fe_list")
	public String fe_list_barang(Model model, @PageableDefault(page=0, value = 5) Pageable pageable) {
		
		Page<BarangModel> barangModelList = barangService.listBarang(pageable);
		model.addAttribute("barangModelList", barangModelList);
		
		return "barang/fe_list";
	}
	
	@RequestMapping("barang/modal_tambah")
	public String modal_tambah() {
		return "barang/modal-tambah";
	}
	
	@RequestMapping("barang/modal_edit")
	public String modal_edit() {
		return "barang/modal-edit;
	}
	
	@RequestMapping("barang/modal_hapus")
	public String modal_hapus() {
		return "barang/modal-hapus";
	}
	
	@RequestMapping("/barang/modal_detail")
	public String modal_detail(HttpServletRequest request, Model model) {
		String idBarang = request.getParameter("idBarang");
		
		BarangModel barangModel = new BarangModel();
		barangModel = this.barangService.detail_data(idBarang);
		
		model.addAttribute("barangModel", barangModel);
		
		return "/barang/modal-detail";
	}
	
	@RequestMapping("/barang/list")
	public String list_barang(Model model) {
		
		List<BarangModel> barangModelList = new ArrayList<BarangModel>();
		barangModelList = barangService.listBarang();
		model.addAttribute("barangModelList", barangModelList);
		
		return "/barang/list";
	}
	
	
	@RequestMapping("/barang/form_tambah")  
	public String form_tambah() {
		return "/barang/form_tambah";
	}
	
	
	@RequestMapping("/barang/tambah_data")
	public String tambah_barang(HttpServletRequest request, Model model) {
		
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
		
		barangService.tambah_data(barangModel);
		
		model.addAttribute("barangModel", barangModel);
		
		return "redirect:/barang/fe_list";
	}
	
	@RequestMapping("/barang/edit_data")
	public String edit_barang(HttpServletRequest request, Model model) {
		
		String kdBarang = request.getParameter("kdBarang");
		BarangModel barangModel = new BarangModel();
		barangModel = this.barangService.getId(kdBarang);
		
		model.addAttribute("barangModel", barangModel);
		
		return "/barang/form_edit";
	}
	

	@RequestMapping("/barang/save_edit")
	public String save_edit(HttpServletRequest request, Model model) {
		
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
		
		barangService.save_edit(barangModel);
		
		model.addAttribute("barangModel", barangModel);
	
		return "redirect:/barang/fe_list";
	}
	
	@RequestMapping("/barang/delete_data")
	public String delete_barang(HttpServletRequest request, Model model) {
		
		String kdBarang = request.getParameter("kdBarang");
		this.barangService.delete_data(kdBarang);
		
		return "redirect:/barang/fe_list";
	}
	
	@RequestMapping("/barang/detail_data")
	public String detail_barang(HttpServletRequest request, Model model) {
		
		String kdBarang = request.getParameter("kdBarang");
		
		BarangModel barangModel = new BarangModel();
		barangModel = this.barangService.detail_data(kdBarang);

		model.addAttribute("barangModel", barangModel);
		
		return "/barang/detail";
	}
	
	

}

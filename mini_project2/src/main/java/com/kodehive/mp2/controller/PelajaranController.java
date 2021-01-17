package com.kodehive.mp2.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kodehive.mp2.model.PelajaranModel;
import com.kodehive.mp2.service.PelajaranService;

@Controller
public class PelajaranController {
	
	@Autowired
	private PelajaranService pelajaranService;
	
	@RequestMapping("/sidenav")
	public String sidenav() {
		return "/components/sidenav";
	}
	
	@RequestMapping("/topnav")
	public String topnav() {
		return "/components/topnav";
	}
	
	@RequestMapping("pelajaran/sidenav")
	public String p_sidenav() {
		return "/components/sidenav";
	}
	
	@RequestMapping("pelajaran/topnav")
	public String p_topnav() {
		return "/components/topnav";
	}
	
	@RequestMapping("pelajaran/fe_list")
	public String fe_list(Model model, @PageableDefault(page=0, value = 4) Pageable pageable) {
		
		Page<PelajaranModel> pelajaranModelList = pelajaranService.listPelajaran(pageable);
		model.addAttribute("pelajaranModelList", pelajaranModelList);
		
		return "/pelajaran/fe_list";
	}
	
	@RequestMapping("/pelajaran/modal_tambah")
	public String modal_tambah() {
		return "/pelajaran/modal-tambah";
	}
	
	@RequestMapping("/pelajaran/modal_edit")
	public String modal_edit(HttpServletRequest request, Model model) {
		
		String pelajaranID = request.getParameter("pelajaranID");
		PelajaranModel pelajaranModel = new PelajaranModel();
		pelajaranModel = this.pelajaranService.getId(pelajaranID);
		
		model.addAttribute("pelajaranModel", pelajaranModel);
		
		return "/pelajaran/modal-edit";
	}
	
	@RequestMapping("/pelajaran/modal_hapus")
	public String modal_hapus() {
		return "/pelajaran/modal-hapus";
	}
	
	@RequestMapping("/pelajaran/modal_detail")
	public String modal_detail(HttpServletRequest request, Model model) {
		
		String pelajaranID = request.getParameter("pelajaranID");
		
		PelajaranModel pelajaranModel = new PelajaranModel();
		pelajaranModel = this.pelajaranService.detail_data(pelajaranID);

		model.addAttribute("pelajaranModel", pelajaranModel);
		
		return "/pelajaran/modal-detail";
	}
	
	@RequestMapping("/pelajaran/list")
	public String list_pelajaran(Model model, @PageableDefault(page=0, value = 4) Pageable pageable) {
		
		Page<PelajaranModel> pelajaranModelList = pelajaranService.listPelajaran(pageable);
		model.addAttribute("pelajaranModelList", pelajaranModelList);
		
		return "/pelajaran/list";
	}
	
	@RequestMapping("/pelajaran/form_tambah")
	public String form_tambah() {
		return "/pelajaran/form_tambah";
	}
	
	@RequestMapping("/pelajaran/tambah_data")
	public String tambah_pelajaran(HttpServletRequest request, Model model) {
		
		String kode_pelajaran = request.getParameter("kode_pelajaran");
		String nama_pelajaran = request.getParameter("nama_pelajaran");
		int jam_ajar_pelajaran = Integer.valueOf(request.getParameter("jam_ajar_pelajaran"));
		int tingkat_pelajaran = Integer.valueOf(request.getParameter("tingkat_pelajaran"));
		String keterangan_pelajaran = request.getParameter("keterangan_pelajaran");
		
		PelajaranModel pelajaranModel = new PelajaranModel();
		
		pelajaranModel.setKode_pelajaran(kode_pelajaran);
		pelajaranModel.setNama_pelajaran(nama_pelajaran);
		pelajaranModel.setJam_ajar_pelajaran(jam_ajar_pelajaran);
		pelajaranModel.setTingkat_pelajaran(tingkat_pelajaran);
		pelajaranModel.setKeterangan_pelajaran(keterangan_pelajaran);
		
		pelajaranService.tambah_data(pelajaranModel);
		
		model.addAttribute("pelajaranModel", pelajaranModel);
		
		return "redirect:/pelajaran/fe_list";
	}
	
	@RequestMapping("/pelajaran/edit_data")
	public String edit_pelajaran(HttpServletRequest request, Model model) {
		
		String pelajaranID = request.getParameter("pelajaranID");
		PelajaranModel pelajaranModel = new PelajaranModel();
		pelajaranModel = this.pelajaranService.getId(pelajaranID);
		
		model.addAttribute("pelajaranModel", pelajaranModel);
		
		return "/pelajaran/form_edit";
	}
	
	@RequestMapping("/pelajaran/save_edit")
	public String save_edit(HttpServletRequest request, Model model) {
	
		String kode_pelajaran = request.getParameter("kode_pelajaran");
		String nama_pelajaran = request.getParameter("nama_pelajaran");
		int jam_ajar_pelajaran = Integer.valueOf(request.getParameter("jam_ajar_pelajaran"));
		int tingkat_pelajaran = Integer.valueOf(request.getParameter("tingkat_pelajaran"));
		String keterangan_pelajaran = request.getParameter("keterangan_pelajaran");
		
		PelajaranModel pelajaranModel = new PelajaranModel();
		
		pelajaranModel.setKode_pelajaran(kode_pelajaran);
		pelajaranModel.setNama_pelajaran(nama_pelajaran);
		pelajaranModel.setJam_ajar_pelajaran(jam_ajar_pelajaran);
		pelajaranModel.setTingkat_pelajaran(tingkat_pelajaran);
		pelajaranModel.setKeterangan_pelajaran(keterangan_pelajaran);
		
		pelajaranService.save_edit(pelajaranModel);
		
		model.addAttribute("pelajaranModel", pelajaranModel);
	
		return "redirect:/pelajaran/fe_list";
	}
	
	@RequestMapping("/pelajaran/delete_data")
	public String delete_siswa(HttpServletRequest request, Model model) {
		
		String kode_pelajaran = request.getParameter("pelajaranID");
		this.pelajaranService.delete_data(kode_pelajaran);
		
		return "redirect:/pelajaran/list";
	}
	
	@RequestMapping("/pelajaran/detail_data")
	public String detail_pelajaran(HttpServletRequest request, Model model) {
		
		String pelajaranID = request.getParameter("pelajaranID");
		
		PelajaranModel pelajaranModel = new PelajaranModel();
		pelajaranModel = this.pelajaranService.detail_data(pelajaranID);

		model.addAttribute("pelajaranModel", pelajaranModel);
		
		return "/pelajaran/detail";
	}
}

package com.kodehive.mp2.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kodehive.mp2.model.PelajaranModel;
import com.kodehive.mp2.service.PelajaranService;

@Controller
public class PelajaranController {
	
	@Autowired
	private PelajaranService pelajaranService;
	
	@RequestMapping("/pelajaran/list")
	public String list_pelajaran(Model model) {
		
		List<PelajaranModel> pelajaranModelList = new ArrayList<PelajaranModel>();
		pelajaranModelList = pelajaranService.listPelajaran();
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
		
		return "redirect:/pelajaran/list";
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
	
		return "redirect:/pelajaran/list/";
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

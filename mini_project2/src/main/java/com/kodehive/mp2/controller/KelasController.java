package com.kodehive.mp2.controller;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kodehive.mp2.model.KelasModel;
import com.kodehive.mp2.service.KelasService;


@Controller
public class KelasController {
	
	@Autowired
	private KelasService kelasService;
	
	@RequestMapping("/kelas/list")
	public String list_kelas(Model model) {
		
		List<KelasModel> kelasModelList = new ArrayList<KelasModel>();
		kelasModelList = kelasService.listkelas();
		model.addAttribute("kelasModelList", kelasModelList);
		
		return "/kelas/list";
	}
	
	@RequestMapping("/kelas/form_tambah")
	public String form_tambah() {
		return "/kelas/form_tambah";
	}
	
	@RequestMapping("/kelas/tambah_data")
	public String tambah_kelas(HttpServletRequest request, Model model) {
		
		String kode_kelas = request.getParameter("kode_kelas");
		String nama_kelas = request.getParameter("nama_kelas");
		String tingkat_kelas = request.getParameter("tingkat_kelas");
		String wali_kelas = request.getParameter("wali_kelas");
		String ruang_kelas = request.getParameter("ruang_kelas");
		
		KelasModel kelasModel = new KelasModel();
		
		kelasModel.setKode_kelas(kode_kelas);
		kelasModel.setNama_kelas(nama_kelas);
		kelasModel.setTingkat_kelas(tingkat_kelas);
		kelasModel.setWali_kelas(wali_kelas);
		kelasModel.setRuang_kelas(ruang_kelas);

		
		kelasService.tambah_data(kelasModel);
		
		model.addAttribute("kelasModel", kelasModel);
		
		return "redirect:/kelas/list";
	}
	
	@RequestMapping("/kelas/edit_data")
	public String edit_kelas(HttpServletRequest request, Model model) {
		
		String kelasID = request.getParameter("kelasID");
		KelasModel kelasModel = new KelasModel();
		kelasModel = this.kelasService.getId(kelasID);
		
		model.addAttribute("kelasModel", kelasModel);
		
		return "/kelas/form_edit";
	}
	
	@RequestMapping("/kelas/save_edit")
	public String save_edit(HttpServletRequest request, Model model) {
	
		String kode_kelas = request.getParameter("kode_kelas");
		String nama_kelas = request.getParameter("nama_kelas");
		String tingkat_kelas = request.getParameter("tingkat_kelas");
		String wali_kelas = request.getParameter("wali_kelas");
		String ruang_kelas = request.getParameter("ruang_kelas");
		
		KelasModel kelasModel = new KelasModel();
		
		kelasModel.setKode_kelas(kode_kelas);
		kelasModel.setNama_kelas(nama_kelas);
		kelasModel.setTingkat_kelas(tingkat_kelas);
		kelasModel.setWali_kelas(wali_kelas);
		kelasModel.setRuang_kelas(ruang_kelas);
		
		kelasService.save_edit(kelasModel);
		
		model.addAttribute("kelasModel", kelasModel);
	
		return "redirect:/kelas/list/";
	}
	
	@RequestMapping("/kelas/delete_data")
	public String delete_kelas(HttpServletRequest request, Model model) {
		
		String kode_kelas = request.getParameter("kelasID");
		this.kelasService.delete_data(kode_kelas);
		
		return "redirect:/kelas/list";
	}
	
	@RequestMapping("/kelas/detail_data")
	public String detail_kelas(HttpServletRequest request, Model model) {
		
		String kelasID = request.getParameter("kelasID");
		
		KelasModel kelasModel = new KelasModel();
		kelasModel = this.kelasService.detail_data(kelasID);

		model.addAttribute("kelasModel", kelasModel);
		
		return "/kelas/detail";
	}
	
	
}

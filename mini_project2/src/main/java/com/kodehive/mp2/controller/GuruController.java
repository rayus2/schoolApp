package com.kodehive.mp2.controller;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kodehive.mp2.model.GuruModel;
import com.kodehive.mp2.service.GuruService;

@Controller
public class GuruController {
	
	@Autowired
	private GuruService guruService;
	
	@RequestMapping("/guru/list")
	public String list_guru(Model model) {
		
		List<GuruModel> guruModelList = new ArrayList<GuruModel>();
		guruModelList = guruService.listGuru();
		model.addAttribute("guruModelList", guruModelList);
		
		return "/guru/list";
	}
	
	@RequestMapping("/guru/form_tambah")
	public String form_tambah() {
		return "/guru/form_tambah";
	}
	
	@RequestMapping("/guru/tambah_data")
	public String tambah_guru(HttpServletRequest request, Model model) {
		
		String nip_guru = request.getParameter("nip_guru");
		String nama_guru = request.getParameter("nama_guru");
		String telepon_guru = request.getParameter("telepon_guru");
		String gender_guru = request.getParameter("gender_guru");
		String gelar_guru = request.getParameter("gelar_guru");
		String alamat_guru = request.getParameter("alamat_guru");
		
		GuruModel guruModel = new GuruModel();
		
		guruModel.setNip_guru(nip_guru);
		guruModel.setNama_guru(nama_guru);
		guruModel.setTelepon_guru(telepon_guru);
		guruModel.setGender_guru(gender_guru);
		guruModel.setGelar_guru(gelar_guru);
		guruModel.setAlamat_guru(alamat_guru);
		
		guruService.tambah_data(guruModel);
		
		model.addAttribute("guruModel", guruModel);
		
		return "redirect:/guru/list";
	}
	
	@RequestMapping("/guru/edit_data")
	public String edit_guru(HttpServletRequest request, Model model) {
		
		String guruID = request.getParameter("guruID");
		GuruModel guruModel = new GuruModel();
		guruModel = this.guruService.getId(guruID);
		
		model.addAttribute("guruModel", guruModel);
		
		return "/guru/form_edit";
	}
	
	@RequestMapping("/guru/save_edit")
	public String save_edit(HttpServletRequest request, Model model) {
	
		String nip_guru = request.getParameter("nip_guru");
		String nama_guru = request.getParameter("nama_guru");
		String telepon_guru = request.getParameter("telepon_guru");
		String gender_guru = request.getParameter("gender_guru");
		String gelar_guru = request.getParameter("gelar_guru");
		String alamat_guru = request.getParameter("alamat_guru");
		
		GuruModel guruModel = new GuruModel();
		
		guruModel.setNip_guru(nip_guru);
		guruModel.setNama_guru(nama_guru);
		guruModel.setTelepon_guru(telepon_guru);
		guruModel.setGender_guru(gender_guru);
		guruModel.setGelar_guru(gelar_guru);
		guruModel.setAlamat_guru(alamat_guru);
		
		guruService.save_edit(guruModel);
		
		model.addAttribute("guruModel", guruModel);
	
		return "redirect:/guru/list/";
	}
	
	@RequestMapping("/guru/delete_data")
	public String delete_guru(HttpServletRequest request, Model model) {
		
		String nip_guru = request.getParameter("guruID");
		this.guruService.delete_data(nip_guru);
		
		return "redirect:/guru/list";
	}
	
	@RequestMapping("/guru/detail_data")
	public String detail_guru(HttpServletRequest request, Model model) {
		
		String guruID = request.getParameter("guruID");
		
		GuruModel guruModel = new GuruModel();
		guruModel = this.guruService.detail_data(guruID);

		model.addAttribute("guruModel", guruModel);
		
		return "/guru/detail";
	}
	
	
}

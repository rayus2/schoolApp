package com.kodehive.mp2.controller.api;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kodehive.mp2.model.SiswaModel;
import com.kodehive.mp2.service.SiswaService;

@Controller
public class SiswaController {

	@Autowired
	private SiswaService siswaService;
	
	@RequestMapping("/")
	public String index() {
		return "/index";
	}
	
	@RequestMapping("/siswa/list")
	public String list_siswa(Model model) {
		
		List<SiswaModel> siswaModelList = new ArrayList<SiswaModel>();
		siswaModelList = siswaService.listSiswa();
		model.addAttribute("siswaModelList", siswaModelList);
		
		return "/siswa/list";
	}
	
	@RequestMapping("/siswa/form_tambah")
	public String form_tambah() {
		return "/siswa/form_tambah";
	}
	
	@RequestMapping("/siswa/tambah_data")
	public String tambah_siswa(HttpServletRequest request, Model model) {
		
		String nim_siswa = request.getParameter("nim_siswa");
		String nama_siswa = request.getParameter("nama_siswa");
		String kelas_siswa = request.getParameter("kelas_siswa");
		
		SiswaModel siswaModel = new SiswaModel();
		
		siswaModel.setNim_siswa(nim_siswa);
		siswaModel.setNama_siswa(nama_siswa);
		siswaModel.setKelas_siswa(kelas_siswa);
		
		siswaService.tambah_data(siswaModel);
		
		model.addAttribute("siswaModel", siswaModel);
		
		return "redirect:/siswa/list";
	}
	
	@RequestMapping("/siswa/edit_data")
	public String edit_siswa(HttpServletRequest request, Model model) {
		
		String siswaID = request.getParameter("siswaID");
		SiswaModel siswaModel = new SiswaModel();
		siswaModel = this.siswaService.getId(siswaID);
		
		model.addAttribute("siswaModel", siswaModel);
		
		return "/siswa/form_edit";
	}
	
	@RequestMapping("/siswa/save_edit")
	public String save_edit(HttpServletRequest request, Model model) {
	
		String nim_siswa = request.getParameter("nim_siswa");
		String nama_siswa = request.getParameter("nama_siswa");
		String kelas_siswa = request.getParameter("kelas_siswa");
		
		SiswaModel siswaModel = new SiswaModel();
		
		siswaModel.setNim_siswa(nim_siswa);
		siswaModel.setNama_siswa(nama_siswa);
		siswaModel.setKelas_siswa(kelas_siswa);
		
		siswaService.save_edit(siswaModel);
		
		model.addAttribute("siswaModel", siswaModel);
	
		return "redirect:/siswa/list/";
	}
	
	@RequestMapping("/siswa/delete_data")
	public String delete_siswa(HttpServletRequest request, Model model) {
		
		String nim_siswa = request.getParameter("siswaID");
		this.siswaService.delete_data(nim_siswa);
		
		return "redirect:/siswa/list";
	}
	
	@RequestMapping("/siswa/detail_data")
	public String detail_siswa(HttpServletRequest request, Model model) {
		
		String siswaID = request.getParameter("siswaID");
		
		SiswaModel siswaModel = new SiswaModel();
		siswaModel = this.siswaService.detail_data(siswaID);

		model.addAttribute("siswaModel", siswaModel);
		
		return "/siswa/detail";
	}
	
	
}

package com.kodehive.mp2.controller;

import java.sql.Date;
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

	@RequestMapping("/siswa/fe_list")
	public String fe_list_siswa(Model model) {
		
		List<SiswaModel> siswaModelList = new ArrayList<SiswaModel>();
		siswaModelList = siswaService.listSiswa();
		model.addAttribute("siswaModelList", siswaModelList);
		
		return "/siswa/fe_list";
	}
	
	@RequestMapping("/siswa/modal_tambah")
	public String modal_tambah() {
		return "/siswa/modal-tambah";
	}
	
	@RequestMapping("/siswa/modal_edit")
	public String modal_edit() {
		return "/siswa/modal-edit";
	}
	
	@RequestMapping("/siswa/modal_hapus")
	public String modal_hapus() {
		return "/siswa/modal-hapus";
	}
	
	@RequestMapping("/siswa/modal_detail")
	public String modal_detail() {
		return "/siswa/modal-detail";
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
		String gender_siswa = request.getParameter("gender_siswa");
		Date tgllahir_siswa = Date.valueOf(request.getParameter("tgllahir_siswa"));
		String tempatlahir_siswa = request.getParameter("tempatlahir_siswa");
		String wali_siswa = request.getParameter("wali_siswa");
		String pekerjaan_wali_siswa = request.getParameter("pekerjaan_wali_siswa");
		String telp_wali_siswa = request.getParameter("telp_wali_siswa");
		String alamat_siswa = request.getParameter("alamat_siswa");
		String kelas_siswa = request.getParameter("kelas_siswa");
		
		SiswaModel siswaModel = new SiswaModel();
		
		siswaModel.setNim_siswa(nim_siswa);
		siswaModel.setNama_siswa(nama_siswa);
		siswaModel.setGender_siswa(gender_siswa);
		siswaModel.setTgllahir_siswa(tgllahir_siswa);
		siswaModel.setTempatlahir_siswa(tempatlahir_siswa);
		siswaModel.setWali_siswa(wali_siswa);
		siswaModel.setPekerjaan_wali_siswa(pekerjaan_wali_siswa);
		siswaModel.setTelp_wali_siswa(telp_wali_siswa);
		siswaModel.setAlamat_siswa(alamat_siswa);
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
		String gender_siswa = request.getParameter("gender_siswa");
		Date tgllahir_siswa = Date.valueOf(request.getParameter("tgllahir_siswa"));
		String tempatlahir_siswa = request.getParameter("tempatlahir_siswa");
		String wali_siswa = request.getParameter("wali_siswa");
		String pekerjaan_wali_siswa = request.getParameter("pekerjaan_wali_siswa");
		String telp_wali_siswa = request.getParameter("telp_wali_siswa");
		String alamat_siswa = request.getParameter("alamat_siswa");
		String kelas_siswa = request.getParameter("kelas_siswa");
		
		SiswaModel siswaModel = new SiswaModel();
		
		siswaModel.setNim_siswa(nim_siswa);
		siswaModel.setNama_siswa(nama_siswa);
		siswaModel.setGender_siswa(gender_siswa);
		siswaModel.setTgllahir_siswa(tgllahir_siswa);
		siswaModel.setTempatlahir_siswa(tempatlahir_siswa);
		siswaModel.setWali_siswa(wali_siswa);
		siswaModel.setPekerjaan_wali_siswa(pekerjaan_wali_siswa);
		siswaModel.setTelp_wali_siswa(telp_wali_siswa);
		siswaModel.setAlamat_siswa(alamat_siswa);
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

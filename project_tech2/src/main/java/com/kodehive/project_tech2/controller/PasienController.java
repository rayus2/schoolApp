package com.kodehive.project_tech2.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kodehive.project_tech2.model.PasienModel;
import com.kodehive.project_tech2.service.PasienService;

@Controller
public class PasienController {
	
	@Autowired
	private PasienService pasienService;
	
	@RequestMapping(value="/pasien/form")
	public String Form() {
		return "/pasien/formPasien";
	}
	
	@RequestMapping(value="/pasien/addPasien")
	public String submit(HttpServletRequest request, Model model) throws ParseException {

		String noPasien = request.getParameter("noPasien");
		String namaPasien = request.getParameter("namaPasien");
		String genderPasien = request.getParameter("genderPasien");
		String kategoriPasien = request.getParameter("kategoriPasien");
		int biayaPasien = Integer.valueOf(request.getParameter("biayaPasien"));
		Date ttlPasien = Date.valueOf(request.getParameter("ttlPasien"));
				
		PasienModel pasienModel = new PasienModel();
		pasienModel.setNoPasien(noPasien);
		pasienModel.setNamaPasien(namaPasien);
		pasienModel.setGenderPasien(genderPasien);
		pasienModel.setKategoriPasien(kategoriPasien);
		pasienModel.setBiayaPasien(biayaPasien);
		pasienModel.setTtlPasien(ttlPasien);
		
		pasienService.addData(pasienModel);
		
		model.addAttribute("pasienModel", pasienModel);

		
		return "redirect:/pasien/list";
	}
	
	@RequestMapping("/pasien/list")
	public String pasien(Model model) {
		
		List<PasienModel> pasienModelList = new ArrayList<PasienModel>();
		pasienModelList = pasienService.showData();
		model.addAttribute("pasienModelList", pasienModelList);
								
		return "/pasien/list";
	}
	
	@RequestMapping("/pasien/add")
	public String addPasien() {
		return "/pasien/add";
	}
	
	@RequestMapping(value="/hasil/insert")
	public String create(HttpServletRequest request, Model model) {
		
		String noPasien = request.getParameter("noPasien");
		String namaPasien = request.getParameter("namaPasien");
		int biayaPasien = Integer.valueOf(request.getParameter("biayaPasien"));
		
		PasienModel pasienModel = new PasienModel();
		pasienModel.setNoPasien(noPasien);
		pasienModel.setNamaPasien(namaPasien);
		pasienModel.setBiayaPasien(biayaPasien);
		
		pasienService.addData(pasienModel);
		
		model.addAttribute("pasienModel", pasienModel);
		
		String html = "/pasien/showAdd";
		
		return html;
	}
	
	@RequestMapping("/pasien/search")
	public String search(HttpServletRequest request, Model model) {
		
		String keyName = request.getParameter("keyName");
		
		PasienModel pasienModel= new PasienModel();
		pasienModel = this.pasienService.search(keyName);
		
		model.addAttribute("pasienModel", pasienModel);
								
		return "/pasien/detail";
		
	}	
	
	// -- Cara sendiri--
	@RequestMapping("/pasien/edit/{noPasien}")
	public ModelAndView showEditProductPage(@PathVariable(name = "noPasien") String noPasien) {
	    ModelAndView mav = new ModelAndView("/pasien/formEditPasien");
	    PasienModel pasienModel = pasienService.get(noPasien);
	    mav.addObject("pasienModel", pasienModel);
	     
	    return mav;
	}	
	
	@RequestMapping(value="/pasien/editPasien")
	public String edit(HttpServletRequest request, Model model) throws ParseException {

		String noPasien = request.getParameter("noPasien");
		String namaPasien = request.getParameter("namaPasien");
		String genderPasien = request.getParameter("genderPasien");
		String kategoriPasien = request.getParameter("kategoriPasien");
		int biayaPasien = Integer.valueOf(request.getParameter("biayaPasien"));
		Date ttlPasien = Date.valueOf(request.getParameter("ttlPasien"));
				
		PasienModel pasienModel = new PasienModel();
		
		pasienModel.setNoPasien(noPasien);
		pasienModel.setNamaPasien(namaPasien);
		pasienModel.setGenderPasien(genderPasien);
		pasienModel.setKategoriPasien(kategoriPasien);
		pasienModel.setBiayaPasien(biayaPasien);
		pasienModel.setTtlPasien(ttlPasien);
		
		pasienService.addData(pasienModel);
		
		model.addAttribute("pasienModel", pasienModel);

		return "redirect:/pasien/list";
	}
	
	// --------
	
	// Cara Bootcamp --
	@RequestMapping("/pasien/update")
	public String update(HttpServletRequest request, Model model) {
		
		String pasienID = request.getParameter("pasienID");
		
		PasienModel pasienModel= new PasienModel();
		pasienModel = this.pasienService.getbyID(pasienID);
		
		model.addAttribute(pasienModel);
								
		return "/pasien/update";
		
	}
	
	@RequestMapping("/pasien/edit2")
	public String edit2(HttpServletRequest request, Model model) {
		
		String noPasien = request.getParameter("noPasien");
		String namaPasien = request.getParameter("namaPasien");
		String genderPasien = request.getParameter("genderPasien");
		String kategoriPasien = request.getParameter("kategoriPasien");
		int biayaPasien = Integer.valueOf(request.getParameter("biayaPasien"));
		Date ttlPasien = Date.valueOf(request.getParameter("ttlPasien"));
				
		PasienModel pasienModel = new PasienModel();
		
		pasienModel.setNoPasien(noPasien);
		pasienModel.setNamaPasien(namaPasien);
		pasienModel.setGenderPasien(genderPasien);
		pasienModel.setKategoriPasien(kategoriPasien);
		pasienModel.setBiayaPasien(biayaPasien);
		pasienModel.setTtlPasien(ttlPasien);
		
		pasienService.editData(pasienModel);
		
		model.addAttribute("pasienModel", pasienModel);
		
		this.pasien(model);
		
		return "redirect:/pasien/list";
	}
	
	// -----

	@RequestMapping("/pasien/delete")
	public String delete(HttpServletRequest request, Model model) {
		
		String pasienID = request.getParameter("pasienID");
		
		this.pasienService.deleteData(pasienID);
								
		return "redirect:/pasien/list";
		
	}
}

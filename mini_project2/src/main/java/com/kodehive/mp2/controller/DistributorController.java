package com.kodehive.mp2.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import com.project.projectb2.model.DistributorModel;
import com.project.projectb2.service.DistributorService;


@Controller
public class DistributorController {
	
	@Autowired
	private DistributorService distributorService;

	@RequestMapping("/distributor/list")
	public String distriList(Model model) {
		
		List<DistributorModel> distriListModel = new ArrayList<DistributorModel>();
		distriListModel = distributorService.temukan2();
		model.addAttribute("distriListModel", distriListModel);
		
		return "/distributor/list";
	}
	
	@RequestMapping("/distributor/detail")
	public String distriDetail(HttpServletRequest request, Model model) {
		String idDistri = request.getParameter("idDistri");
		
		DistributorModel distriModel = new DistributorModel();
		distriModel = this.distributorService.distriID(idDistri);
		
		model.addAttribute("distriModel", distriModel);
		
		return "/distributor/detail";
	}
	
	
	@RequestMapping("/distributor/tambah")  
	public String distriTambah() {
		return "/distributor/tambah";
	}
	
	
	@RequestMapping(value="/distributor/buat")
	public String distriBuat(HttpServletRequest request, Model model) { //request -> menerima, Model -> melempar
		
		String kdDistributor = request.getParameter("kdDistributor");
		String namaDistributor = request.getParameter("namaDistributor");
		String tipeDistributor = request.getParameter("tipeDistributor");
		String telepon = request.getParameter("telepon");
		String alamat = request.getParameter("alamat");
		
		DistributorModel distriModel = new DistributorModel();
		distriModel.setKdDistributor(kdDistributor);
		distriModel.setNamaDistributor(namaDistributor);
		distriModel.setTipeDistributor(tipeDistributor);
		distriModel.setTelepon(telepon);
		distriModel.setAlamat(alamat);
		
		
		distributorService.distriSave(distriModel); 
		
		model.addAttribute("distriModel", distriModel);
		
		return "redirect:/distributor/list";
	}
	

	@RequestMapping("/distributor/update")
	public String distriUpdate(HttpServletRequest request, Model model) {
		
		String kdDistributor = request.getParameter("kdDistributor");
		String namaDistributor = request.getParameter("namaDistributor");
		String tipeDistributor = request.getParameter("tipeDistributor");
		String telepon = request.getParameter("telepon");
		String alamat = request.getParameter("alamat");
		
		DistributorModel distriModel = new DistributorModel();
		distriModel.setKdDistributor(kdDistributor);
		distriModel.setNamaDistributor(namaDistributor);
		distriModel.setTipeDistributor(tipeDistributor);
		distriModel.setTelepon(telepon);
		distriModel.setAlamat(alamat);
		
		distributorService.distriUpdate(distriModel);
		
		model.addAttribute("distriModel", distriModel);
	
		return "redirect:/distributor/list";
	}
	
	@RequestMapping("/distributor/delete")
	public String distriDelete(HttpServletRequest request, Model model) {
		
		String kdDistri = request.getParameter("DistriID");
		DistributorModel distriModel = new DistributorModel();
		this.distributorService.distriHapus(kdDistri);
		model.addAttribute(distriModel);
		
		return "redirect:/distributor/list";
	}
	
	

}

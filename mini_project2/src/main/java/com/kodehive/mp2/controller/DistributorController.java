package com.kodehive.mp2.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kodehive.mp2.model.DistributorModel;
import com.kodehive.mp2.service.DistributorService;




@Controller
public class DistributorController {
	
	@Autowired
	private DistributorService distriService;
	
	@RequestMapping("/sidenav")
	public String sidenav() {
		return "/components/sidenav";
	}
	
	@RequestMapping("/topnav")
	public String topnav() {
		return "/components/topnav";
	}
	
	@RequestMapping("distributor/sidenav")
	public String p_sidenav() {
		return "/components/sidenav";
	}
	
	@RequestMapping("distributor/topnav")
	public String p_topnav() {
		return "/components/topnav";
	}

	@RequestMapping("distributor/fe_list")
	public String fe_list(Model model, @PageableDefault(page=0, value = 4) Pageable pageable) {
		
		Page<DistributorModel> distributorModelList = distriService.listDistributor(pageable);
		model.addAttribute("distributorModelList", distributorModelList);
		
		return "distributor/fe_list";
	}
	
	@RequestMapping("/distributor/modal_tambah")
	public String modal_tambah() {
		return "/distributor/modal-tambah";
	}
	
	@RequestMapping("/distributor/modal_edit")
	public String modal_edit(HttpServletRequest request, Model model) {
		
		String distributorID = request.getParameter("distributorID");
		DistributorModel distributorModel = new DistributorModel();
		distributorModel = this.distriService.getId(distributorID);
		
		model.addAttribute("distributorModel", distributorModel);
		
		return "/distributor/modal-edit";
	}
	
	
	@RequestMapping("/distributor/modal_hapus")
	public String modal_hapus() {
		return "/distributor/modal-hapus";
	}
	
	
	@RequestMapping("/distributor/tambah_data")
	public String tambah_distributor(HttpServletRequest request, Model model) {
		
		String kdDistributor = request.getParameter("kdDistributor");
		String namaDistributor = request.getParameter("namaDistributor");
		String tipeDistributor = request.getParameter("tipeDistributor");
		String telepon = request.getParameter("telepon");
		String alamat = request.getParameter("alamat");
		
		DistributorModel distributorModel = new DistributorModel();
		
		distributorModel.setKdDistributor(kdDistributor);
		distributorModel.setNamaDistributor(namaDistributor);
		distributorModel.setTipeDistributor(tipeDistributor);
		distributorModel.setTelepon(telepon);
		distributorModel.setAlamat(alamat);
		
		
		distriService.tambah_data(distributorModel); 
		
		model.addAttribute("distributorModel", distributorModel);
		
		return "redirect:/distributor/fe_list";
	}
	
	@RequestMapping("/distributor/list")
	public String list_distributor(Model model, @PageableDefault(page=0, value = 4) Pageable pageable) {
		
		Page<DistributorModel> distributorModelList = distriService.listDistributor(pageable);
		model.addAttribute("distributorModelList", distributorModelList);
		
		return "/distributor/list";
	}
	
	@RequestMapping("/distributor/form_tambah")
	public String form_tambah() {
		return "/distributor/form_tambah";
	}
	
	@RequestMapping("/distributor/edit_data")
	public String edit_distributor(HttpServletRequest request, Model model) {
		
		String distributorID = request.getParameter("distributorID");
		DistributorModel distributorModel = new DistributorModel();
		distributorModel = this.distriService.getId(distributorID);
		
		model.addAttribute("pelajaranModel", distributorModel);
		
		return "/distributor/form_edit";
	}
	

	@RequestMapping("/distributor/save_edit")
	public String save_edit(HttpServletRequest request, Model model) {
		
		String kdDistributor = request.getParameter("kdDistributor");
		String namaDistributor = request.getParameter("namaDistributor");
		String tipeDistributor = request.getParameter("tipeDistributor");
		String telepon = request.getParameter("telepon");
		String alamat = request.getParameter("alamat");
		
		DistributorModel distributorModel = new DistributorModel();
		
		distributorModel.setKdDistributor(kdDistributor);
		distributorModel.setNamaDistributor(namaDistributor);
		distributorModel.setTipeDistributor(tipeDistributor);
		distributorModel.setTelepon(telepon);
		distributorModel.setAlamat(alamat);
		
		distriService.save_edit(distributorModel);
		
		model.addAttribute("distributorModel", distributorModel);
	
		return "redirect:/distributor/fe_list";
	}
	
	@RequestMapping("/distributor/delete_data")
	public String delete_distributor(HttpServletRequest request, Model model) {
		
		String distributorID = request.getParameter("distributorID");
		this.distriService.delete_data(distributorID);
		
		return "redirect:/distributor/list";
	}
	
	@RequestMapping("/distributor/modal_detail")
	public String modal_detail(HttpServletRequest request, Model model) {
		
		String distributorID = request.getParameter("distributorID");
		
		DistributorModel distributorModel = new DistributorModel();
		distributorModel = this.distriService.detail_data(distributorID);

		model.addAttribute("distributorModel", distributorModel);
		
		return "/distributor/modal-detail";
	}
	
	@RequestMapping("/distributor/detail_data")
	public String detail_distributor(HttpServletRequest request, Model model) {
		
		String distributorID = request.getParameter("distributorID");
		
		DistributorModel distributorModel = new DistributorModel();
		distributorModel = this.distriService.detail_data(distributorID);

		model.addAttribute("distributorModel", distributorModel);
		
		return "/distributor/detail";
	}
	

}

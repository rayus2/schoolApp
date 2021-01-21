package com.kodehive.mp2.controller;

import java.sql.Date;
import java.sql.Time;
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

import com.kodehive.mp2.model.GuruModel;
import com.kodehive.mp2.model.PenjadwalanModel;
import com.kodehive.mp2.service.GuruService;

@Controller
public class GuruController {

	@Autowired
	private GuruService guruService;

	@RequestMapping("guru/sidenav")
	public String p_sidenav() {
		return "/components/sidenav";
	}

	@RequestMapping("guru/topnav")
	public String p_topnav() {
		return "/components/topnav";
	}

	@RequestMapping("guru/fe_list")
	public String fe_list_guru(Model model, @PageableDefault(page = 0, value = 5) Pageable pageable) {

		Page<GuruModel> guruModelList = guruService.listGuru(pageable);
		model.addAttribute("guruModelList", guruModelList);

		return "guru/fe_list";
	}

	@RequestMapping("guru/modal_tambah")
	public String modal_tambah() {
		return "guru/modal-tambah";
	}

	@RequestMapping("guru/modal_edit")
	public String modal_edit() {
		return "guru/modal-edit";
	}

	@RequestMapping("guru/modal_hapus")
	public String modal_hapus() {
		return "guru/modal-hapus";
	}

	@RequestMapping("guru/modal_detail")
	public String modal_detail(HttpServletRequest request, Model model) {

		String guruID = request.getParameter("guruID");

		GuruModel guruModel = new GuruModel();
		guruModel = this.guruService.detail_data(guruID);

		model.addAttribute("guruModel", guruModel);

		return "guru/modal-detail";
	}

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

		return "redirect:/guru/fe_list";
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

		return "redirect:/guru/fe_list";
	}

	@RequestMapping("/guru/delete_data")
	public String delete_guru(HttpServletRequest request, Model model) {

		String nip_guru = request.getParameter("guruID");
		this.guruService.delete_data(nip_guru);

		return "redirect:/guru/fe_list";
	}

	@RequestMapping("/guru/detail_data")
	public String detail_guru(HttpServletRequest request, Model model) {

		String guruID = request.getParameter("guruID");

		GuruModel guruModel = new GuruModel();
		guruModel = this.guruService.detail_data(guruID);

		model.addAttribute("guruModel", guruModel);

		return "/guru/detail";
	}
	// Transaksi SPP Siswa


	@RequestMapping("/transaksi/pilihguru")
	public String pilihGuru() {
		return "/transaksi/modal_pilihguru";
	}

	@RequestMapping("/transaksi/penjadwalan")
	public String spp_siswa(Model model) {

		List<GuruModel> guruModel = new ArrayList<GuruModel>();
		guruModel = this.guruService.listGuru();
		model.addAttribute("penjadwalanList", guruModel);

		return "/transaksi/Penjadwalan";
	}

	@RequestMapping("/transaksi/submit_jadwal")
	public String save_spp(HttpServletRequest request, Model model) {

		String no_sk = request.getParameter("no_sk");
		Date tgl_jadwal = Date.valueOf(request.getParameter("tgl_jadwal"));
		String kurikulum = request.getParameter("kurikulum");
		Time jam_mulai = Time.valueOf(request.getParameter("jam_mulai"));
		Time jam_akhir = Time.valueOf(request.getParameter("jam_akhir"));

		PenjadwalanModel penjadwalanModel = new PenjadwalanModel();

		penjadwalanModel.setNo_sk(no_sk);
		penjadwalanModel.setTgl_jadwal(tgl_jadwal);
		penjadwalanModel.setKurikulum(kurikulum);
		penjadwalanModel.setJam_mulai(jam_mulai);
		penjadwalanModel.setJam_akhir(jam_akhir);

		guruService.save_jadwal(penjadwalanModel);

		return "redirect:/transaksi/Penjadwalan";
	}

}

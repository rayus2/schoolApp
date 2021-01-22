package com.kodehive.mp2.controller;

import java.sql.Date;
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

import com.kodehive.mp2.model.NilaiModel;
import com.kodehive.mp2.model.PelajaranModel;
import com.kodehive.mp2.model.SiswaModel;
import com.kodehive.mp2.model.SppModel;
import com.kodehive.mp2.service.PelajaranService;
import com.kodehive.mp2.service.SiswaService;

@Controller
public class SiswaController {

	@Autowired
	private SiswaService siswaService;
	
	@Autowired
	private PelajaranService pelajaranService;
	
	@RequestMapping("siswa/sidenav")
	public String p_sidenav() {
		return "/components/sidenav";
	}

	@RequestMapping("/")
	public String index() {
		return "/index";
	}

	@RequestMapping("siswa/fe_list")
	public String fe_list_siswa(Model model, @PageableDefault(page=0, value = 10) Pageable pageable) {
		
		Page<SiswaModel> siswaModelList = siswaService.listSiswa(pageable);
		model.addAttribute("siswaModelList", siswaModelList);
		
		return "siswa/fe_list";
	}
	
	@RequestMapping("siswa/modal_tambah")
	public String modal_tambah() {
		return "siswa/modal-tambah";
	}
	
	@RequestMapping("siswa/modal_edit")
	public String modal_edit() {
		return "siswa/modal-edit";
	}
	
	@RequestMapping("siswa/modal_hapus")
	public String modal_hapus() {
		return "siswa/modal-hapus";
	}
	
	@RequestMapping("siswa/modal_detail")
	public String modal_detail(HttpServletRequest request, Model model) {
		
		String siswaID = request.getParameter("siswaID");
		
		SiswaModel siswaModel = new SiswaModel();
		siswaModel = this.siswaService.detail_data(siswaID);

		model.addAttribute("siswaModel", siswaModel);
		
		
		return "siswa/modal-detail";
	}
	
	@RequestMapping("/siswa/list")
	public String list_siswa(Model model, @PageableDefault(page=0, value = 10) Pageable pageable) {
		
		Page<SiswaModel> siswaModelList = siswaService.listSiswa(pageable);
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
		
		return "redirect:/siswa/fe_list";
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
	
		return "redirect:/siswa/fe_list";
	}
	
	@RequestMapping("/siswa/delete_data")
	public String delete_siswa(HttpServletRequest request, Model model) {
		
		String nim_siswa = request.getParameter("siswaID");
		this.siswaService.delete_data(nim_siswa);
		
		return "redirect:/siswa/fe_list";
	}
	
	@RequestMapping("/siswa/detail_data")
	public String detail_siswa(HttpServletRequest request, Model model) {
		
		String siswaID = request.getParameter("siswaID");
		
		SiswaModel siswaModel = new SiswaModel();
		siswaModel = this.siswaService.detail_data(siswaID);

		model.addAttribute("siswaModel", siswaModel);
		
		return "/siswa/detail";
	}
	
	// Transaksi SPP Siswa
	
	@RequestMapping("/transaksi/sidenav")
	public String s_sidenav() {
		return "/components/sidenav";
	}

	@RequestMapping("/transaksi/pilihsiswa")
	public String pilihsiswa() {
		
		
		return "/transaksi/modal_pilihsiswa";
	}
	
	@RequestMapping("/transaksi/spp")
	public String spp_siswa(Model model) {
		
		List<SiswaModel> siswaModel = new ArrayList<SiswaModel>();
		siswaModel = this.siswaService.siswaTransaksi();
		model.addAttribute("sppList", siswaModel);
		
		return "/transaksi/spp_siswa";
	}
	
	@RequestMapping("/transaksi/save_spp")
	public String save_spp(HttpServletRequest request, Model model) {
		
		String no_spp = request.getParameter("no_spp");
		Date tgl_spp = Date.valueOf(request.getParameter("tgl_spp"));
		String bulan_spp = request.getParameter("bulan_spp");
		String tahunajar_spp = request.getParameter("tahunajar_spp");
		int jumlah_spp = Integer.valueOf(request.getParameter("jumlah_spp"));
		String tipebayar_spp = request.getParameter("tipebayar_spp");
		int bayar_spp = Integer.valueOf(request.getParameter("bayar_spp"));
		int kembalian_spp = Integer.valueOf(request.getParameter("kembalian_spp"));
		
		SppModel sppModel = new SppModel();
		
		sppModel.setNo_spp(no_spp);
		sppModel.setTgl_spp(tgl_spp);
		sppModel.setBulan_spp(bulan_spp);
		sppModel.setTahunajar_spp(tahunajar_spp);
		sppModel.setJumlah_spp(jumlah_spp);
		sppModel.setTipebayar_spp(tipebayar_spp);
		sppModel.setBayar_spp(bayar_spp);
		sppModel.setKembalian_spp(kembalian_spp);
		
		siswaService.save_spp(sppModel);
		
		return "redirect:/transaksi/spp";
	}
	
	// nilai
	@RequestMapping("/transaksi/nilai")
	public String nilai_siswa(Model model) {
		
		List<SiswaModel> siswaModel = new ArrayList<SiswaModel>();
		siswaModel = this.siswaService.siswaTransaksi();
		model.addAttribute("sppList", siswaModel);
		List<PelajaranModel> pelajaranModel = new ArrayList<PelajaranModel>();
		pelajaranModel = this.pelajaranService.pelajaranList();
		model.addAttribute("pelajaranList", pelajaranModel);
		
		return "/transaksi/nilai_siswa";
	}
	
	@RequestMapping("/transaksi/save_nilai")
	public String save_nilai(HttpServletRequest request, Model model) {
		
		String kode_nilai = request.getParameter("kode_nilai");
		Date tgl_ujian = Date.valueOf(request.getParameter("tgl_ujian"));
		Date tgl_penilaian = Date.valueOf(request.getParameter("tgl_penilaian"));
		String tipe_ujian = request.getParameter("tipe_ujian");
		String nilai_ujian = request.getParameter("nilai_ujian");
		String keterangan_ujian = request.getParameter("keterangan_ujian");
		
		NilaiModel nilaiModel = new NilaiModel();
		
		nilaiModel.setKode_nilai(kode_nilai);
		nilaiModel.setTgl_ujian(tgl_ujian);
		nilaiModel.setTgl_penilaian(tgl_penilaian);
		nilaiModel.setTipe_ujian(tipe_ujian);
		nilaiModel.setNilai_ujian(nilai_ujian);
		nilaiModel.setKeterangan_ujian(keterangan_ujian);
		
		siswaService.save_nilai(nilaiModel);
		
		return "redirect:/transaksi/nilai";
	}
	
}

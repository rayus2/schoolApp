/*
 * package com.kodehive.mp2.service;
 * 
 * import java.util.Date; import java.util.List;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Service; import
 * org.springframework.transaction.annotation.Transactional;
 * 
 * import com.kodehive.mp2.dto.PembayaranDTO_Transaksi; import
 * com.kodehive.mp2.model.BarangModel; import
 * com.kodehive.mp2.model.PembayaranModel_Transaksi; import
 * com.kodehive.mp2.repo.BarangRepository; import
 * com.kodehive.mp2.repo.PembayaranRepository_Transaksi; import
 * com.kodehive.mp2.repo.SiswaRepository;
 * 
 * @Service
 * 
 * @Transactional public class PembayaranService_Transaksi {
 * 
 * @Autowired private SiswaRepository siswaRepository;
 * 
 * 
 * @Autowired private PembayaranRepository_Transaksi pembayaranRepository;
 * 
 * public PembayaranModel_Transaksi savePembayaran(PembayaranDTO_Transaksi
 * pembayaranDTO) { // TODO Auto-generated method stub PembayaranModel_Transaksi
 * pembayaranModel = new PembayaranModel_Transaksi(); BarangModel barangModel =
 * BarangRepository.getId(pembayaranDTO.getKdBarang());
 * pembayaranModel.setBarangModel(barangModel); pembayaranModel.setDate(new
 * Date());
 * 
 * 
 * return pembayaranRepository.save(pembayaranModel); }
 * 
 * public List<PembayaranModel_Transaksi> findAll() { // TODO Auto-generated
 * method stub return pembayaranRepository.findAll(); }
 * 
 * public void deleteProduct(String kdBarang) { // TODO Auto-generated method
 * stub pembayaranRepository.deleteById(kdBarang); }
 * 
 * public void submitPembayaran(String id) { // TODO Auto-generated method stub
 * PembayaranModel_Transaksi pembayaranlModel = pembayaranRepository.getId(id);
 * pembayaranModel.setId("PURCHASED");
 * pembayaranRepository.save(pembayaranModel); }
 * 
 * 
 * 
 * }
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */
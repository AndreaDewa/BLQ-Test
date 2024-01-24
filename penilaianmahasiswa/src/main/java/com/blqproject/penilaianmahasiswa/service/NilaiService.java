package com.blqproject.penilaianmahasiswa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blqproject.penilaianmahasiswa.entity.Nilai;
import com.blqproject.penilaianmahasiswa.repository.NilaiRepo;

@Service
public class NilaiService {
	
	@Autowired
	private NilaiRepo repository;
	
	public Nilai saveNilai(Nilai data) {	
		return repository.save(data);
	}

	public List<Nilai> saveNilai(List<Nilai> data) {
		return repository.saveAll(data);
	}

	public List<Nilai> getNilai() {
		return repository.findAll();
	}

	public Nilai getNilaiById(Long id) {
		return repository.findById(id).orElse(null);
	}

	public Optional<Nilai> getNilaiByIdMhs(Long idMhs) {
		return repository.findByIdmhs(idMhs);
	}
	
	public Optional<Nilai> getNilaiByIdMatkul(Long idMatkul) {
		return repository.findByIdmatkul(idMatkul);
	}
	
	public String deleteById(Long id) {
		repository.deleteById(id);
		return "Data deleted successfully!";
	}
	
	public Nilai updateMataKuliah(Nilai data) {
		Optional<Nilai> existingNilai = repository.findById(data.getId());

		if (existingNilai.isPresent()) {
			Nilai updatedNilai = existingNilai.get();
			updatedNilai.setIdmatkul(data.getIdmatkul());
			updatedNilai.setIdmhs(data.getIdmhs());
			updatedNilai.setNilai(data.getNilai());


			return repository.save(updatedNilai);
		} else {
			throw new RuntimeException("Nilai dengan ID " + data.getId() + " tidak ditemukan !");
		}
	}
}

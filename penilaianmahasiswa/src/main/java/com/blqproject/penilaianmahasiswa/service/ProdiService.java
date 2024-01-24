package com.blqproject.penilaianmahasiswa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blqproject.penilaianmahasiswa.entity.Prodi;
import com.blqproject.penilaianmahasiswa.repository.ProdiRepo;

@Service
public class ProdiService {
	
	@Autowired
	private ProdiRepo repository;
	
	public Prodi saveProdi(Prodi data) {	
		return repository.save(data);
	}

	public List<Prodi> saveProdi(List<Prodi> data) {
		return repository.saveAll(data);
	}

	public List<Prodi> getProdi() {
		return repository.findAll();
	}

	public Prodi getProdiById(Long id) {
		return repository.findById(id).orElse(null);
	}

	public Optional<Prodi> getProdiName(String prodi) {
		return repository.findByProdi(prodi);
	}
	
	public String deleteById(Long id) {
		repository.deleteById(id);
		return "Data deleted successfully!";
	}
	
	public Prodi updateProdi(Prodi data) {
		Optional<Prodi> existingProdi = repository.findById(data.getId());

		if (existingProdi.isPresent()) {
			Prodi updatedProdi = existingProdi.get();
			updatedProdi.setProdi(data.getProdi());
			updatedProdi.setDescription(data.getDescription());


			return repository.save(updatedProdi);
		} else {
			throw new RuntimeException("Prodi dengan ID " + data.getId() + " tidak ditemukan !");
		}
	}
}

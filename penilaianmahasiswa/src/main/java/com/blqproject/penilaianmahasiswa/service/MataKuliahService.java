package com.blqproject.penilaianmahasiswa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blqproject.penilaianmahasiswa.entity.MataKuliah;
import com.blqproject.penilaianmahasiswa.repository.MataKuliahRepo;

@Service
public class MataKuliahService {
	
	@Autowired
	private MataKuliahRepo repository;
	
	public MataKuliah saveMataKuliah(MataKuliah data) {	
		return repository.save(data);
	}

	public List<MataKuliah> saveMultiMataKuliah(List<MataKuliah> data) {
		return repository.saveAll(data);
	}

	public List<MataKuliah> getMataKuliah() {
		return repository.findAll();
	}

	public MataKuliah getMataKuliahById(Long id) {
		return repository.findById(id).orElse(null);
	}

	public Optional<MataKuliah> getMataKuliahByName(String nama) {
		return repository.findByMatakuliah(nama);
	}
	
	public String deleteById(Long id) {
		repository.deleteById(id);
		return "Data deleted successfully!";
	}
	
	public MataKuliah updateMataKuliah(MataKuliah data) {
		Optional<MataKuliah> existingMataKuliah = repository.findById(data.getId());

		if (existingMataKuliah.isPresent()) {
			MataKuliah updatedMataKuliah = existingMataKuliah.get();
			updatedMataKuliah.setMatakuliah(data.getMatakuliah());
			updatedMataKuliah.setSks(data.getSks());


			return repository.save(updatedMataKuliah);
		} else {
			throw new RuntimeException("Mata Kuliah dengan ID " + data.getId() + " tidak ditemukan !");
		}
	}

}

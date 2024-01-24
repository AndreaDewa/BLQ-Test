package com.blqproject.penilaianmahasiswa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blqproject.penilaianmahasiswa.entity.Mahasiswa;
import com.blqproject.penilaianmahasiswa.repository.MahasiswaRepo;

@Service
public class MahasiswaService {

	@Autowired
	private MahasiswaRepo repository;

	public Mahasiswa saveMahasiswa(Mahasiswa data) {	
		return repository.save(data);
	}

	public List<Mahasiswa> saveMultiMahasiswa(List<Mahasiswa> data) {
		return repository.saveAll(data);
	}

	public List<Mahasiswa> getMahasiswa() {
		return repository.findAll();
	}

	public Mahasiswa getMahasiswaById(Long id) {
		return repository.findById(id).orElse(null);
	}

	public Optional<Mahasiswa> getMahasiswaByName(String nama) {
		return repository.findByNama(nama);
	}
	
	public String deleteById(Long id) {
		repository.deleteById(id);
		return "Data deleted successfully!";
	}
	
	public Mahasiswa updateMahasiswa(Mahasiswa data) {
		Optional<Mahasiswa> existingMahasiswa = repository.findById(data.getId());

		if (existingMahasiswa.isPresent()) {
			Mahasiswa updatedMahasiswa = existingMahasiswa.get();
			updatedMahasiswa.setNama(data.getNama());
			updatedMahasiswa.setKodeprodi(data.getKodeprodi());
			updatedMahasiswa.setEmail(data.getEmail());
			updatedMahasiswa.setKelas(data.getKelas());
			updatedMahasiswa.setSemester(data.getSemester());

			return repository.save(updatedMahasiswa);
		} else {
			throw new RuntimeException("Mahasiswa with ID " + data.getId() + " not found!");
		}
	}
}

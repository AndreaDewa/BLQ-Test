package com.blqproject.penilaianmahasiswa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.blqproject.penilaianmahasiswa.entity.Mahasiswa;
import com.blqproject.penilaianmahasiswa.service.MahasiswaService;

@RestController
@RequestMapping("/api/mahasiswa")
public class MahasiswaController {

	@Autowired
	private MahasiswaService mahasiswaService;

	@PostMapping
	public ResponseEntity<Mahasiswa> saveMahasiswa(@RequestBody Mahasiswa mahasiswa) {
		Mahasiswa savedMahasiswa = mahasiswaService.saveMahasiswa(mahasiswa);
		return new ResponseEntity<>(savedMahasiswa, HttpStatus.CREATED);
	}

	@PostMapping("/multi")
	public ResponseEntity<List<Mahasiswa>> saveMultiMahasiswa(@RequestBody List<Mahasiswa> mahasiswas) {
		List<Mahasiswa> savedMahasiswas = mahasiswaService.saveMultiMahasiswa(mahasiswas);
		return new ResponseEntity<>(savedMahasiswas, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Mahasiswa>> getMahasiswa() {
		List<Mahasiswa> mahasiswas = mahasiswaService.getMahasiswa();
		return new ResponseEntity<>(mahasiswas, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Mahasiswa> getMahasiswaById(@PathVariable Long id) {
		Mahasiswa mahasiswa = mahasiswaService.getMahasiswaById(id);
		return mahasiswa != null ? new ResponseEntity<>(mahasiswa, HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@GetMapping("/byName/{nama}")
	public ResponseEntity<Optional<Mahasiswa>> getMahasiswaByName(@PathVariable String nama) {
		Optional<Mahasiswa> mahasiswa = mahasiswaService.getMahasiswaByName(nama);
		return mahasiswa.isPresent() ? new ResponseEntity<>(mahasiswa, HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteMahasiswaById(@PathVariable Long id) {
		String result = mahasiswaService.deleteById(id);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<Mahasiswa> updateMahasiswa(@RequestBody Mahasiswa mahasiswa) {
		Mahasiswa updatedMahasiswa = mahasiswaService.updateMahasiswa(mahasiswa);
		return new ResponseEntity<>(updatedMahasiswa, HttpStatus.OK);
	}
}

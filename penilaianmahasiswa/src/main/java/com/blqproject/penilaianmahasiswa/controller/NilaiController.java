package com.blqproject.penilaianmahasiswa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.blqproject.penilaianmahasiswa.entity.Nilai;
import com.blqproject.penilaianmahasiswa.service.NilaiService;

@RestController
@RequestMapping("/api/nilai")
public class NilaiController {

	@Autowired
	private NilaiService nilaiService;

	@PostMapping
	public ResponseEntity<Nilai> saveNilai(@RequestBody Nilai nilai) {
		Nilai savedNilai = nilaiService.saveNilai(nilai);
		return new ResponseEntity<>(savedNilai, HttpStatus.CREATED);
	}

	@PostMapping("/multi")
	public ResponseEntity<List<Nilai>> saveMultiNilai(@RequestBody List<Nilai> nilais) {
		List<Nilai> savedNilais = nilaiService.saveNilai(nilais);
		return new ResponseEntity<>(savedNilais, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Nilai>> getNilai() {
		List<Nilai> nilais = nilaiService.getNilai();
		return new ResponseEntity<>(nilais, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Nilai> getNilaiById(@PathVariable Long id) {
		Nilai nilai = nilaiService.getNilaiById(id);
		return nilai != null ? new ResponseEntity<>(nilai, HttpStatus.OK) 
				: new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@GetMapping("/byIdMhs/{idMhs}")
	public ResponseEntity<Optional<Nilai>> getNilaiByIdMhs(@PathVariable Long idMhs) {
		Optional<Nilai> nilai = nilaiService.getNilaiByIdMhs(idMhs);
		return nilai.isPresent() ? new ResponseEntity<>(nilai, HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@GetMapping("/byIdMatkul/{idMatkul}")
	public ResponseEntity<Optional<Nilai>> getNilaiByIdMatkul(@PathVariable Long idMatkul) {
		Optional<Nilai> nilai = nilaiService.getNilaiByIdMatkul(idMatkul);
		return nilai.isPresent() ? new ResponseEntity<>(nilai, HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteNilaiById(@PathVariable Long id) {
		String result = nilaiService.deleteById(id);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<Nilai> updateNilai(@RequestBody Nilai nilai) {
		Nilai updatedNilai = nilaiService.updateMataKuliah(nilai);
		return new ResponseEntity<>(updatedNilai, HttpStatus.OK);
	}
	
	//nilai rata - rata/mahasiswa
	//nilai rata - rata/matkul
	
	//nilai tertinggi/matkul
	//nilai tertinggi/mahasiswa

	//nilai terendah/matkul
	//nilai terendah/mahasiswa
	
	//nilai A,B,C,D. /mahasiswa
	
	//ip mahasiswa

}

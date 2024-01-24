package com.blqproject.penilaianmahasiswa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.blqproject.penilaianmahasiswa.entity.MataKuliah;
import com.blqproject.penilaianmahasiswa.service.MataKuliahService;

@RestController
@RequestMapping("/api/matakuliah")
public class MataKuliahController {

	@Autowired
	private MataKuliahService mataKuliahService;

	@PostMapping
	public ResponseEntity<MataKuliah> saveMataKuliah(@RequestBody MataKuliah mataKuliah) {
		MataKuliah savedMataKuliah = mataKuliahService.saveMataKuliah(mataKuliah);
		return new ResponseEntity<>(savedMataKuliah, HttpStatus.CREATED);
	}

	@PostMapping("/multi")
	public ResponseEntity<List<MataKuliah>> saveMultiMataKuliah(@RequestBody List<MataKuliah> mataKuliahs) {
		List<MataKuliah> savedMataKuliahs = mataKuliahService.saveMultiMataKuliah(mataKuliahs);
		return new ResponseEntity<>(savedMataKuliahs, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<MataKuliah>> getMataKuliah() {
		List<MataKuliah> mataKuliahs = mataKuliahService.getMataKuliah();
		return new ResponseEntity<>(mataKuliahs, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<MataKuliah> getMataKuliahById(@PathVariable Long id) {
		MataKuliah mataKuliah = mataKuliahService.getMataKuliahById(id);
		return mataKuliah != null ? new ResponseEntity<>(mataKuliah, HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@GetMapping("/byName/{nama}")
	public ResponseEntity<Optional<MataKuliah>> getMataKuliahByName(@PathVariable String nama) {
		Optional<MataKuliah> mataKuliah = mataKuliahService.getMataKuliahByName(nama);
		return mataKuliah.isPresent() ? new ResponseEntity<>(mataKuliah, HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteMataKuliahById(@PathVariable Long id) {
		String result = mataKuliahService.deleteById(id);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<MataKuliah> updateMataKuliah(@RequestBody MataKuliah mataKuliah) {
		MataKuliah updatedMataKuliah = mataKuliahService.updateMataKuliah(mataKuliah);
		return new ResponseEntity<>(updatedMataKuliah, HttpStatus.OK);
	}
}

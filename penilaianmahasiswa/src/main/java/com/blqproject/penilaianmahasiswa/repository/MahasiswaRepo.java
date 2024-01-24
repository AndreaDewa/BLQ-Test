package com.blqproject.penilaianmahasiswa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blqproject.penilaianmahasiswa.entity.Mahasiswa;

public interface MahasiswaRepo extends JpaRepository<Mahasiswa, Long> {
	
	Optional<Mahasiswa> findByNama(String nama);

}

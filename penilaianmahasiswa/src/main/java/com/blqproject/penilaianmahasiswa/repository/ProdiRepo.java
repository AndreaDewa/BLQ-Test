package com.blqproject.penilaianmahasiswa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blqproject.penilaianmahasiswa.entity.Prodi;

public interface ProdiRepo extends JpaRepository<Prodi, Long>{
	
	Optional<Prodi> findByProdi(String prodi);
	
}

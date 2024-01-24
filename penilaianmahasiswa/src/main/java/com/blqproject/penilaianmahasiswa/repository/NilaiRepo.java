package com.blqproject.penilaianmahasiswa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.blqproject.penilaianmahasiswa.entity.Nilai;

public interface NilaiRepo extends JpaRepository<Nilai, Long> {
	
	@Query("SELECT x from Nilai x Where x.idmhs = :idmhs")
	Optional<Nilai> findByIdmhs(Long idmhs);

	@Query("SELECT x from Nilai x Where x.idmatkul = :idmatkul")
	Optional<Nilai> findByIdmatkul(Long idmatkul);

}

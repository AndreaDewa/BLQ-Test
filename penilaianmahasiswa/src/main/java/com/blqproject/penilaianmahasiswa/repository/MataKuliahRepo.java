package com.blqproject.penilaianmahasiswa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blqproject.penilaianmahasiswa.entity.MataKuliah;

public interface MataKuliahRepo extends JpaRepository<MataKuliah, Long> {

	Optional<MataKuliah> findByMatakuliah(String matakuliah);

}

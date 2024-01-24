package com.blqproject.penilaianmahasiswa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "nilai")
public class Nilai {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "idmhs")
	private Mahasiswa idmhs;

	@ManyToOne
	@JoinColumn(name = "idmatkul")
	private MataKuliah idmatkul;

	@Column(name = "nilai")
	private Long nilai;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Mahasiswa getIdmhs() {
		return idmhs;
	}

	public void setIdmhs(Mahasiswa idmhs) {
		this.idmhs = idmhs;
	}

	public MataKuliah getIdmatkul() {
		return idmatkul;
	}

	public void setIdmatkul(MataKuliah idmatkul) {
		this.idmatkul = idmatkul;
	}

	public Long getNilai() {
		return nilai;
	}

	public void setNilai(Long nilai) {
		this.nilai = nilai;
	}
}

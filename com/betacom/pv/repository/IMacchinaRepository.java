package com.betacom.pv.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.betacom.pv.models.Macchina;

public interface IMacchinaRepository extends JpaRepository<Macchina, Integer>{
	Boolean existsByTarga(String targa);
}

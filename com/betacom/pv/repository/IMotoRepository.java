package com.betacom.pv.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.betacom.pv.models.Moto;

public interface IMotoRepository extends JpaRepository<Moto, Integer>{
	Boolean existsByTarga(String targa);
}

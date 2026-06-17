package com.betacom.pv.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.betacom.pv.models.CategoriaVeicolo;

public interface ICategoriaVeicoloRepository extends JpaRepository<CategoriaVeicolo, Integer>{
	Optional<CategoriaVeicolo> findByDescrizioneAndTipoVeicolo_Tipo(String descrizione, String tipoVeicolo);
}

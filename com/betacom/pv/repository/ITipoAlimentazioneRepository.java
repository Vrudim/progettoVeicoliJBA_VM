package com.betacom.pv.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.betacom.pv.models.TipoAlimentazione;

public interface ITipoAlimentazioneRepository extends JpaRepository<TipoAlimentazione, Integer> {

	Optional<TipoAlimentazione> findByDescrizioneAndTipoVeicolo_Tipo(String descrizione, String tipoVeicolo);

	boolean existsByTipoVeicolo_Tipo(String tipo);

}

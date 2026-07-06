package com.betacom.pv.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.betacom.pv.models.Bici;

public interface IBiciRepository extends JpaRepository<Bici, Integer>{

    boolean existsByTipoSospensione_Descrizione(String descrizione);

    boolean existsByTipoFreno_Descrizione(String descrizione);
}

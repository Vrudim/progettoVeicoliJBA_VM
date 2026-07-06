package com.betacom.pv.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.betacom.pv.models.Veicoli;

public interface IVeicoloRepository extends JpaRepository<Veicoli, Integer>{

		@Query(name = "ricerca")
		List<Veicoli> ricerca(
				@Param("tipoVeicolo") String tipoVeicolo,
	            @Param("marca") String marca,
	            @Param("modello") String modello,
	            @Param("colore") String colore,
	            @Param("alimentazione") String alimentazione,
	            @Param("categoria") String categoria,
	            @Param("targa") String targa
	    );

		boolean existsByAlimentazione_Id(Integer id);
		boolean existsByCategoria_Id(Integer id);
		boolean existsByTipoVeicolo_Tipo(String tipo);
}

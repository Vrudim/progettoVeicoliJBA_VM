package com.betacom.pv.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table (name = "veicoli")
@Getter
@Setter
public class Veicoli {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVeicolo;

    @Column(name = "marca", nullable = false)
    private String marca;

    @Column(name = "modello", nullable = false)
    private String modello;

    @Column(name = "colore", nullable = false)
    private String colore;

    @Column(name = "anno_produzione")
    private LocalDate annoProduzione;
    

    @ManyToOne
    @JoinColumn(
        name = "tipo_veicolo",
        nullable = false
    )
    private TipoVeicolo tipoVeicolo;

    @ManyToOne
    @JoinColumn(
        name = "alimentazione",
        nullable = false
    )
    private TipoAlimentazione alimentazione;

    @ManyToOne
    @JoinColumn(
        name = "categoria",
        nullable = false
    )
    private CategoriaVeicolo categoria;
}
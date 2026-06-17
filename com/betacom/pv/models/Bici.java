package com.betacom.pv.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table (name = "bici")
public class Bici{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name ="numero_ruote",nullable = false)
    private Integer numeroRuote;

    @Column(name ="numero_marce",nullable = false)
    private Integer numeroMarce;
    
    @ManyToOne
    @JoinColumn(name = "tipo_freno", nullable = false)
    private TipoFreno tipoFreno;
    
    @ManyToOne
    @JoinColumn(name = "tipo_sospensione",nullable = false)
    private TipoSospensione tipoSospensione;

    @Column(name = "pieghevole", nullable = false)
    private Boolean pieghevole;

    @OneToOne
    @JoinColumn(name ="id_veicoli", nullable = false)
    private Veicoli veicoli;
}

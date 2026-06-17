package com.betacom.pv.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "moto")
@Getter
@Setter
public class Moto {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "targa", nullable = false, unique = true)
    private String targa;

    @Column(name = "cc", nullable = false)
    private Integer cc;

    @Column(name = "numero_ruote", nullable = false)
    private Integer numeroRuote;

    @OneToOne
    @JoinColumn(name ="id_veicoli", nullable = false)
    private Veicoli veicoli;
}

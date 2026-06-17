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
@Table(name = "macchina")
@Getter
@Setter
public class Macchina {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
    @Column(nullable = false, unique = true)
    private String targa;

    @Column(nullable = false)
    private Integer cc;

    @Column(nullable = false)
    private Integer numeroPorte;

    @Column(nullable = false)
    private Integer numeroRuote;
    
    @OneToOne
    @JoinColumn(name ="id_veicoli", nullable = false)
    private Veicoli veicoli;
}

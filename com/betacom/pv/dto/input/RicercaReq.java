package com.betacom.pv.dto.input;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RicercaReq {
    private String tipoVeicolo;
    private String marca;
    private String modello;
    private String colore;
    private String alimentazione;
    private String categoria;
    private String targa;
}

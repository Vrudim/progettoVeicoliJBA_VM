package com.betacom.pv.utils;

import com.betacom.pv.exceptions.AcademyException;
import com.betacom.pv.interfaces.IMessaggiServices;
import com.betacom.pv.models.CategoriaVeicolo;
import com.betacom.pv.models.TipoAlimentazione;
import com.betacom.pv.models.TipoFreno;
import com.betacom.pv.models.TipoSospensione;
import com.betacom.pv.models.TipoVeicolo;
import com.betacom.pv.repository.IBiciRepository;
import com.betacom.pv.repository.ICategoriaVeicoloRepository;
import com.betacom.pv.repository.ITipoAlimentazioneRepository;
import com.betacom.pv.repository.ITipoFrenoRepository;
import com.betacom.pv.repository.ITipoSospensioneRepository;
import com.betacom.pv.repository.ITipoVeicoloRepository;
import com.betacom.pv.repository.IVeicoloRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@RequiredArgsConstructor
@Service
public class Validazione {
    private final ITipoVeicoloRepository tipoR;
    private final ITipoFrenoRepository frenoR;
    private final ITipoSospensioneRepository sospR;
    private final ITipoAlimentazioneRepository alimR;
    private final ICategoriaVeicoloRepository catR;
    private final IVeicoloRepository veicR;
    private final IBiciRepository biciR;
    private final IMessaggiServices msgS;
    
    public TipoVeicolo validaTipoVeicolo(String tipo) {
        return tipoR.findById(tipo)
                .orElseThrow(() -> new AcademyException(msgS.get("veicoli.no.tipoVeicolo")));
    }

    public TipoFreno validaFreno(String tipoFreno) {
        return frenoR.findById(tipoFreno)
                .orElseThrow(() -> new AcademyException(msgS.get("bici.no.tipoFreno")));
    }

    public TipoSospensione validaSospensione(String tipoSospensione) {
        return sospR.findById(tipoSospensione)
                .orElseThrow(() -> new AcademyException(msgS.get("bici.no.tipoSospensione")));
    }

    public TipoAlimentazione validaAlimentazione(String tipoAlimentazione, String tipoVeicolo) {
        return alimR
                .findByDescrizioneAndTipoVeicolo_Tipo(tipoAlimentazione, tipoVeicolo)
                .orElseThrow(() -> new AcademyException(msgS.get("veicoli.no.alimentazione")));
    }

    public CategoriaVeicolo validaCategoria(String categoria, String tipoVeicolo) {
        return catR
                .findByDescrizioneAndTipoVeicolo_Tipo(categoria, tipoVeicolo)
                .orElseThrow(() -> new AcademyException(msgS.get("veicoli.no.categoria")));
    }

    public void validaTargaMacchina(String targa) {
        if (!targa.matches("^[A-Z]{2}[0-9]{3}[A-Z]{2}$"))
            throw new AcademyException(msgS.get("macchina.no.targa"));
    }

    public void validaTargaMoto(String targa) {
        if (!targa.matches("^[A-Z]{2}[0-9]{5}$"))
            throw new AcademyException(msgS.get("moto.no.targa"));
    }

    public void validaRuoteMacchina(Integer ruote) {
        if (ruote < 3 || ruote > 4)
            throw new AcademyException(msgS.get("macchina.no.nrRuote"));
    }

    public void validaRuoteMoto(Integer ruote) {
        if (ruote < 2 || ruote > 3)
            throw new AcademyException(msgS.get("macchina.no.nrRuote"));
    }

    public Integer validaRuoteBici(Integer ruote) {
        if (ruote < 1 || ruote > 2)
            throw new AcademyException(msgS.get("bici.no.nrRuote"));
        return ruote;
    }

    public void validaPorteMacchina(Integer porte) {
        if (porte < 3 || porte > 5)
            throw new AcademyException(msgS.get("macchina.no.nrPorte"));
    }

	public void validaNrMarce(Integer numeroMarce) {
		if (numeroMarce < 1 || numeroMarce > 8)
            throw new AcademyException(msgS.get("bici.no.nrMarce"));
	}
	
    public void validaAnno(LocalDate anno) {
        if (anno == null) throw new AcademyException(msgS.get("veicoli.no.annoP"));
        int y = anno.getYear();
        int now = java.time.Year.now().getValue();
        if (y < now-20 || y > now + 1) throw new AcademyException(msgS.get("veicoli.no.annoP"));
    }

    public void validaCc(Integer cc) {
        if (cc <= 0)
            throw new AcademyException(msgS.get("moto.no.cc"));
    }
    
    public static String clean(String s) {
        if (s == null) 
        	return null;
        if (s.isBlank()) 
        	return null;
        if ("string".equalsIgnoreCase(s)) 
        	return null;
        return s.trim();
    }

	public void checkAlim(TipoAlimentazione alim) {
		if(veicR.existsByAlimentazione_Id(alim.getId()))
            throw new AcademyException(msgS.get("alim.in.uso"));
	}
	public void checkCat(CategoriaVeicolo cat) {
		if(veicR.existsByCategoria_Id(cat.getId()))
            throw new AcademyException(msgS.get("cat.in.uso"));
	}
	public void checkFreno(TipoFreno frn) {
		if(biciR.existsByTipoFreno_Descrizione(frn.getDescrizione()))
            throw new AcademyException(msgS.get("freno.in.uso"));
	}
	public void checkSosp(TipoSospensione sosp) {
		if(biciR.existsByTipoSospensione_Descrizione(sosp.getDescrizione()))
            throw new AcademyException(msgS.get("sosp.in.uso"));
	}
	public void checkTipo(TipoVeicolo tipo) {
		if(veicR.existsByTipoVeicolo_Tipo(tipo.getTipo()) || alimR.existsByTipoVeicolo_Tipo(tipo.getTipo()) || catR.existsByTipoVeicolo_Tipo(tipo.getTipo()))
            throw new AcademyException(msgS.get("tipo.in.uso"));
	}

}
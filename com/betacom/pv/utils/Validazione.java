package com.betacom.pv.utils;

import com.betacom.pv.exceptions.AcademyException;
import com.betacom.pv.models.CategoriaVeicolo;
import com.betacom.pv.models.TipoAlimentazione;
import com.betacom.pv.models.TipoFreno;
import com.betacom.pv.models.TipoSospensione;
import com.betacom.pv.models.TipoVeicolo;
import com.betacom.pv.repository.ICategoriaVeicoloRepository;
import com.betacom.pv.repository.ITipoAlimentazioneRepository;
import com.betacom.pv.repository.ITipoFrenoRepository;
import com.betacom.pv.repository.ITipoSospensioneRepository;
import com.betacom.pv.repository.ITipoVeicoloRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@RequiredArgsConstructor
@Service
public class Validazione {

    private final ITipoVeicoloRepository tipoVeicoloRepo;
    private final ITipoFrenoRepository frenoRepo;
    private final ITipoSospensioneRepository sospRepo;
    private final ITipoAlimentazioneRepository alimentazioneRepo;
    private final ICategoriaVeicoloRepository categoriaRepo;

    public TipoVeicolo validaTipoVeicolo(String descrizione) {
        return tipoVeicoloRepo.findById(descrizione)
                .orElseThrow(() -> new AcademyException("Tipo veicolo non trovato"));
    }

    public TipoFreno validaFreno(String descrizione) {
        return frenoRepo.findById(descrizione)
                .orElseThrow(() -> new AcademyException("Freno non trovato"));
    }

    public TipoSospensione validaSospensione(String descrizione) {
        return sospRepo.findById(descrizione)
                .orElseThrow(() -> new AcademyException("Sospensione non trovata"));
    }

    public TipoAlimentazione validaAlimentazione(String descrizione, String tipoVeicolo) {
        return alimentazioneRepo
                .findByDescrizioneAndTipoVeicolo_Tipo(descrizione, tipoVeicolo)
                .orElseThrow(() -> new AcademyException("Alimentazione non valida"));
    }

    public CategoriaVeicolo validaCategoria(String descrizione, String tipoVeicolo) {
        return categoriaRepo
                .findByDescrizioneAndTipoVeicolo_Tipo(descrizione, tipoVeicolo)
                .orElseThrow(() -> new AcademyException("Categoria non valida"));
    }

    public void validaTargaMacchina(String targa) {
        if (!targa.matches("^[A-Z]{2}[0-9]{3}[A-Z]{2}$"))
            throw new AcademyException("Targa macchina non valida");
    }

    public void validaTargaMoto(String targa) {
        if (!targa.matches("^[A-Z]{2}[0-9]{5}$"))
            throw new AcademyException("Targa moto non valida");
    }

    public void validaRuoteMacchina(Integer ruote) {
        if (ruote < 3 || ruote > 4)
            throw new AcademyException("Ruote macchina non valide");
    }

    public void validaRuoteMoto(Integer ruote) {
        if (ruote < 2 || ruote > 3)
            throw new AcademyException("Ruote moto non valide");
    }

    public Integer validaRuoteBici(Integer ruote) {
        if (ruote < 1 || ruote > 2)
            throw new AcademyException("Ruote bici non valide");
        return ruote;
    }

    public void validaPorteMacchina(Integer porte) {
        if (porte < 3 || porte > 5)
            throw new AcademyException("Porte non valide");
    }

    public void validaAnno(LocalDate anno) {
        if (anno == null) throw new AcademyException("Anno non valido");
        int y = anno.getYear();
        int now = java.time.Year.now().getValue();
        if (y < now-20 || y > now + 1) throw new AcademyException("Anno non valido");
    }

    public void validaCc(Integer cc) {
        if (cc <= 0)
            throw new AcademyException("CC non valido");
    }

	public void validaNrMarce(Integer numeroMarce) {
		if (numeroMarce < 1 || numeroMarce > 8)
            throw new AcademyException("Numero marce bici non valide");
	}
}
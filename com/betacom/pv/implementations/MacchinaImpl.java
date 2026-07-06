package com.betacom.pv.implementations;

import java.util.List;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.betacom.pv.dto.input.MacchinaReq;
import com.betacom.pv.dto.output.MacchinaDTO;
import com.betacom.pv.exceptions.AcademyException;
import com.betacom.pv.interfaces.IMacchinaService;
import com.betacom.pv.mapping.MacchinaMapper;
import com.betacom.pv.models.CategoriaVeicolo;
import com.betacom.pv.models.Macchina;
import com.betacom.pv.models.TipoAlimentazione;
import com.betacom.pv.models.TipoVeicolo;
import com.betacom.pv.models.Veicoli;
import com.betacom.pv.repository.IMacchinaRepository;
import com.betacom.pv.repository.IVeicoloRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.betacom.pv.utils.Validazione;

import jakarta.transaction.Transactional;
@Service
@RequiredArgsConstructor
@Slf4j
public class MacchinaImpl implements IMacchinaService {

    private final IMacchinaRepository maccR;
    private final IVeicoloRepository veicR;
    private final Validazione valida;

    @Override
    @Transactional
    public void create(MacchinaReq req) {

        valida.validaTargaMacchina(req.getTarga());
        valida.validaRuoteMacchina(req.getNumeroRuote());
        valida.validaPorteMacchina(req.getNumeroPorte());
        valida.validaCc(req.getCc());
        valida.validaAnno(req.getAnnoProduzione());

        TipoVeicolo tipo = valida.validaTipoVeicolo("macchina");
        TipoAlimentazione alim = valida.validaAlimentazione(req.getAlimentazione(), tipo.getTipo());
        CategoriaVeicolo cat = valida.validaCategoria(req.getCategoria(), tipo.getTipo());

        Veicoli v = new Veicoli();
        v.setMarca(req.getMarca());
        v.setModello(req.getModello());
        v.setColore(req.getColore());
        v.setAnnoProduzione(req.getAnnoProduzione());
        v.setTipoVeicolo(tipo);
        v.setAlimentazione(alim);
        v.setCategoria(cat);

        v = veicR.save(v);

        Macchina m = new Macchina();
        m.setVeicoli(v);
        m.setTarga(req.getTarga());
        m.setCc(req.getCc());
        m.setNumeroPorte(req.getNumeroPorte());
        m.setNumeroRuote(req.getNumeroRuote());

        maccR.save(m);
    }

    @Override
    @Transactional
    public void update(MacchinaReq req) {
        Macchina m = maccR.findById(req.getId())
                .orElseThrow(() -> new AcademyException("Macchina non trovata"));

        Veicoli v = m.getVeicoli();

        Optional.ofNullable(req.getMarca()).ifPresent(t -> v.setMarca(t));
        Optional.ofNullable(req.getModello()).ifPresent(t -> v.setModello(t));
        Optional.ofNullable(req.getColore()).ifPresent(t -> v.setColore(t));
        Optional.ofNullable(req.getAnnoProduzione()).ifPresent(v::setAnnoProduzione);

        Optional.ofNullable(req.getTipoVeicolo())
                .ifPresent(t -> v.setTipoVeicolo(valida.validaTipoVeicolo(t)));

        Optional.ofNullable(req.getAlimentazione())
                .ifPresent(a -> v.setAlimentazione(valida.validaAlimentazione(a, v.getTipoVeicolo().getTipo())
                ));

        Optional.ofNullable(req.getCategoria())
                .ifPresent(c -> v.setCategoria(valida.validaCategoria(c, v.getTipoVeicolo().getTipo())
                ));

        veicR.save(v);

        Optional.ofNullable(req.getTarga()).ifPresent(t -> m.setTarga(t));
        Optional.ofNullable(req.getCc()).ifPresent(t -> m.setCc(t));
        Optional.ofNullable(req.getNumeroPorte()).ifPresent(t -> m.setNumeroPorte(t));
        Optional.ofNullable(req.getNumeroRuote()).ifPresent(t -> m.setNumeroRuote(t));

        maccR.save(m);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
    	Macchina m = maccR.findById(id)
                .orElseThrow(() -> new AcademyException("Macchina non trovata"));
        maccR.delete(m);
        veicR.delete(m.getVeicoli());
    }

    @Override
    public MacchinaDTO getById(Integer id) {
        return MacchinaMapper.toDTO(
                maccR.findById(id)
                        .orElseThrow(() -> new AcademyException("Macchina non trovata"))
        );
    }

    @Override
    public List<MacchinaDTO> getAll() {
        return maccR.findAll().stream()
                .map(MacchinaMapper::toDTO)
                .toList();
    }
}
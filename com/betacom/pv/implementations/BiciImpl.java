package com.betacom.pv.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.betacom.pv.dto.input.BiciReq;
import com.betacom.pv.dto.output.BiciDTO;
import com.betacom.pv.exceptions.AcademyException;
import com.betacom.pv.interfaces.IBiciService;
import com.betacom.pv.mapping.BiciMapper;
import com.betacom.pv.models.*;
import com.betacom.pv.repository.*;
import com.betacom.pv.utils.Validazione;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class BiciImpl implements IBiciService {

    private final IBiciRepository biciR;
    private final IVeicoloRepository veicR;
    private final Validazione valida;

    @Transactional
    @Override
    public void create(BiciReq req) {

        valida.validaRuoteBici(req.getNumeroRuote());
        valida.validaAnno(req.getAnnoProduzione());
        valida.validaNrMarce(req.getNumeroMarce());

        TipoVeicolo tipo = valida.validaTipoVeicolo("bici");
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

        Bici b = new Bici();
        b.setVeicoli(v);
        b.setNumeroRuote(req.getNumeroRuote());
        b.setNumeroMarce(req.getNumeroMarce());
        b.setPieghevole(req.getPieghevole());
        b.setTipoFreno(valida.validaFreno(req.getTipoFreno()));
        b.setTipoSospensione(valida.validaSospensione(req.getTipoSospensione()));

        biciR.save(b);
    }

    @Override
    @Transactional
    public void update(BiciReq req) {

        Bici b = biciR.findById(req.getId())
                .orElseThrow(() -> new AcademyException("Bici non trovata"));

        Veicoli v = b.getVeicoli();

        Optional.ofNullable(req.getMarca()).ifPresent(t -> v.setMarca(t));
        Optional.ofNullable(req.getModello()).ifPresent(t -> v.setModello(t));
        Optional.ofNullable(req.getColore()).ifPresent(t -> v.setColore(t));
        Optional.ofNullable(req.getAnnoProduzione()).ifPresent(t -> v.setAnnoProduzione(t));

        Optional.ofNullable(req.getTipoVeicolo())
                .ifPresent(t -> v.setTipoVeicolo(valida.validaTipoVeicolo(t)));

        Optional.ofNullable(req.getAlimentazione())
                .ifPresent(a -> v.setAlimentazione(valida.validaAlimentazione(a, v.getTipoVeicolo().getTipo())));

        Optional.ofNullable(req.getCategoria())
                .ifPresent(c -> v.setCategoria(valida.validaCategoria(c, v.getTipoVeicolo().getTipo())));

        veicR.save(v);

        Optional.ofNullable(req.getNumeroRuote()).ifPresent(t -> b.setNumeroRuote(t));
        Optional.ofNullable(req.getNumeroMarce()).ifPresent(t -> b.setNumeroMarce(t));
        Optional.ofNullable(req.getPieghevole()).ifPresent(t -> b.setPieghevole(t));

        Optional.ofNullable(req.getTipoFreno())
                .ifPresent(t -> b.setTipoFreno(valida.validaFreno(t)));

        Optional.ofNullable(req.getTipoSospensione())
                .ifPresent(t -> b.setTipoSospensione(valida.validaSospensione(t)));

        biciR.save(b);
    }
    
    @Override
    @Transactional
    public void delete(Integer id) {

        Bici b = biciR.findById(id)
                .orElseThrow(() -> new AcademyException("Bici non trovata"));

        biciR.delete(b);
        veicR.delete(b.getVeicoli());
    }
    
    @Override
    public BiciDTO getById(Integer id) {
        return BiciMapper.toDTO(biciR.findById(id)
                        .orElseThrow(() -> new AcademyException("Bici non trovata"))
        );
    }

    @Override
    public List<BiciDTO> getAll() {
        return biciR.findAll().stream()
                .map(b -> BiciMapper.toDTO(b))
                .toList();
    }


}
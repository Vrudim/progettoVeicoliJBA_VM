package com.betacom.pv.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.betacom.pv.dto.input.MotoReq;
import com.betacom.pv.dto.output.MotoDTO;
import com.betacom.pv.exceptions.AcademyException;
import com.betacom.pv.interfaces.IMotoService;
import com.betacom.pv.mapping.MotoMapper;
import com.betacom.pv.models.CategoriaVeicolo;
import com.betacom.pv.models.Moto;
import com.betacom.pv.models.TipoAlimentazione;
import com.betacom.pv.models.TipoVeicolo;
import com.betacom.pv.models.Veicoli;
import com.betacom.pv.repository.IMotoRepository;
import com.betacom.pv.repository.IVeicoloRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.betacom.pv.utils.Validazione;
@Service
@RequiredArgsConstructor
@Slf4j
public class MotoImpl implements IMotoService {

    private final IMotoRepository motoR;
    private final IVeicoloRepository veicR;
    private final Validazione valida;

    @Override
    public void create(MotoReq req) {

        valida.validaTargaMoto(req.getTarga());
        valida.validaRuoteMoto(req.getNumeroRuote());
        valida.validaCc(req.getCc());
        valida.validaAnno(req.getAnnoProduzione());

        TipoVeicolo tipo = valida.validaTipoVeicolo(req.getTipoVeicolo());
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

        Moto m = new Moto();
        m.setVeicoli(v);
        m.setTarga(req.getTarga());
        m.setCc(req.getCc());
        m.setNumeroRuote(req.getNumeroRuote());

        motoR.save(m);
    }

    @Override
    public void update(MotoReq req) {
    	Moto m = motoR.findById(req.getId())
                .orElseThrow(() -> new AcademyException("Moto non trovata"));

        Veicoli v = m.getVeicoli();

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

        Optional.ofNullable(req.getTarga())
        	.ifPresent(t -> {valida.validaTargaMoto(t); m.setTarga(t);
        	});

        Optional.ofNullable(req.getCc()).ifPresent(t -> m.setCc(t));
        Optional.ofNullable(req.getNumeroRuote()).ifPresent(t -> m.setNumeroRuote(t));

        motoR.save(m);
    }

    @Override
    public void delete(Integer id) {
        Moto m = motoR.findById(id)
                .orElseThrow(() -> new AcademyException("Moto non trovata"));

        motoR.delete(m);
        veicR.delete(m.getVeicoli());
    }

    @Override
    public MotoDTO getById(Integer id) {
        return MotoMapper.toDTO(
                motoR.findById(id)
                .orElseThrow(() -> new AcademyException("Moto non trovata"))
        );
    }

    @Override
    public List<MotoDTO> getAll() {
        return motoR.findAll().stream()
                .map(MotoMapper::toDTO)
                .toList();
    }
}
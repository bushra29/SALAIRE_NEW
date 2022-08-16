package org.projet.SALAIRE.MetierImp;

import org.projet.SALAIRE.dao.GrilleFiscaleRepository;
import org.projet.SALAIRE.entity.GrilleFiscale;
import org.projet.SALAIRE.entity.GrilleSalariale;
import org.projet.SALAIRE.metier.GrilleFiscaleMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GrilleFiscaleMetierImp implements GrilleFiscaleMetier {
    @Autowired
    GrilleFiscaleRepository grilleFiscaleRepository;


    @Override
    public GrilleFiscale addGrilleFiscale(GrilleFiscale gf) {
        return grilleFiscaleRepository.save(gf);
    }

    @Override
    public GrilleFiscale findGrilleFiscale(Long id) {
        return grilleFiscaleRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteGrilleFiscale(Long id) {
        grilleFiscaleRepository.deleteById(id);

    }

    @Override
    public List<GrilleFiscale> listGrilleFiscale() {
        return grilleFiscaleRepository.findAll();
    }
}

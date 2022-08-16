package org.projet.SALAIRE.metier;



import org.projet.SALAIRE.entity.GrilleFiscale;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GrilleFiscaleMetier {
    public GrilleFiscale addGrilleFiscale(GrilleFiscale gf);
    public GrilleFiscale findGrilleFiscale(Long id);
    public void deleteGrilleFiscale(Long id);
    public List<GrilleFiscale> listGrilleFiscale();
}

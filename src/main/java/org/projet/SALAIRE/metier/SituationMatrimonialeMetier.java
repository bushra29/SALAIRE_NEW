package org.projet.SALAIRE.metier;

import java.util.List;

import org.projet.SALAIRE.entity.SituationMatrimoniale;

public interface SituationMatrimonialeMetier {
	public SituationMatrimoniale addSituation(SituationMatrimoniale s);
	public SituationMatrimoniale findSituation(Long id);
	public void deleteSituation(Long id);
	public List<SituationMatrimoniale> listSituation();

}

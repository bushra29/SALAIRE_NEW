package org.projet.SALAIRE.metier;

import java.util.List;


import org.projet.SALAIRE.entity.Echelon;

public interface EchelonMetier {
	public Echelon addEchelon(Echelon e);
	public Echelon findEchelon(Long id);
	public void deleteEchelon(Long id);
	public List<Echelon> listEchelon();


}

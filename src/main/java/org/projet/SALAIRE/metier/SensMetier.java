package org.projet.SALAIRE.metier;

import java.util.List;

import org.projet.SALAIRE.entity.Sens;


public interface SensMetier {
	public  Sens addSens(Sens s);
	public  Sens findSens(Long id);
	public void deleteSens(Long id);
	public List< Sens> listSens();


}

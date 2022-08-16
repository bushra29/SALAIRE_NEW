package org.projet.SALAIRE.metier;

import java.util.List;

import org.projet.SALAIRE.entity.Parametre;

public interface ParametreMetier {
	public Parametre addParametre(Parametre p);
	public Parametre findParametre(Long id);
	public void deleteParametre(Long id);
	public List<Parametre> listParametre();


}

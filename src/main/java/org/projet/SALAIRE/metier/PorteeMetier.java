package org.projet.SALAIRE.metier;

import org.projet.SALAIRE.entity.Portee;

import java.util.List;


public interface PorteeMetier {
	public Portee addPortee(Portee p);
	public Portee findPortee(Long id);
	public void deletePortee(Long id);
	public List<Portee> listPortee();

}

package org.projet.SALAIRE.metier;

import java.util.List;

import org.projet.SALAIRE.entity.Avance;

public interface AvanceMetier {

	public Avance addAvance(Avance a);
	public Avance findAvance(Long id);
	public void deleteAvance(Long id);
	public List<Avance> listAvance();


}

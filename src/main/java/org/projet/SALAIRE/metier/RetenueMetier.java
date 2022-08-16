package org.projet.SALAIRE.metier;

import java.util.List;

import org.projet.SALAIRE.entity.Retenue;

public interface RetenueMetier {
	public Retenue addRetenue(Retenue r);
	public Retenue findRetenue(Long id);
	public void deleteRetenue(Long id);
	public List<Retenue> listRetenue();

}

package org.projet.SALAIRE.metier;

import java.util.List;

import org.projet.SALAIRE.entity.ModeDePaiement;

public interface ModeDePaiementMetier {
	public ModeDePaiement addMode(ModeDePaiement m);
	public ModeDePaiement findMode(Long id);
	public void deleteMode(Long id);
	public List<ModeDePaiement> listMode();


}

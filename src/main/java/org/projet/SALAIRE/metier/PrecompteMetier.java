package org.projet.SALAIRE.metier;

import java.util.List;

import org.projet.SALAIRE.entity.Precompte;

public interface PrecompteMetier {
	public Precompte addPrecompte(Precompte p);
	public Precompte findPrecompte(Long id);
	public void deletePrecompte(Long id);
	public List<Precompte> listPrecompte();

}

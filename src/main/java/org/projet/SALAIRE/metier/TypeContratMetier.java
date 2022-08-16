package org.projet.SALAIRE.metier;

import java.util.List;

import org.projet.SALAIRE.entity.TypeContrat;

public interface TypeContratMetier {
	public TypeContrat addTypeContrat(TypeContrat tc);
	public TypeContrat findTypeContrat(Long id);
	public void deleteTypeContrat(Long id);
	public List<TypeContrat> listTypeContrat();


}

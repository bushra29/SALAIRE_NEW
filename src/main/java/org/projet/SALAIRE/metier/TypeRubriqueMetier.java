package org.projet.SALAIRE.metier;

import java.util.List;

import org.projet.SALAIRE.entity.TypeRubrique;

public interface TypeRubriqueMetier {
	public TypeRubrique addTypeRubrique(TypeRubrique tr);
	public TypeRubrique findTypeRubrique(Long id);
	public void deleteTypeRubrique(Long id);
	public List<TypeRubrique> listTypeRubrique();


}

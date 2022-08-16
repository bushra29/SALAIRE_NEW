package org.projet.SALAIRE.dao;

import org.projet.SALAIRE.entity.Parametre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ParametreRepository extends JpaRepository<Parametre, Long> {
	@Query("select p from Parametre p where p.Libelle='Niveau'")
	public Parametre findbyNiveau();
	@Query("select p from Parametre p where p.Libelle='Categorie'")
	public Parametre findbyCategorie();
	@Query("select p from Parametre p where p.Libelle='Echelon'")
	public Parametre findbyEchellon();
	@Query("select p from Parametre p")
	public Parametre findAllParam();



}

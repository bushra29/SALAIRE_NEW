package org.projet.SALAIRE.dao;

import java.util.List;

import org.projet.SALAIRE.entity.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategorieRepository extends JpaRepository<Categorie, Long>{
	@Query("select c from Categorie c")
	public Categorie findAllCategorie();
	@Query("select c from Categorie c ")
	List<Categorie> findAllOrder();

}

package org.projet.SALAIRE.dao;

import java.util.List;

import org.projet.SALAIRE.entity.PrimeGlobale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PrimeGlobaleRepository extends JpaRepository<PrimeGlobale, Long> {
	@Query("select pg from PrimeGlobale pg where pg.categorie.IdCateg=:x")
	List<PrimeGlobale>findAllByCategorie(@Param(value = "x") Long IdCateg);

}

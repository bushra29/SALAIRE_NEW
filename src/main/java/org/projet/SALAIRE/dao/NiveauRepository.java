package org.projet.SALAIRE.dao;

import java.util.List;

import org.projet.SALAIRE.entity.Niveau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface NiveauRepository extends JpaRepository<Niveau, Long> {
	@Query("select n from Niveau n")
	List<Niveau> findAllNiveau();
	@Query("select n from Niveau n order by n.Rang asc")
	List<Niveau> findAllOrderByRang();

}

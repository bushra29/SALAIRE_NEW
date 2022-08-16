package org.projet.SALAIRE.dao;

import org.projet.SALAIRE.entity.Echelon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EchelonRepository extends JpaRepository<Echelon, Long> {
	
@Query("select e from Echelon e")
public Echelon findAllEchelon();

}

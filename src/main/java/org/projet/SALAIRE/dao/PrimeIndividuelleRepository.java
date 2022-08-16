package org.projet.SALAIRE.dao;

import java.util.List;

import org.projet.SALAIRE.entity.PrimeIndividuelle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PrimeIndividuelleRepository extends JpaRepository<PrimeIndividuelle, Long> {
@Query("select pi from PrimeIndividuelle pi where pi.contrat.IdContrat=:x")
List<PrimeIndividuelle>findAllByIdContrat(@Param(value = "x") Long IdContrat);
}



/*@Query("select pi from primeIndividuelle pi where pi.Contrat.idContrat is null")
List<PrimeIndividuelle>findAllByIdContratNull();


/*
  
 * */

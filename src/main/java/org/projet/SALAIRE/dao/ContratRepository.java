package org.projet.SALAIRE.dao;

import org.projet.SALAIRE.entity.BulletinSalaire;
import org.projet.SALAIRE.entity.Contrat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContratRepository extends JpaRepository<Contrat, Long>{
    @Query("select c from Contrat c where c.Etat=1")
    List<Contrat> findContratActif();

    @Modifying
    @Query(value="UPDATE Contrat c SET c.agent.Etat=true WHERE c.agent.IdAgent is not null ", nativeQuery = true)
    void activerAgent();

    @Query(value="select distinct(c.contrat) from GrilleSalariale c where c.contrat.Etat=true and c.bulletinSalaire=:x order by c.contrat.agent.NomAgent,c.contrat.agent.PrenomAgent")
    List<Contrat> findContratTraiter(@Param("x")BulletinSalaire bulletinSalaire);
}


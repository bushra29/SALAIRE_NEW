package org.projet.SALAIRE.dao;


import java.util.List;

import org.projet.SALAIRE.entity.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface AgentRepository extends JpaRepository<Agent, Long> {

    /*@Query("UPDATE Agent a SET a.etat=false WHERE a.etat=true")
    void toutDesactiver();

    @Query("UPDATE Agent a SET a.etat=true WHERE a.IdAgent =: x")
    void activerAgent(@Param("x")Long IdAgent);*/

    @Modifying
    @Query("UPDATE Agent a SET a.Etat=false WHERE a.Etat=true")
    void toutDesactiver();
    @Modifying
    @Query("UPDATE Agent a SET a.Etat=true WHERE a.IdAgent=:x")
    void activerAgent(@Param("x")Long IdAgent);

    @Query("select count(*) from Agent a")
    public int nbreAgent(Agent a);

   // @Modifying
   //@Query(value = "SELECT a FROM Agent a WHERE a.NomAgent like %:keyword% or a.PrenomAgent like %:keyword%", nativeQuery = true)
    //List<Agent>findByNom(@Param(value="keyword") String NomAgent);

	 
	
}

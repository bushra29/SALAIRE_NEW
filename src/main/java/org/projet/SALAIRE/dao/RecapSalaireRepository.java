package org.projet.SALAIRE.dao;

import org.projet.SALAIRE.entity.GrilleSalariale;
import org.projet.SALAIRE.entity.RecapSalaire;
import org.projet.SALAIRE.entity.Retenue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RecapSalaireRepository extends JpaRepository<RecapSalaire,Long> {

    @Query("select r from RecapSalaire r where r.contrat.IdContrat=:x and r.bulletinSalaire.IdBulletin=:y ")
    public RecapSalaire findByIdContrat( @Param(value="x")Long IdContrat,@Param(value="y") Long IdBulletin);

@Query("select sum(r.montant) from RecapSalaire r where r.bulletinSalaire.IdBulletin=:x")
    Double totalSalaire( @Param(value="x")Long idBulletin);
}

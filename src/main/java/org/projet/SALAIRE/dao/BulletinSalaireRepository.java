package org.projet.SALAIRE.dao;
//import java.util.List;

import org.projet.SALAIRE.entity.Annee;
import org.projet.SALAIRE.entity.BulletinSalaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BulletinSalaireRepository extends JpaRepository<BulletinSalaire, Long>{
	//@Query("select b from BulletinSalaire b where b.Annee.IdAnnee=:x and b.Mois.IdMois=:y")
	//List<BulletinSalaire>findBullByAnneeMois(@Param(value="x")Long IdAnnee, @Param(value ="y") Long IdMois);
    @Query("select a from Annee a where a.Etat=true")
    public Annee getAnneeActive();
}

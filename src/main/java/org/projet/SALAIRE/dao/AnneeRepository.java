package org.projet.SALAIRE.dao;

import org.projet.SALAIRE.entity.Annee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
@Transactional
public interface AnneeRepository extends JpaRepository<Annee, Long>{
	@Query("select a from Annee a where a.Etat =true")
	public Annee getAnneeTrue();
	@Modifying
	@Query("UPDATE Annee a SET a.Etat=false WHERE a.Etat=true")
	void toutDesactiver();
	@Modifying
	@Query("UPDATE Annee a SET a.Etat=true WHERE a.IdAnnee =:x")
	void activerAnnee(@Param("x")Long IdAnnee);


}

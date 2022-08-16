package org.projet.SALAIRE.dao;

import org.projet.SALAIRE.entity.Mois;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface MoisRepository extends JpaRepository<Mois, Long> {
	@Query("select m from Mois m where m.Etat = true")
	public Mois getMoisTrue();

	@Modifying
	@Query("UPDATE Mois m SET m.Etat=false WHERE m.Etat=true")
	void toutDesactiver();
	@Modifying
	@Query("UPDATE Mois m SET m.Etat=true WHERE m.IdMois=:x")
	void activerMois(@Param("x")Long IdMois);
	
}

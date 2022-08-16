package org.projet.SALAIRE.dao;

import org.projet.SALAIRE.entity.Retenue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  RetenueRepository extends JpaRepository<Retenue, Long>{

}

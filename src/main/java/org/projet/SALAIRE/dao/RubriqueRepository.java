package org.projet.SALAIRE.dao;

import java.util.List;


import org.projet.SALAIRE.entity.Rubrique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RubriqueRepository extends JpaRepository<Rubrique, Long> {

}

package org.projet.SALAIRE.dao;

import java.util.List;

import org.projet.SALAIRE.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GrilleSalarialeRepository extends JpaRepository<GrilleSalariale, Long>{
	
	//@Query("insert into GrilleSalariale () ")
	/*@Query("select c.Agent.NomAgent from Contrat c where c.DateFin is null and c.Etat=1")
	public List<Contrat> findContratActif();*/
	//@Query("select a from Avance a where a.DateFin is null")
	//public List<Avance> findAvanceActive();
	//@Query("select pg from PrimeGlobale order by pg.Categorie.IdCategorie")
	//public List<PrimeGlobale> insertPrimeG();
	//public List<PrimeGlobale> findAllPrimeG();
	//@Query("select pi from PrimeIndividuelle order by pi.Contrat.IdContrat")
	//public List<PrimeIndividuelle> findPrimeI();
	
	@Query("select gs from GrilleSalariale gs where gs.IdGrille=:x")
	public List<GrilleSalariale>findAllById(@Param(value = "x") Long IdGrille);
	//@Query("insert into GrilleSalariale g (Avance a,Contrat c, )")

	@Query("select gs from GrilleSalariale gs where gs.bulletinSalaire.IdBulletin=:x")
	public List<GrilleSalariale>findAllByBulletin(@Param(value = "x") Long IdBulletin);

	@Query("select sum(g.TauxFixe) from GrilleSalariale g where g.contrat=:y and g.bulletinSalaire=:x")
	public double sommeTaxeFixe(@Param(value="x") BulletinSalaire bulletinSalaire, @Param(value="y")Contrat contrat);

	@Query("select sum(g.MontantPrimeI) from GrilleSalariale g where g.contrat=:y and g.bulletinSalaire=:x")
	double sommePrimeI(@Param(value="x") BulletinSalaire bulletinSalaire, @Param(value="y")Contrat contrat);

	@Query("select sum(g.MontantPrimeG) from GrilleSalariale g where g.contrat=:y and g.bulletinSalaire=:x")
	double sommePrimeG(@Param(value="x") BulletinSalaire bulletinSalaire, @Param(value="y")Contrat contrat);
	@Query("select sum(g.MontantSalaire) from GrilleSalariale g where g.contrat=:y and g.bulletinSalaire=:x")
	double sommeSalaireBase(@Param(value="x") BulletinSalaire bulletinSalaire, @Param(value="y")Contrat contrat);

	@Query("select g.primeGlobale from GrilleSalariale g where g.contrat.IdContrat=:y and g.bulletinSalaire.IdBulletin=:x  and g.primeGlobale.rubrique.IdRubrique<=1")
	public List<PrimeGlobale>findPrimeGByContratSalaireBase(@Param(value="y")Long IdContrat, @Param(value="x") Long IdBulletin);

	@Query("select g from GrilleSalariale g where g.primeGlobale=:x and g.bulletinSalaire.IdBulletin=:y and g.contrat.IdContrat=:z")
	public GrilleSalariale findByPrimeG(@Param(value="x") PrimeGlobale primeGlobale, @Param(value="y") Long IdBulletin, @Param(value="z")Long IdContrat);

	@Query("select g.primeGlobale from GrilleSalariale g where g.bulletinSalaire.IdBulletin=:x and g.contrat.IdContrat=:y")
	public List<PrimeGlobale>findGrilleBycontratSolde(@Param(value = "x")Long IdBulletin,@Param(value = "y") Long IdContrat);

	@Query("select g.primeIndividuelle from GrilleSalariale g where g.contrat.IdContrat=:y and g.bulletinSalaire.IdBulletin=:x")
	public List<PrimeIndividuelle>findPrimeIByContrat( @Param(value="y")Long IdContrat,@Param(value="x") Long IdBulletin);

	@Query("select g from GrilleSalariale g where g.primeIndividuelle=:x and bulletinSalaire=:y ")
	public GrilleSalariale findByIdPrimeIndividuelle(@Param(value="x") PrimeIndividuelle primeIndividuelle, @Param(value="y") BulletinSalaire bulletinSalaire);

	@Query("select g.retenue from GrilleSalariale g where g.bulletinSalaire.IdBulletin=:x and g.contrat.IdContrat=:y")
	public List<Retenue>findByRetenue(@Param(value = "y") Long IdContrat,@Param(value = "x")Long IdBulletin);

	@Query("select g from GrilleSalariale g where g.retenue=:x and g.bulletinSalaire.IdBulletin=:y and g.contrat.IdContrat=:z")
	public GrilleSalariale findByIdRetenue(@Param(value="x") Retenue retenue, @Param(value="y") Long IdBulletin, @Param(value="z")Long IdContrat);


	@Query("select g.primeGlobale from GrilleSalariale g where g.contrat.IdContrat=:y and g.bulletinSalaire.IdBulletin=:x and g.primeGlobale.rubrique.IdRubrique >1")
	public List<PrimeGlobale>findPrimeAllByContratBulletin(@Param(value="y")Long IdContrat, @Param(value="x") Long IdBulletin);

}



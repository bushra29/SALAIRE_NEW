package org.projet.SALAIRE.MetierImp;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.projet.SALAIRE.dao.*;
import org.projet.SALAIRE.entity.*;
import org.projet.SALAIRE.metier.GrilleSalarialeMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;


@Service
public class GrilleSalarialeMetierImp implements GrilleSalarialeMetier {

	@Autowired
	GrilleSalarialeRepository grilleSalarialeRepository;
	@Autowired
	RetenueRepository retenueRepository;
	@Autowired
	BulletinSalaireRepository bulletinSalaireRepository;
	@Autowired
	ContratRepository contratRepository;
	@Autowired
	PrimeGlobaleRepository primeGlobaleRepository;
	@Autowired
	PrimeIndividuelleRepository primeIndividuelleRepository;


	@Override
	public GrilleSalariale addGrille(GrilleSalariale g) {

		return grilleSalarialeRepository.save(g);
	}


	@Override
	public GrilleSalariale findGrille(Long id) {
		// TODO Auto-generated method stub
		return grilleSalarialeRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteGrille(Long id) {
		// TODO Auto-generated method stub
		grilleSalarialeRepository.deleteById(id);


	}



	@Override
	public List<GrilleSalariale> listGrille() {
		// TODO Auto-generated method stub
		return grilleSalarialeRepository.findAll();
	}

	@Override
	public boolean TraiterSalaire(Long idBulletin) {

		boolean resultat = false;

		BulletinSalaire b = bulletinSalaireRepository.findById(idBulletin).orElse(null);
		List<GrilleSalariale> LGrilleSalariale = grilleSalarialeRepository.findAllByBulletin(idBulletin);
		System.out.println("bulletin"+b.getIdBulletin());

		if (LGrilleSalariale.size() > 1) {
			resultat = false;
		} else {
//Liste des contrats actifs
			List<Contrat> Lcontrat = contratRepository.findContratActif();
			for (Contrat c : Lcontrat) {
//Recuperer primeGlobale
				System.out.println("contrat"+c.getIdContrat());
				List<PrimeGlobale> LprimeG = primeGlobaleRepository.findAllByCategorie(c.getEchelon().getCategorie().getIdCateg());
			//LocalDate Date1= LocalDate.now();
				Date Date1= new Date();

				for (PrimeGlobale pg : LprimeG) {
				System.out.println("primeG"+pg.getRubrique().getLibelleRubri()+""+pg.getRubrique().getTaux());
					//if (pg.getDateFin() == null || pg.getDateFin().isAfter(Date1)) {
					if (pg.getDateFin() == null || pg.getDateFin().after(Date1)) {

						if (pg.getRubrique().getIdRubrique() == 1)
						{

							GrilleSalariale g = new GrilleSalariale(Date1, c.getEchelon().getSalaire(),0.0,0.0,0.0,0.0,b,c,pg);
							System.out.println("salaire"+c.getEchelon().getSalaire());
							grilleSalarialeRepository.save(g);
						}

						else {
							if (pg.getRubrique().getTaux() == 0) {
								GrilleSalariale g = new GrilleSalariale(Date1,0.0,pg.getMontant(),0.0,0.0,0.0,b,c,pg);
								grilleSalarialeRepository.save(g);
							}
							if (pg.getRubrique().getTaux() != 0) {
								GrilleSalariale g = new GrilleSalariale(Date1,(c.getEchelon().getSalaire() * pg.getRubrique().getTaux()) / 100,0.0,0.0,pg.getRubrique().getTaux(),0.0, b, c,pg);
								grilleSalarialeRepository.save(g);
							}
						}
					}
				}
				List<PrimeIndividuelle> LPrimeI = primeIndividuelleRepository.findAllByIdContrat(c.getIdContrat());
				for (PrimeIndividuelle pi : LPrimeI) {
					if (pi.getDateFin() == null || pi.getDateFin().after(Date1)) {
						System.out.println("pi" + pi.getRubrique().getLibelleRubri());

						if (pi.getRubrique().getTaux() == 0) {
							GrilleSalariale g = new GrilleSalariale(Date1,0.0,0.0,pi.getMontant(),0.0,0.0,b,c, pi);
							grilleSalarialeRepository.save(g);
						}
						if (pi.getRubrique().getTaux() != 0) {
							GrilleSalariale g = new GrilleSalariale(Date1,(c.getEchelon().getSalaire() * pi.getRubrique().getTaux()) / 100,0.0,0.0,0.0, pi.getRubrique().getTaux(),b,c,pi);
							grilleSalarialeRepository.save(g);
						}
					}
					else {}
				}
				List<Retenue> LRetenue = retenueRepository.findAll();
				for (Retenue r : LRetenue) {
					GrilleSalariale g = new GrilleSalariale(Date1,r.getTauxPatron(), r.getTauxEmploy(), r.getTauxFixe(), b, c,r);
					System.out.println("taux"+r.getTauxPatron());
					grilleSalarialeRepository.save(g);
				}
				resultat = true;
			}

			b.setEtat(true);
			bulletinSalaireRepository.save(b);
		}


		return resultat;

	}
}
	
	/*public void CalculSalaire()
	{
		List<PrimeGlobale> Lpg = grilleSalarialeRepository.findAllPrimeG();
		List<PrimeIndividuelle> Lpi = grilleSalarialeRepository.findPrimeI();
		List<Avance>La = grilleSalarialeRepository.findAvanceActive();
		List<GrilleSalariale>Lg = grilleSalarialeRepository.findAll();
	
	}*/


	/*@Override
	public void genererSalaire(Long id) {
		// TODO Auto-generated method stub
		
	}*/
	//---------------------------------------------------------------------------------------------------
	/*public Date differenceDate(Date a, Date b)
	{
		Date Res;
		return Res=a--b;
	}
	//---------------------------------------------------------------------------------------------------
	
	public boolean genererSalaire(Long id)
	{
		boolean resultat = false;
		BulletinSalaire bulletin = bulletinSalaireRepository.findById(id).get();
		//System.out.println("Valeur bulletin "+bullettin.getIdBulletin());
		List<GrilleSalariale> LGrilleSalariales = grilleSalarialeRepository.findAllById(id);
		if (LGrilleSalariales.size() > 1)
		{
			resultat = false;
		}
		else 
		{
			//Début de l'operation d'attribution de salaire par employe
			
			//Liste des contrats actifs dans l'entreprise
			List<Contrat> Lcontrats = contratRepository.findAll();
			//Boucle de parcours de l'employe actif pour le traitement de salire
			for( Contrat contrat : Lcontrats )
			{
				//Recuperation de la liste des primes globale
				List<PrimeGlobale> LPrimeGlobale = primeGlobaleRepository.findAllByCategorie(contrat.getEchelon().getCategorie().getIdCateg());
				for (PrimeGlobale pg : LPrimeGlobale) 
				{
						if(new Date() == pg.getDateFin())	
						{
							System.out.println("Cette prime n'est plus assignable a un employe date fin ateint");
						}
						else
						{
							
							if (pg.getIdPrimeG()==1L)
									
							{
								System.out.println("SALAIRE BASE");
								
							
								GrilleSalariale grilleSalariale = grilleSalarialeRepository.save(new GrilleSalariale( new Date(),0,contrat,pg,0,0 ));
							}
						}
				}
				//Recuperation de la liste des primes individuelle
				List<PrimeIndividuelle> Lprimeindividelles = primeIndividuelleRepository.findByContrat(contrat.getIdContrat());
				for(PrimeIndividuelle p : Lprimeindividelles)
				{
						if(new Date() == p.getDateFin())	
						{
							System.out.println("Cette prime n'est plus assignable a un employe date fin atteint");
						}
						else 
						{
							
							if (p.getTauxPrimeI() == 0) 
							{

								GrilleSalariale grilleSalariale = grilleSalarialeRepository.save(new GrilleSalariale(new Date(),0,contrat,pg,p,0 ));
									
							}
							else
							{
								//Assignation assignation = assignationRepository.save(new Assignation(new Date(),0, 0, ( (contrat.getEchellons().getSalaireBase()*a.getPrime().getTaux())/100 ), a.getPrime().getTaux(), 0, 0, bullettin, contrat, a));

								GrilleSalariale grilleSalariale = grilleSalarialeRepository.save(new GrilleSalariale(new Date(),0,contrat,pg,p.getMontant(),0 );
								
							}
							
							
						
						}
				}
				
				//Liste des retenues
				List<Retenue> Lretenues = retenueRepository.findAll();
				for( Retenue retenue : Lretenues)
				{
					GrilleSalariale grilleSalariale = grilleSalarialeRepository.save(new GrilleSalariale (new Date(), retenue.getTauxPatron(), retenue.getTauxEmploy(), retenue.getTauxFixe(), bulletin, contrat,retenue));
				}
				

				resultat = true;
			}

			bulletin.setEtat(true);
			bulletinSalaireRepository.save(bulletin);
		}


		return resultat;
	}

						
				
			
		
	}
	
	/*public boolean genererGrille(Long id) {
		
		boolean resultat = false;
		BulletinSalaire bullettin = bulletinSalaireRepository.findById(id).get();
		System.out.println("Valeur bulletin "+bullettin.getIdBulletin());
		List<GrilleSalariale> LGrilleSalariales = grilleSalarialeRepository.findAllById(id);
		if (LGrilleSalariales.size() > 1)
		{
			resultat = false;
		}
		else 
		{
			//Début de l'operation d'attribution de salaire par employe
			
			//Liste des contrats actifs dans l'entreprise
			List<Contrat> Lcontrats = contratRepository.findAll();
			
			//Boucle de parcours de l'employe actif pour le traitement de salire
			for( Contrat contrat : Lcontrats )
			{
				//Recuperation de la liste des primes globale
				List<AttributionValeur> Lattributionvaleurs = attributionValeurRepository.findAllAttributionValeurByCategorie(contrat.getEchelon().getCategorie().getId());
				
				for (AttributionValeur a : Lattributionvaleurs) 
				{
						if(new Date() == a.getDateFin())	
						{
							System.out.println("Cette prime n'est plus assignable a un employe date fin ateint");
						}
						else 
						{
							
							if (a.getPrime().getId() == 1L) 
							{
								System.out.println("SALAIRE BASE");
								
							
								GrilleSalariale grilleSalariale = grilleSalarialeRepository.save(new GrilleSalariale(new Date(), contrat.getEchelon().getSalaire(), 0, 0, 0, 0, 0, bullettin, contrat, a));
										
								
							}
							else if (a.getPrime().getId() == 2L) 
							{
								System.out.println("ANCIENETE");
								
								String DateDebut = StringUtils.datetoString(contrat.getDateDebut());
								String DateActuelle = StringUtils.datetoString(new Date());
								
								float NombreJours = StringUtils.differenceDate(DateDebut, DateActuelle);
								List<Anciennete> Lanciennete = ancienneteRepository.findAll();
								
								for(Anciennete ancien : Lanciennete )
								{
									float resultats = StringUtils.convert( NombreJours / 365);
									
									System.out.println("NombreJours " +resultats);
									
									if ( ( resultats >= ancien.getBorneInferieur() ) && (resultats <= ancien.getBorneSuperieur())) 
									{
										if (resultats < 2) {
											
											GrilleSalariale grilleSalariale = GrilleSalarialeRepository.save(new GrilleSalariale(new Date(),0, 0, 0, 0, 0, 0, bullettin, contrat, a));
											
										}
										else 
										{
											float recupererTaux = ancien.getTaux();										
											double valeurs = (recupererTaux * contrat.getEchelon().getSalaire()) / 100 ;
											GrilleSalariale grilleSalariale = grilleSalarialeRepository.save(new GrilleSalariale(new Date(),0, valeurs, 0, 0, 0, 0, bullettin, contrat, a));
											
										}
										
								   }
									else 
									{
										System.out.println("L'ancienne de l'employe ne figure pas dans la grille d'ancienete");
											
									}
								}
								
								
							}
							else
							{
							
								if (a.getPrime().getTaux() == 0) 
								{
									Assignation assignation = assignationRepository.save(new Assignation(new Date(),0, 0, a.getMontant(), a.getPrime().getTaux(), 0, 0, bullettin, contrat, a));
										
								}
								else
								{
									Assignation assignation = assignationRepository.save(new Assignation(new Date(),0, 0,Math.round( ( (contrat.getEchellons().getSalaireBase()*a.getPrime().getTaux())/100 )), a.getPrime().getTaux(), 0, 0, bullettin, contrat, a));
									
								}
								
								
							}
						}
				}
				
				//Recuperation de la liste des primes individuelle
				List<PrimeIndividuelle> Lprimeindividelles = primeIndividuelleRepository.findByContrat(contrat.getId());
				for(PrimeIndividuelle p : Lprimeindividelles)
				{
						if(new Date() == p.getDateFin())	
						{
							System.out.println("Cette prime n'est plus assignable a un employe date fin atteint");
						}
						else 
						{
							
							if (p.getPrime().getTaux() == 0) 
							{

								Assignation assignation = assignationRepository.save(new Assignation(new Date(),0, 0, 0, 0, p.getMontant(), p.getPrime().getTaux(), bullettin, contrat, p));
									
							}
							else
							{
								//Assignation assignation = assignationRepository.save(new Assignation(new Date(),0, 0, ( (contrat.getEchellons().getSalaireBase()*a.getPrime().getTaux())/100 ), a.getPrime().getTaux(), 0, 0, bullettin, contrat, a));

								Assignation assignation = assignationRepository.save(new Assignation(new Date(),0, 0, 0, 0, Math.round(( (contrat.getEchellons().getSalaireBase()*p.getPrime().getTaux())/100 )), p.getPrime().getTaux(), bullettin, contrat, p));
								
							}
							
							
						
						}
				}
				
				//Liste des retenues
				List<Retenu> Lretenus = retenuRepository.findAll();
				for( Retenu retenu : Lretenus)
				{
					assignationRepository.save(new Assignation(new Date(), retenu.getTauxPatronal(), retenu.getTauxOuvriere(), retenu.getTauxFix(), bullettin, contrat, retenu));
				}
				
				
				resultat = true;
			}
			
			bullettin.setEtat(true);
			bulletinRepository.save(bullettin);
		}
		
		
		return resultat;
	}


	@Override
	public void genererSalaire(Long id) {
		// TODO Auto-generated method stub
		
	}}*/
	/*public boolean TraiterSalaire(long IdBulletin) {
		boolean resultat = false;

		BulletinSalaire b = bulletinSalaireRepository.findById(IdBulletin).orElse(null);
		List<GrilleSalariale> LGrilleSalariale = grilleSalarialeRepository.findById(IdGrille).orElse(null);

		if (LGrilleSalariale.size() > 1)
		{
			resultat = false;
		}
		else
		{
//Liste des contrats actifs
		List<Contrat> Lcontrat = contratRepository.findContratActif();
		for (Contrat c : Lcontrat) {
//Recuperer primeGlobale
			List<PrimeGlobale> LprimeG = primeGlobaleRepository.findAllByCategorie(c.getEchelon().getCategorie().getIdCateg());
			for (PrimeGlobale pg : LprimeG) {
				//Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(pg.getDateFin());
				//|| (pg.getDateFin().compareTo(new Date())=1
				if (pg.getDateFin() == null ) {
					if (pg.getRubrique().getIdRubrique() == 1)
//sachant que dans mes rubriques, le id1=Salairedebase
					{
						GrilleSalariale g = new GrilleSalariale(pg, c.getEchelon().getSalaire(), b, c);
					}
					if (pg.getRubrique().getTaux() == 0) {
						GrilleSalariale g = new GrilleSalariale(pg, pg.getMontant(), b, c);
					}
					if (pg.getRubrique().getTaux() != 0) {
						GrilleSalariale g = new GrilleSalariale(pg, (c.getEchelon().getSalaire() * pg.getRubrique().getTaux()) / 100, b, c, pg.getRubrique().getTaux());
						//(pour le stocker au cas ou ca changeait)
					} else {
					}
				}
			}
			List<PrimeIndividuelle> LPrimeI = primeIndividuelleRepository.findAllByIdContrat(c.getIdContrat());
			for (PrimeIndividuelle pi : LPrimeI) {
				if (pi.getRubrique().getTaux() == 0) {
					GrilleSalariale g = new GrilleSalariale(pi, pi.getMontant(), b, c);
				}
				if (pi.getRubrique().getTaux() != 0) {
					GrilleSalariale g = new GrilleSalariale(pi, (c.getEchelon().getSalaire() * pi.getRubrique().getTaux()) / 100, b, c, pi.getRubrique().getTaux());
					//(pour le stocker au cas ou ca changait)
				} else {
				}
			}
			List<Retenue> LRetenue = retenueRepository.findAll();
			for (Retenue r : LRetenue) {
				GrilleSalariale g = new GrilleSalariale(r, r.getTauxPatron(), r.getTauxEmploy(), r.getTauxFixe(), b, c);
			}
			resultat = true;
		}

			b.setEtat(true);
			bulletinSalaireRepository.save(b);
		}


		return resultat;

		}
	}*/

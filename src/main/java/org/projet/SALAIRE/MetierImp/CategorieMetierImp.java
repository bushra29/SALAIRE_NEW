package org.projet.SALAIRE.MetierImp;

import java.util.List;

import org.projet.SALAIRE.dao.CategorieRepository;
import org.projet.SALAIRE.dao.EchelonRepository;
import org.projet.SALAIRE.dao.ParametreRepository;
import org.projet.SALAIRE.entity.Categorie;
import org.projet.SALAIRE.entity.Echelon;
import org.projet.SALAIRE.entity.Parametre;
import org.projet.SALAIRE.metier.CategorieMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategorieMetierImp implements CategorieMetier {
	
	@Autowired
	EchelonRepository echelonRepository;
	@Autowired
	CategorieRepository categorieRepository;
	@Autowired
	ParametreRepository parametreRepository;

	@Override
	public Categorie addCategorie(Categorie c)
	{
		return categorieRepository.save(c);
		
	}
	//
	public void genererEchelon() {
	
		List<Categorie>Categories=categorieRepository.findAllOrder();
		Parametre p = parametreRepository.findbyEchellon();
		
		
		for(Categorie c:Categories)
			
		{
			System.out.println("Valeur initiale==== "+c.getLibelleCateg());
			for(int i=1; i<=c.getNbreEchellon();i++)
			{
				echelonRepository.save(new Echelon(c.getLibelleCateg()+"-"+i,p.getValeur()+1,c));
				p.setValeur(p.getValeur()+1);
				parametreRepository.save(p);
		    }
			System.out.println("Valeur finale ==== "+c.getLibelleCateg());
		}
		}
			
	

	@Override
	public Categorie findCategorie(Long id) {
		// TODO Auto-generated method stub
		return categorieRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteCategorie(Long id) {
		// TODO Auto-generated method stub
		categorieRepository.deleteById(id);
		
		
	}

	@Override
	public List<Categorie> listCategorie() {
		// TODO Auto-generated method stub
		return categorieRepository.findAll();
	}



}

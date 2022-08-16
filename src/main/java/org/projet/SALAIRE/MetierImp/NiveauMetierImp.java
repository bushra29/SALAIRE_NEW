package org.projet.SALAIRE.MetierImp;

import java.util.List;

import org.projet.SALAIRE.dao.CategorieRepository;
import org.projet.SALAIRE.dao.NiveauRepository;
import org.projet.SALAIRE.dao.ParametreRepository;
import org.projet.SALAIRE.entity.Categorie;
import org.projet.SALAIRE.entity.Niveau;
import org.projet.SALAIRE.entity.Parametre;
import org.projet.SALAIRE.metier.NiveauMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NiveauMetierImp implements NiveauMetier {
	@Autowired
	NiveauRepository niveauRepository;
	@Autowired
	CategorieRepository categorieRepository;

	@Autowired
	ParametreRepository parametreRepository;

	@Override
	public Niveau addNiveau(Niveau n) {
		Parametre p = parametreRepository.findbyCategorie();
		//genererCategorie(n.getNbreCateg());
		//n.setRang(p.getValeur()+1);

		return niveauRepository.save(n);
	}
	@Override
	public void genererCategorie() {
		/*------------------------------------------------------------------------------------------------------*/
		/*------------------------------------------------------------------------------------------------------*/
		List<Niveau>Niveaux=niveauRepository.findAllOrderByRang();
		Parametre p = parametreRepository.findbyCategorie();

		for(Niveau n:Niveaux)
		{
			for(int i=1; i<=n.getNbreCateg();i++)
			{
				System.out.println(n.getLibelleNiveau() + n.getNbreCateg());
			categorieRepository.save(new Categorie(n.getLibelleNiveau()+""+i,0,p.getValeur()+1,n));
			p.setValeur(p.getValeur()+1);
			parametreRepository.save(p);

			//c.setLibelleCateg(n.getLibelleNiveau()+i);
		    }
		}


	}
	/*public void genererCategorietwo(String LibelleNiveau,int NbreCategorie) {
		//evite les chiffre dans les nom de fonction
		/*------------------------------------------------------------------------------------------------------*/
		/*------------------------------------------------------------------------------------------------------*/
		/*List<Niveau>Niveaux=niveauRepository.findAllOrderByRang();
		Parametre p = parametreRepository.findbyCategorie();

		for(Niveau n:Niveaux)
		{
			for(int i=1; i<=n.getNbreCateg();i++)
			{
				categorieRepository.save(new Categorie(n.getLibelleNiveau()+i,NbreCategorie,
						p.getValeur()+1,n));
				p.setValeur(p.getValeur()+1);
				parametreRepository.save(p);

				//c.setLibelleCateg(n.getLibelleNiveau()+i);
			}
		}


	}*/
	@Override
	public Niveau findNiveau(Long id) {
		// TODO Auto-generated method stub
		return niveauRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteNiveau(Long id) {
		// TODO Auto-generated method stub
		niveauRepository.deleteById(id);
		
		
	}

	@Override
	public List<Niveau> listNiveau() {
		// TODO Auto-generated method stub
		return niveauRepository.findAll();
	}
	
	
	
	/*public void GenererRang(int Rang,Long id)
	{
		List<Niveau>Niveaux=niveauRepository.findAll();
		 for(Niveau n:Niveaux)
		 {
		 p.setValeur ++;
		 niveauRepository.save(p);
		/*Niveau N1 = niveauRepository.save(n);
		for(Niveau n : N1)
		{
			int rang , value = 0;
			Rang = parametreRepository.s
			niveauRepository.save(new Niveau)
			int rang , value = 0;
			Rang = value +1;	
		}*/
		
	
	
	/*public void GenererCategorie()
	{
		Niveau N1 = niveauRepository.save(n);
		List<Niveau> L1 = new ArrayList<Niveau>();
		L1.add(N1);
		
		for (Niveau niveau : L1) {
			int nbreCategorie;
			String niv;
			for (i =0,i<nbreCategorie,i++)
			{
				niv="LibelleNiveau"+i;
				
			}*/
			
		
	
}

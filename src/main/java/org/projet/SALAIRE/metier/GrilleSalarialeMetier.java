package org.projet.SALAIRE.metier;

import java.util.List;

import org.projet.SALAIRE.entity.GrilleSalariale;

public interface GrilleSalarialeMetier {
		public GrilleSalariale addGrille(GrilleSalariale g);
		public GrilleSalariale findGrille(Long id);
		public void deleteGrille(Long id);
		public List<GrilleSalariale> listGrille();
		public boolean TraiterSalaire(Long id);
		//public void genererSalaire(Long id);

}

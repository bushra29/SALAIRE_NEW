package org.projet.SALAIRE.metier;

import java.util.List;

import org.projet.SALAIRE.entity.Fonction;

public interface FonctionMetier {
		public Fonction addFonction(Fonction f);
		public Fonction findFonction(Long id);
		public void deleteFonction(Long id);
		public List<Fonction> listFonction();


}

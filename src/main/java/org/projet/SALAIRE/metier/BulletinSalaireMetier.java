package org.projet.SALAIRE.metier;

import java.io.FileNotFoundException;
import java.util.List;

import net.sf.jasperreports.engine.JRException;
import org.projet.SALAIRE.entity.BulletinSalaire;


public interface BulletinSalaireMetier {
	
	public BulletinSalaire addBulletin();
	public BulletinSalaire findBulletin(Long id);
	//public List<BulletinSalaire> findBullByAnneeMois(Long IdAnnee,Long IdMois);
	public void deleteBulletin(Long id);
	public List<BulletinSalaire> listBulletin();
	public String exportReport(String reportFormat) throws FileNotFoundException, JRException;

}

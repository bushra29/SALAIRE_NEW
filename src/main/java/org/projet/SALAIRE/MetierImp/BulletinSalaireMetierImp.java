package org.projet.SALAIRE.MetierImp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.projet.SALAIRE.dao.BulletinSalaireRepository;
import org.projet.SALAIRE.dao.GrilleSalarialeRepository;
import org.projet.SALAIRE.dao.MoisRepository;
import org.projet.SALAIRE.entity.Annee;
import org.projet.SALAIRE.entity.BulletinSalaire;
import org.projet.SALAIRE.entity.GrilleSalariale;
import org.projet.SALAIRE.metier.BulletinSalaireMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

@Service
public class BulletinSalaireMetierImp implements BulletinSalaireMetier {

	@Override
	public BulletinSalaire addBulletin() {
		BulletinSalaire b = new BulletinSalaire();
		b.setAnnee(bulletinSalaireRepository.getAnneeActive());
		b.setMois(moisRepository.getMoisTrue());
		return bulletinSalaireRepository.save(b);
	}
	@Autowired
	BulletinSalaireRepository bulletinSalaireRepository;

	@Autowired
	MoisRepository moisRepository;
	@Autowired
	GrilleSalarialeRepository grilleSalarialeRepository;




	/*@Override
	public List<BulletinSalaire> findBullByAnneeMois(Long IdAnnee, Long IdMois) {
		// TODO Auto-generated method stub
		return bulletinSalaireRepository.findBullByAnneeMois(IdAnnee, IdMois);
	}*/




	public BulletinSalaire findBulletin(Long id) {
		// TODO Auto-generated method stub
		return bulletinSalaireRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteBulletin(Long id) {
		// TODO Auto-generated method stub
		bulletinSalaireRepository.deleteById(id);
		
		
	}

	@Override
	public List<BulletinSalaire> listBulletin() {
		// TODO Auto-generated method stub
		return bulletinSalaireRepository.findAll();
	}

	/*@Override
	public List<BulletinSalaire> listBulletin() {
		// TODO Auto-generated method stub
		return bulletinSalaireRepository.findAll();
	}*/
public String exportReport(String reportFormat) throws FileNotFoundException, JRException {

	String path="E:\\Report";
	List<GrilleSalariale> LGrille=grilleSalarialeRepository.findAll();
	File file = ResourceUtils.getFile("classpath:");
	JasperReport jasperReport= JasperCompileManager.compileReport(file.getAbsolutePath());
	JRBeanCollectionDataSource dataSource=new JRBeanCollectionDataSource(LGrille);
	 Map<String,Object> parameters = new HashMap<>();
	 parameters.put("createdBy","abcd");
	JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parameters,dataSource);

	//create for html
	if(reportFormat.equalsIgnoreCase("html")){
		JasperExportManager.exportReportToHtmlFile(jasperPrint,path+"\\Bulletin.html");
	}

	//create for pdf
	if(reportFormat.equalsIgnoreCase("pdf")){
		JasperExportManager.exportReportToPdfFile(jasperPrint,path+"\\Bulletin.pdf");
	}
return "Etat généré sur le chemin"+path;
}

	


}

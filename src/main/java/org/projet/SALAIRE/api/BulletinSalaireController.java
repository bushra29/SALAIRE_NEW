package org.projet.SALAIRE.api;

import java.io.FileNotFoundException;
import java.util.List;

import net.sf.jasperreports.engine.JRException;
import org.projet.SALAIRE.entity.BulletinSalaire;
import org.projet.SALAIRE.metier.BulletinSalaireMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping(path="/api/BulletinSalaire")
public class BulletinSalaireController {
@Autowired private BulletinSalaireMetier bulletinSalaireMetier;
	

	@GetMapping(path="/Save")
	public BulletinSalaire AjouterBulletin()
	{
		return bulletinSalaireMetier.addBulletin();
	}
	
	@GetMapping(path="/Find/{id}")
	public BulletinSalaire findOneBulletin (@PathVariable("id") Long id)
	{
		
		return bulletinSalaireMetier.findBulletin(id);
	}
	
	@GetMapping(path="/List")
	public List<BulletinSalaire> ListBulletin ()

	{
		return bulletinSalaireMetier.listBulletin();
	}

	@GetMapping(path="/Imprimer/{format}")
	public String generateReport(@PathVariable String format) throws JRException, FileNotFoundException {
		return bulletinSalaireMetier.exportReport(format);
	}

}

package org.projet.SALAIRE.api;

import java.util.List;

import org.projet.SALAIRE.entity.Sens;
import org.projet.SALAIRE.metier.SensMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "/api/Sens")
public class SensController {
@Autowired private SensMetier sensMetier;
	

	@PostMapping(path="/Save")
	public Sens AjouterSens(@RequestBody Sens s)
	{
		return sensMetier.addSens(s);
	}
	
	@GetMapping(path="/Find/{id}")
	public Sens findOneFonction (@PathVariable("id") Long id)
	{
		
		return sensMetier.findSens(id);
	}
	
	@GetMapping(path="/List")
	public List<Sens> ListSens()
	{
		return sensMetier.listSens();
	}
	@DeleteMapping(path="/Delete/{id}")
	public void DeleteOneSens (@PathVariable("id") Long IdSens)
	{
		
		sensMetier.deleteSens(IdSens);
	}
	

}

package org.projet.SALAIRE.api;

import java.util.List;

import org.projet.SALAIRE.entity.SituationMatrimoniale;
import org.projet.SALAIRE.metier.SituationMatrimonialeMetier;
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
@RequestMapping(path = "/api/SituationMatrimoniale")
public class SituationMatrimonialeController {
@Autowired private SituationMatrimonialeMetier situationMatrimonialeMetier;
	

	@PostMapping(path="/Save")
	public SituationMatrimoniale AjouterSituation(@RequestBody SituationMatrimoniale s)
	{
		return situationMatrimonialeMetier.addSituation(s);
	}
	
	@GetMapping(path="/Find/{id}")
	public SituationMatrimoniale findOnesituation (@PathVariable("id") Long id)
	{
		
		return situationMatrimonialeMetier.findSituation(id);
	}
	
	@GetMapping(path="/List")
	public List<SituationMatrimoniale> Listsituation ()
	{
		return situationMatrimonialeMetier.listSituation();
	}
	@DeleteMapping(path="/Delete/{id}")
	public void DeleteOneSit (@PathVariable("id") Long IdSitMat)
	{
		
		situationMatrimonialeMetier.deleteSituation(IdSitMat);
	}
}

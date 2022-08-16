package org.projet.SALAIRE.api;

import java.util.List;

import org.projet.SALAIRE.entity.Echelon;
import org.projet.SALAIRE.metier.EchelonMetier;
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
@RequestMapping(path = "/api/Echelon")
public class EchelonController {
@Autowired private EchelonMetier echelonMetier;
	

	@PostMapping(path="/Save")
	public Echelon AjouterEchelon(@RequestBody Echelon e)
	{
		return echelonMetier.addEchelon(e);
	}
	
	@GetMapping(path="/Find/{id}")
	public Echelon findOneEchelon (@PathVariable("id") Long id)
	{
		
		return echelonMetier.findEchelon(id);
	}
	
	@GetMapping(path="/List")
	public List<Echelon> ListEchelon ()
	{
		return echelonMetier.listEchelon();
	}
	@DeleteMapping(path="/Delete/{id}")
	public void DeleteOneEchelon (@PathVariable("id") Long IdEchel)
	{
		
		echelonMetier.deleteEchelon(IdEchel);
	}
}

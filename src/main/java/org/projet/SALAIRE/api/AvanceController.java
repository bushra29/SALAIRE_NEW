package org.projet.SALAIRE.api;

import java.util.List;

import org.projet.SALAIRE.entity.Avance;
import org.projet.SALAIRE.metier.AvanceMetier;
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
@RequestMapping(path="/api/Avance")
public class AvanceController {

	@Autowired private AvanceMetier avanceMetier;
		

		@PostMapping(path="/Save")
		public Avance AjouterAvance(@RequestBody Avance a)
		{
			return avanceMetier.addAvance(a);
		}
		
		@GetMapping(path="/Find/{id}")
		public Avance findOneAvance (@PathVariable("id") Long id)
		{
			
			return avanceMetier.findAvance(id);
		}
		
		@GetMapping(path="/List")
		public List<Avance> ListAvance ()
		{
			return avanceMetier.listAvance();
		}
		@DeleteMapping(path="/Delete/{id}")
		public void DeleteOneAvance (@PathVariable("id") Long IdAvance)
		{
			
			avanceMetier.deleteAvance(IdAvance);
		}

}

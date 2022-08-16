package org.projet.SALAIRE.api;

import org.projet.SALAIRE.entity.GrilleFiscale;
import org.projet.SALAIRE.metier.GrilleFiscaleMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "/api/GrilleFiscale")
public class GrilleFiscaleController {
    @Autowired
    GrilleFiscaleMetier grilleFiscaleMetier;

    @PostMapping(path="/Save")
    public GrilleFiscale AjouterGrilleF(@RequestBody @Validated GrilleFiscale gf)
    {
        return grilleFiscaleMetier.addGrilleFiscale(gf);
    }

    @GetMapping(path="/Find/{id}")
    public GrilleFiscale findOneGrilleF (@PathVariable("id") Long IdGrilleFiscale)
    {

        return grilleFiscaleMetier.findGrilleFiscale(IdGrilleFiscale);
    }

    @DeleteMapping(path="/Delete/{id}")
    public void DeleteOneGrilleF (@PathVariable("id") Long IdGrilleFiscale)
    {

        grilleFiscaleMetier.deleteGrilleFiscale(IdGrilleFiscale);
    }

    @GetMapping(path="/List")
    public List<GrilleFiscale> ListGrilleF ()
    {
        return grilleFiscaleMetier.listGrilleFiscale();
    }


}



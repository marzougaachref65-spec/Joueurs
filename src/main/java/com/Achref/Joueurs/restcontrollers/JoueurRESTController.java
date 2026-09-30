package com.Achref.Joueurs.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Achref.Joueurs.entities.Joueur;
import com.Achref.Joueurs.service.JoueurService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class JoueurRESTController {

	@Autowired
	JoueurService joueurService;

	@GetMapping()
	public List<Joueur> getAllJoueurs() {
		return joueurService.getAllJoueurs();
	}

	@GetMapping("/{id}")
	public Joueur getJoueurById(@PathVariable("id") Long id) {
		return joueurService.getJoueur(id);
	}

	@PostMapping()
	public Joueur createJoueur(@RequestBody Joueur joueur) {
		return joueurService.saveJoueur(joueur);
	}

	@PutMapping()
	public Joueur updateJoueur(@RequestBody Joueur joueur) {
		return joueurService.updateJoueur(joueur);
	}

	@DeleteMapping("/{id}")
	public void deleteJoueur(@PathVariable("id") Long id) {
		joueurService.deleteJoueurById(id);
	}

	@GetMapping("/joueurseq/{idEquipe}")
	public List<Joueur> getJoueursByEquipeId(@PathVariable("idEquipe") Long idEquipe) {
		return joueurService.findByEquipeIdEquipe(idEquipe);
	}

}
package com.Achref.Joueurs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.Achref.Joueurs.entities.Equipe;
import com.Achref.Joueurs.entities.Joueur;
import com.Achref.Joueurs.repos.EquipeRepository;
import com.Achref.Joueurs.repos.JoueurRepository;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class JoueursApplicationTests {

	@Autowired
	private JoueurRepository joueurRepository;

	@Autowired
	private EquipeRepository equipeRepository;

	private static Long idJoueur;
	private static Long idEquipe;

	@Test
	@Order(1)
	public void testCreateJoueur() {
		Equipe equipe = new Equipe();
		equipe.setNomEquipe("Real Madrid");
		equipe.setDescriptionEquipe("Club de football espagnol");
		equipeRepository.save(equipe);
		idEquipe = equipe.getIdEquipe();

		Joueur j1 = new Joueur("Cristiano Ronaldo", 2200.500, new Date());
		j1.setEquipe(equipe);
		joueurRepository.save(j1);
		idJoueur = j1.getIdJoueur();

		Joueur j2 = new Joueur("Karim Benzema", 1800.500, new Date());
		j2.setEquipe(equipe);
		joueurRepository.save(j2);

		System.out.println(j1);
		System.out.println(j2);

		assertNotNull(idJoueur);
		assertNotNull(idEquipe);
	}

	@Test
	@Order(2)
	public void testFindJoueur() {
		Joueur j = joueurRepository.findById(idJoueur).get();
		System.out.println(j);
		assertEquals("Cristiano Ronaldo", j.getNomJoueur());
	}

	@Test
	@Order(3)
	public void testUpdateJoueur() {
		Joueur j = joueurRepository.findById(idJoueur).get();
		j.setPrixJoueur(1000.0);
		Joueur updated = joueurRepository.save(j);
		System.out.println(updated);
		assertEquals(1000.0, updated.getPrixJoueur());
	}

	@Test
	@Order(4)
	public void testListerTousJoueurs() {
		List<Joueur> joueurs = joueurRepository.findAll();
		for (Joueur j : joueurs) {
			System.out.println(j);
		}
		assertFalse(joueurs.isEmpty());
	}

	@Test
	@Order(5)
	public void testFindByNomJoueur() {
		List<Joueur> joueurs = joueurRepository.findByNomJoueur("Cristiano Ronaldo");
		for (Joueur j : joueurs) {
			System.out.println(j);
		}
		assertFalse(joueurs.isEmpty());
	}

	@Test
	@Order(6)
	public void testFindByNomJoueurContains() {
		List<Joueur> joueurs = joueurRepository.findByNomJoueurContains("Karim");
		for (Joueur j : joueurs) {
			System.out.println(j);
		}
		assertFalse(joueurs.isEmpty());
	}

	@Test
	@Order(7)
	public void testFindByNomJoueurPrix() {
		// La requête JPQL du TP utilise « like %:nom » : le critère correspond donc à une fin de nom
		List<Joueur> joueurs = joueurRepository.findByNomJoueurPrix("Ronaldo", 500.0);
		for (Joueur j : joueurs) {
			System.out.println(j);
		}
		assertFalse(joueurs.isEmpty());
	}

	@Test
	@Order(8)
	public void testFindByEquipe() {
		Equipe equipe = new Equipe();
		equipe.setIdEquipe(idEquipe);
		List<Joueur> joueurs = joueurRepository.findByEquipe(equipe);
		for (Joueur j : joueurs) {
			System.out.println(j);
		}
		assertFalse(joueurs.isEmpty());
	}

	@Test
	@Order(9)
	public void testFindByEquipeIdEquipe() {
		List<Joueur> joueurs = joueurRepository.findByEquipeIdEquipe(idEquipe);
		for (Joueur j : joueurs) {
			System.out.println(j);
		}
		assertFalse(joueurs.isEmpty());
	}

	@Test
	@Order(10)
	public void testFindByOrderByNomJoueurAsc() {
		List<Joueur> joueurs = joueurRepository.findByOrderByNomJoueurAsc();
		for (Joueur j : joueurs) {
			System.out.println(j);
		}
		assertFalse(joueurs.isEmpty());
	}

	@Test
	@Order(11)
	public void testTrierJoueursNomsPrix() {
		List<Joueur> joueurs = joueurRepository.trierJoueursNomsPrix();
		for (Joueur j : joueurs) {
			System.out.println(j);
		}
		assertFalse(joueurs.isEmpty());
	}

	@Test
	@Order(12)
	public void testDeleteJoueur() {
		joueurRepository.deleteById(idJoueur);
		assertTrue(joueurRepository.findById(idJoueur).isEmpty());
	}

}

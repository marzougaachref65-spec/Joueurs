package com.Achref.Joueurs.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.Achref.Joueurs.entities.Equipe;
import com.Achref.Joueurs.entities.Joueur;

@RepositoryRestResource(path = "rest")
public interface JoueurRepository extends JpaRepository<Joueur, Long> {

	List<Joueur> findByNomJoueur(String nom);

	List<Joueur> findByNomJoueurContains(String nom);

	@Query("select j from Joueur j where j.nomJoueur like %:nom and j.prixJoueur > :prix")
	List<Joueur> findByNomJoueurPrix(@Param("nom") String nom, @Param("prix") Double prix);

	@Query("select j from Joueur j where j.equipe = ?1")
	List<Joueur> findByEquipe(Equipe equipe);

	List<Joueur> findByEquipeIdEquipe(Long id);

	List<Joueur> findByOrderByNomJoueurAsc();

	@Query("select j from Joueur j order by j.nomJoueur ASC, j.prixJoueur DESC")
	List<Joueur> trierJoueursNomsPrix();

}

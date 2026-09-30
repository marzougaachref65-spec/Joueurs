package com.Achref.Joueurs.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.Achref.Joueurs.entities.Equipe;

@RepositoryRestResource(exported = false)
public interface EquipeRepository extends JpaRepository<Equipe, Long> {

}
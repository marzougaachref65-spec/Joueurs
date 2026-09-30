package com.Achref.Joueurs.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Joueur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idJoueur;

	private String nomJoueur;

	private Double prixJoueur;

	private Date dateNaissance;

	@ManyToOne
	private Equipe equipe;

	public Joueur(String nomJoueur, Double prixJoueur, Date dateNaissance) {
		super();
		this.nomJoueur = nomJoueur;
		this.prixJoueur = prixJoueur;
		this.dateNaissance = dateNaissance;
	}

}

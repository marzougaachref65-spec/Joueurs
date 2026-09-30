package com.Achref.Joueurs.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "joueurs")
@EqualsAndHashCode(exclude = "joueurs")
@Entity
public class Equipe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEquipe;

	private String nomEquipe;

	private String descriptionEquipe;

	@JsonIgnore
	@OneToMany(mappedBy = "equipe")
	private List<Joueur> joueurs;

}
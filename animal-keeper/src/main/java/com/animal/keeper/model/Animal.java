package com.animal.keeper.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "animal")
public class Animal {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "name")
	@NotBlank(message = "🤔 Name is required!")
	private String name;

	@Column(name = "species")
	@NotBlank(message = "🤔  Species is required!")
	private String species;

	@Column(name = "country_origin")
	@NotBlank(message = "🤔  Country of origin is required!")
	private String countryOrigin;

	@Column(name = "date_of_birth")
	@NotBlank(message = "🤔 Date of birth is required!")
	private String dateOfBirth;

	@Column(name = "weight")
	@NotNull(message = "🤔  Weight is required!")
	private Double weight;

	@Column(name = "height")
	@NotNull(message = "🤔  Height is required!")
	private Double height;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getCountryOrigin() {
		return countryOrigin;
	}

	public void setCountryOrigin(String countryOrigin) {
		this.countryOrigin = countryOrigin;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

}


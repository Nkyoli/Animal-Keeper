package com.animal.keeper.service;

import java.util.List;
import java.util.Optional;

import com.animal.keeper.model.Animal;

public interface AnimalService {
	void delete(Animal animal);
	Animal save(Animal animal);
	List<Animal> saveAll(List<Animal> animals);
	List<Animal> findAll();
	List<Animal> findByName(String name);
	Optional<Animal> findById(Integer id);
	List<Animal> findByCountryOrigin(String name);
	List<Animal> findByDateOfBirth(String dateOfBirth);
}

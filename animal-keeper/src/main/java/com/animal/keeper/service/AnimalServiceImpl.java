package com.animal.keeper.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.animal.keeper.dao.AnimalRepository;
import com.animal.keeper.model.Animal;

@Service
public class AnimalServiceImpl implements AnimalService {

	private AnimalRepository animalRepository;
	
	@Autowired
	public AnimalServiceImpl(AnimalRepository animalRepository) {
		this.animalRepository = animalRepository;
	}
	@Override
	public void delete(Animal animal) {
		animalRepository.delete(animal);

	}

	@Override
	public Animal save(Animal animal) {
		return animalRepository.save(animal);
	}

	@Override
	public List<Animal> findAll() {
		return animalRepository.findAll();
	}

	@Override
	public List<Animal> findByName(String name) {
		return animalRepository.findByName(name);
	}

	@Override
	public Optional<Animal> findById(Integer id) {
		return animalRepository.findById(id);
	}

	@Override
	public List<Animal> findByCountryOrigin(String name) {
		return animalRepository.findByCountryOrigin(name);
	}

	@Override
	public List<Animal> findByDateOfBirth(String dateOfBirth) {
		return animalRepository.findByDateOfBirth(dateOfBirth);
	}
	@Override
	public List<Animal> saveAll(List<Animal> animals) {
		return animalRepository.saveAll(animals);
	}

}

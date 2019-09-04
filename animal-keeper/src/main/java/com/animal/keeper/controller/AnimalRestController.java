package com.animal.keeper.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.animal.keeper.model.Animal;
import com.animal.keeper.service.AnimalService;
import com.animal.keeper.util.MappingNames;

@RestController
@RequestMapping(MappingNames.API)
public class AnimalRestController {

	private AnimalService animalService;
	
	@Autowired
	public AnimalRestController(AnimalService animalService) {
		this.animalService = animalService;
	}
	
	@PostMapping(MappingNames.SAVE_ALL)
	public String saveAnimals(@RequestBody List<Animal> animals) {
		animalService.saveAll(animals);
		return animals.size() + " animals were successfully saved!!";
	}
	
	@PostMapping(MappingNames.SAVE)
	public String saveAnimal(@Valid @RequestBody Animal animal) {
		animalService.save(animal);
		return "👍 👍" + animal.getName() + " was succefully saved!!";
	}
	
	@GetMapping(MappingNames.GET_BY_ID)
	public Optional<Animal> findById(@PathVariable(value = "id") Integer id) {
		return animalService.findById(id);
	}
	
	@GetMapping(MappingNames.GET_BY_NAME)
	public List<Animal> findByName(@PathVariable(value = "name") String name) {
		return animalService.findByName(name);
	}
	
	@GetMapping(MappingNames.GET_ALL)
	public List<Animal> getAllAnimals() {
		return animalService.findAll();
	}
	
	@PutMapping(MappingNames.UPDATE) 
	public String updateAnimal(@PathVariable(value = "id") Integer id,
			@Valid @RequestBody Animal animalVal) {
		
		Optional<Animal> optionalAnimal = animalService.findById(id);
		
		if(optionalAnimal.isEmpty()) {
			return "This animal does not exist!!";
		} 
		animalVal.setId(id);
		animalService.save(animalVal);
			
		return "The animal with id " + animalVal.getId() + " was succefully updated!!";
	}
	
	@DeleteMapping(MappingNames.DELETE)
	public String deleteAnimal(@PathVariable(value = "id") Integer id,
								@Valid @RequestBody Animal AnimalVal) {
		Optional<Animal> optionalAnimal = animalService.findById(id);
		
		if(optionalAnimal.isEmpty()) {
			return "The animal does not exist!!!";
		} else {
			Animal animal = optionalAnimal.get();
			animalService.delete(animal);
			
			return "The animal with id " + animal.getId() + " was succefully deleted!!";
		}
	}
	
	
}

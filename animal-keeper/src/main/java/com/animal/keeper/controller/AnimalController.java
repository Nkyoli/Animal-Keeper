package com.animal.keeper.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.animal.keeper.model.Animal;
import com.animal.keeper.service.AnimalService;
import com.animal.keeper.util.MappingNames;
import com.animal.keeper.util.ViewNames;

@Controller
public class AnimalController {
	
	private AnimalService animalService;
	
	@Autowired
	public AnimalController(AnimalService animalService) {
		this.animalService = animalService;
	}
	

	@GetMapping(MappingNames.INDEX)
	public String home() {
		return ViewNames.INDEX;
	}
	
	@GetMapping(MappingNames.SAVE) 
	public String showForm(Model model) {
		model.addAttribute("animal", new Animal());
		return ViewNames.ADD_ANIMAL;
	}
	
	@GetMapping(MappingNames.GET_ALL)
	public String allAnimals(Model model) {
		model.addAttribute("message", "😌  No animal saved yet!");
		model.addAttribute("animals", animalService.findAll());
		return ViewNames.ALL_ANIMALS;
	}
	
	@PostMapping(MappingNames.SAVE)
	public String addAnimal(@Valid Animal animal, BindingResult result) {
		if(result.hasErrors()) {
			return ViewNames.ADD_ANIMAL;
		}
		animalService.save(animal);
		
		return ViewNames.INDEX;
	}
	
	@PostMapping(MappingNames.UPDATE)
	public String updateAnimal(@PathVariable("id") Integer id, @Valid Animal animalToUpdate, BindingResult result) {
		if(result.hasErrors()) {
			return ViewNames.UPDATE_ANIMAL;
		}	
		animalToUpdate.setId(id);
		animalService.save(animalToUpdate);
			
		return ViewNames.ANIMAL_DETAILS;
	}
	
	@GetMapping(MappingNames.GET_BY_ID)
	public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
		
		Optional<Animal> optionalAnimal = animalService.findById(id);
		
		if(optionalAnimal.isEmpty()) {
			model.addAttribute("animals", animalService.findAll());
			return ViewNames.ALL_ANIMALS;
		}
		
		Animal animal = optionalAnimal.get();
		model.addAttribute("animal", animal);
		
		return ViewNames.UPDATE_ANIMAL;
	}
	
	@GetMapping(MappingNames.DELETE)
	public String deleteAnimal(Model model, @PathVariable(value = "id") Integer id) {
		Optional<Animal> optionalAnimal = animalService.findById(id);
		
		if(optionalAnimal.isEmpty()) {
			model.addAttribute("animals", animalService.findAll());
			return ViewNames.ALL_ANIMALS;
		}
		Animal animal = optionalAnimal.get(); 
		animalService.delete(animal);
		
		return ViewNames.INDEX;
	}
	
	@GetMapping(MappingNames.SEARCH)
	public String searchAnimals(Model model, @RequestParam(name = "search") String search) {
		
		Integer id = 0;
		try {
			id = Integer.parseInt(search);
			Optional<Animal> optionalAnimal = animalService.findById(id);
			
			if(optionalAnimal.isEmpty()) {
				model.addAttribute("message", "😌 No animal with id " + id + " number was found!");
				model.addAttribute("animals", null);
				return ViewNames.SEARCH_RESULT;
			}
			model.addAttribute("animals", optionalAnimal.get());
			return ViewNames.SEARCH_RESULT;
		} catch(NumberFormatException e) {
			List<Animal> animals = animalService.findByName(search);
			if(animals.size() == 0) {
				animals = animalService.findByCountryOrigin(search);
				if(animals.size() == 0) {
					animals = animalService.findByDateOfBirth(search);
					if(animals.size() == 0) {
						model.addAttribute("message", "😌 No animal with name nor country of origin nor date of birth of " + search + " was found!");
						model.addAttribute("animals", null);
						return ViewNames.SEARCH_RESULT;
					}
					model.addAttribute("animals", animals);
					return ViewNames.SEARCH_RESULT;
				}
				model.addAttribute("animals", animals);
				return ViewNames.SEARCH_RESULT;
			}
			model.addAttribute("animals", animals);
			return ViewNames.SEARCH_RESULT;
		}
	}
	
	@GetMapping(MappingNames.ANIMAL_DETAILS)
	public String animalDetails(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("animal", animalService.findById(id).get());
		return ViewNames.ANIMAL_DETAILS;
	}
	
	@GetMapping(MappingNames.NEXT)
	public String nextAnimal(@PathVariable("id") Integer id, Model model) {
		List<Animal> animals = animalService.findAll();
		Animal animal = new Animal();
		
		for(int i = 0; i < animals.size(); i++) {
			if(i == animals.size() - 1) {
				animal = animals.get(0);
				break;
			} else if(animals.get(i).getId() == id) {
				animal = animals.get(++i);
				break;
			}
		}
		
		model.addAttribute("animal", animal);
		return ViewNames.ANIMAL_DETAILS;
	}
	
	@GetMapping(MappingNames.PREVIOUS)
	public String previousAnimal(@PathVariable("id") Integer id, Model model) {
		List<Animal> animals = animalService.findAll();
		Animal animal = new Animal();
		
		for(int i = animals.size() - 1; i >= 0; i--) {
			if(i == 0) {
				animal = animals.get(animals.size() - 1);
				break;
			} else if(animals.get(i).getId() == id) {
				animal = animals.get(--i);
				break;
			}
		}
		model.addAttribute("animal", animal);
		return ViewNames.ANIMAL_DETAILS;
	}
}

package com.animal.keeper.util;

public class MappingNames {

	public static final String API = "/api";
	
	public static final String INDEX = "/index";
	
	public static final String SAVE_ALL = "/saveAnimals";
	
	public static final String SAVE = "/saveAnimal";
	
	public static final String GET_BY_ID = "/getAnimalById/{id}"; 
	
	public static final String GET_BY_ID_VALUE = "/getAnimalById/{id}(id=${animal.id})";
	
	public static final String GET_BY_NAME = "/getAnimalByName/{name}";
	
	public static final String GET_ALL = "/getAllAnimals";
	
	public static final String SEARCH = "/search";
	
	public static final String UPDATE = "/updateAnimal/{id}";
	
	public static final String UPDATE_VALUE = "/updateAnimal/{id}(id=${animal.id})";
	
	public static final String DELETE = "/deleteAnimal/{id}";
	
	public static final String ANIMAL_DETAILS = "/animalDetails/{id}";
	
	public static final String ANIMAL_DETAILS_VALUE = "/animalDetails/{id}(id=${animal.id})";
	
	public static final String DELETE_ID_VALUE = "/deleteAnimal/{id}(id=${animal.id})";
	
	public static final String NEXT = "/nextAnimal/{id}";
	
	public static final String NEXT_VALUE = "/nextAnimal/{id}(id=${animal.id})";
	
	public static final String PREVIOUS = "/previousAnimal/{id}";
	
	public static final String PREVIOUS_VALUE = "/previousAnimal/{id}(id=${animal.id})";

	private MappingNames() {}
}

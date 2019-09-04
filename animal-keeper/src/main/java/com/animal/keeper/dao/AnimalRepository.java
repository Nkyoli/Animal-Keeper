package com.animal.keeper.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.animal.keeper.model.Animal;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {
	List<Animal> findByName(String name);
	Optional<Animal> findById(Integer id);
	List<Animal> findByCountryOrigin(String name);
	List<Animal> findByDateOfBirth(String dateOfBirth);
}
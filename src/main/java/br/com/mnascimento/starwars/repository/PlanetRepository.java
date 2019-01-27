package br.com.mnascimento.starwars.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import br.com.mnascimento.starwars.model.Planet;

public interface PlanetRepository extends MongoRepository<Planet, String> {

	List<Planet> findByNameIgnoreCaseContaining(@Param("name") String name);
}

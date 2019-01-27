package br.com.mnascimento.starwars.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Optional;

import javax.validation.ConstraintViolationException;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.mnascimento.starwars.MongoTestConfig;
import br.com.mnascimento.starwars.model.Planet;

@RunWith(SpringRunner.class)
@SpringBootTest
@Import(MongoTestConfig.class)
public class PlanetRepositoryTests {
	
	@Autowired
	private PlanetRepository planetRepository;
	
	@After
    public void clean() throws Exception {
		planetRepository.deleteAll();
	}
	
	@Test
	public void shouldAddPlanet() {
		Planet planet = new Planet();
		planet.setName("Yavin IV");
		planetRepository.insert(planet);
		assertEquals(1, planetRepository.count());
	}
	
	@Test
	public void shouldNotAddPlanet() {
		try {
			Planet planet = new Planet();
			planetRepository.insert(planet);
			assertTrue(false);
		} catch (ConstraintViolationException e) {
			assertEquals("name: Nome é obrigatório", e.getMessage());
		}
	}
	
	@Test
	public void shouldListPlanets() {
		Planet planet = new Planet();
		planet.setName("Yavin III");
		planetRepository.insert(planet);
		planet = new Planet();
		planet.setName("Yavin IV");
		planetRepository.insert(planet);
		List<Planet> planets = planetRepository.findAll();
		assertEquals(2, planets.size());
	}
	
	@Test
	public void shouldFindPlanetsByName() {
		Planet planet = new Planet();
		planet.setName("Yavin II");
		planetRepository.insert(planet);
		planet = new Planet();
		planet.setName("Yavin III");
		planetRepository.insert(planet);
		planet = new Planet();
		planet.setName("Yavin IV");
		planetRepository.insert(planet);
		List<Planet> planets = planetRepository.findByNameIgnoreCaseContaining("yavin ii");
		assertEquals(2, planets.size());
	}
	
	@Test
	public void shouldFindPlanetById() {
		Planet planet = new Planet();
		planet.setName("Yavin IV");
		planetRepository.insert(planet);
		Optional<Planet> insertedPlanet = planetRepository.findById(planet.getId());
		assertEquals("Yavin IV", insertedPlanet.get().getName());
	}
	
	@Test
	public void shouldRemovePlanet() {
		Planet planet = new Planet();
		planet.setName("Yavin IV");
		planetRepository.insert(planet);
		assertEquals(1, planetRepository.count());
		planetRepository.deleteById(planet.getId());
		assertEquals(0, planetRepository.count());
	}
}

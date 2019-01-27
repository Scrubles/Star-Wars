package br.com.mnascimento.starwars;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import br.com.mnascimento.starwars.repository.PlanetRepositoryTests;
import br.com.mnascimento.starwars.swapi.SwapiServiceTests;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	PlanetRepositoryTests.class,
	SwapiServiceTests.class
})
public class AppTests {

}

package br.com.mnascimento.starwars.swapi;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SwapiServiceTests {

	@Autowired
	private SwapiService swapiService;
	
	@Test
	public void shouldReturnFilmApparitionCount() {
		int filmApparitionCount = swapiService.countFilmApparition("Alderaan");
		assertEquals(2, filmApparitionCount);
	}
	
	@Test
	public void shouldNotReturnFilmApparitionCount() {
		int filmApparitionCount = swapiService.countFilmApparition("Alderan");
		assertEquals(0, filmApparitionCount);
	}
}

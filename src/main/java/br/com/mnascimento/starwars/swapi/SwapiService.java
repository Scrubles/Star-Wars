package br.com.mnascimento.starwars.swapi;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SwapiService {
	
	private static final String BASE_URL = "https://swapi.co/api/%s";
	private static final String SEARCH_URL = BASE_URL + "/?search=%s";
	private RestTemplate restTemplate;
	
	public SwapiService() {
		restTemplate = new RestTemplate();
		restTemplate.getInterceptors().add((request, body, execution) -> {
	        request.getHeaders().add("user-agent", "SWAPI-Java-Client");
	        return execution.execute(request, body);
	    });
	}
	
	public int countFilmApparition(String planetName) {
		String url = String.format(SEARCH_URL, PlanetsResponse.PATH, planetName);
		PlanetsResponse planetsResponse = restTemplate.getForObject(url, PlanetsResponse.class);
		if (planetsResponse.getCount() != 1)
			return 0;
		List<Planet> results = planetsResponse.getResults();
		Planet planet = results.get(0);
		return planetName.equalsIgnoreCase(planet.getName()) ? planet.getFilms().size() : 0;
	}
}

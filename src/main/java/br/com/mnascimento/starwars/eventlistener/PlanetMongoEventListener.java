package br.com.mnascimento.starwars.eventlistener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;

import br.com.mnascimento.starwars.model.Planet;
import br.com.mnascimento.starwars.swapi.SwapiService;

public class PlanetMongoEventListener extends AbstractMongoEventListener<Planet>{
	
	@Autowired
	private SwapiService swapiService;
	
	@Override
    public void onBeforeConvert(BeforeConvertEvent<Planet> event) { 
		Planet planet = event.getSource();
		int filmApparitionCount = swapiService.countFilmApparition(planet.getName());
		planet.setFilmApparitionCount(filmApparitionCount);
    }
}

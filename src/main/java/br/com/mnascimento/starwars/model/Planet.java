package br.com.mnascimento.starwars.model;

import java.util.UUID;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;

public class Planet {

	@Id
	private String id = UUID.randomUUID().toString();
	@NotBlank(message = "{name.notempty}")
	private String name;
	private String weather;
	private String terrain;
	private int filmApparitionCount;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getWeather() {
		return weather;
	}
	public void setWeather(String weather) {
		this.weather = weather;
	}
	
	public String getTerrain() {
		return terrain;
	}
	public void setTerrain(String terrain) {
		this.terrain = terrain;
	}
	
	public int getFilmApparitionCount() {
		return filmApparitionCount;
	}
	public void setFilmApparitionCount(int filmApparitionCount) {
		this.filmApparitionCount = filmApparitionCount;
	}
}

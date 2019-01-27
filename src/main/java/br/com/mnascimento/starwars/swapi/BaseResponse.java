package br.com.mnascimento.starwars.swapi;

import java.util.List;

public class BaseResponse<T> {

	private int count;
	private List<T> results;
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	public List<T> getResults() {
		return results;
	}
	public void setResults(List<T> results) {
		this.results = results;
	}
}

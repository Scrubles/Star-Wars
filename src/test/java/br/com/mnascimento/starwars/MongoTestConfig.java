package br.com.mnascimento.starwars;

import org.springframework.context.annotation.Configuration;

@Configuration
public class MongoTestConfig extends MongoConfig {

	@Override
	protected String getDatabaseName() {
		return "test";
	}
}

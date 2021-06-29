package com.kutayyaman.footballListCase;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FootballListCaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(FootballListCaseApplication.class, args);
	}

	@Bean
//ModelMapper nesnesinden 1 tane olustur ve springin IoC containerina koy demis oluyoruz ve boylelikle dependency injection ile direkt alip kullanabilcez.
	public ModelMapper getModelMapper(){
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT); //ENUM'lari convert ederken sikinti vermemesi icn bu gerekliymis
		return modelMapper;
	}
}

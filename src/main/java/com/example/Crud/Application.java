package com.example.Crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	List<Persona> ListaPersonas(){

		Persona persona1 =new Persona(1,"Manuel",34,"Madrid");
		System.out.println(persona1);

		List<Persona> personas = new ArrayList<Persona>();
		personas.add(persona1);
		System.out.println(personas);
		return personas;
	}

}

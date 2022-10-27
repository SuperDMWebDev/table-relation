package com.example.tablerelationmaven;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class TableRelationMavenApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TableRelationMavenApplication.class, args);
	}

	private final PersonRepository personRepository;
	private final AddressRepository addressRepository;

	@Override
	public void run(String ...args) throws Exception {
		// create a person object
		Person person = Person.builder().name("minh").build();

		personRepository.save(person);


		//create a address which reference to person
		Address address = Address.builder().city("HCM").province("quan 7").person(person).build();

		addressRepository.save(address);
	}
}

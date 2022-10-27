package com.example.tablerelationmaven;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.google.common.collect.Lists;

import java.util.*;

@SpringBootApplication
@RequiredArgsConstructor
public class TableRelationMavenApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TableRelationMavenApplication.class, args);
	}
	private final AddressRepository addressRepository;
	private final PersonRepository personRepository;

	public void run (String ...args) throws Exception{
		Address hanoi = Address.builder()
				.city("hanoi")
				.build();
		Address hatay = Address.builder()
				.city("hatay")
				.build();
		Person person1 = Person.builder()
				.name("loda1")
				.build();
		Person person2 = Person.builder()
				.name("loda2")
				.build();
		hanoi.setPersons(Lists.newArrayList(person1,person2));
		hatay.setPersons(Lists.newArrayList(person1));

		addressRepository.saveAndFlush(hanoi);
//		addressRepository.saveAndFlush(hatay);
//
		Address queryResult = addressRepository.findById(1L).get();
		System.out.println(queryResult.getCity());
		System.out.println(queryResult.getPersons());





	}
}

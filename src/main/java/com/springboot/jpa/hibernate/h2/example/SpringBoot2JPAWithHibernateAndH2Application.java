package com.springboot.jpa.hibernate.h2.example;

import com.springboot.jpa.hibernate.h2.example.book.*;
import com.springboot.jpa.hibernate.h2.example.car.Car;
import com.springboot.jpa.hibernate.h2.example.car.CarRepository;
import com.springboot.jpa.hibernate.h2.example.dealer.Dealer;
import com.springboot.jpa.hibernate.h2.example.dealer.DealerRepository;
import com.springboot.jpa.hibernate.h2.example.dealerCar.CarDealer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springboot.jpa.hibernate.h2.example.student.StudentRepository;

import java.util.Arrays;
import java.util.Date;

@SpringBootApplication
public class SpringBoot2JPAWithHibernateAndH2Application implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	CarRepository carRepository;

	@Autowired
	DealerRepository dealerRepository;

	@Autowired
	BookRepository bookRepository;

	@Autowired
	PublisherRepository publisherRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot2JPAWithHibernateAndH2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

//		logger.info("Student id 10001 -> {}", studentRepository.findById(10001L));
//
//		logger.info("Inserting -> {}", studentRepository.save(new Student("John", "A1234657")));
//
//		logger.info("Update 10003 -> {}", studentRepository.save(new Student(10001L, "Name-Updated", "New-Passport")));
//
//		studentRepository.deleteById(10002L);
//
//		logger.info("All users -> {}", studentRepository.findAll());



//		logger.info("The student is -> {}", studentRepository.findStudentByName("Ranga"));
//
//		carRepository.save(new Car("make1", "name1", "color1"));
//		logger.info("car id 1 -> {}", carRepository.findById(1));
//
//		dealerRepository.save(new Dealer("dealer0"));
//		dealerRepository.save(new Dealer("dealer1"));
//		dealerRepository.save(new Dealer("dealer2"));
//		dealerRepository.save(new Dealer("dealer3"));
//		logger.info("dealer id 0 -> {}", dealerRepository.findById(0));
//
//		carRepository.save(new Car("make2", "name2", "color2"));


		Dealer dealerA = new Dealer("dealerA");
		Dealer dealerB = new Dealer("dealerB");
		dealerRepository.saveAll(Arrays.asList(dealerA, dealerB));
		Car carA = new Car("make1", "name1", "color1");
		carRepository.save(carA);
		carA.addCarDealer(new CarDealer(dealerA));
//		carRepository.save(carA);
//		carRepository.save(new Car(1, new CarDealer(dealerA)));


		// Create a couple of Book, Publisher and BookPublisher
		Publisher publisherA = new Publisher("Publisher A");
		Publisher publisherB = new Publisher("Publisher B");
		publisherRepository.saveAll(Arrays.asList(publisherA, publisherB));

		bookRepository.save(new Book("Book 1", new BookPublisher(publisherA, new Date()), new BookPublisher(publisherB, new Date())));
		bookRepository.save(new Book("Book 2", new BookPublisher(publisherA, new Date())));


	}
}

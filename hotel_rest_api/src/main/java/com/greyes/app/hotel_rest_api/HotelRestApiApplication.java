package com.greyes.app.hotel_rest_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//Spring quand il est lancé est obligé de tourner en continu 

@SpringBootApplication
public class HotelRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelRestApiApplication.class, args);
	}

}

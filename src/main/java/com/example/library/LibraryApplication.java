package com.example.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.LinkedList;
import java.util.Queue;

@SpringBootApplication
public class LibraryApplication {

	public static void main(String[] args) {
		Queue<Long> q = new LinkedList<>();
		SpringApplication.run(LibraryApplication.class, args);
	}

}

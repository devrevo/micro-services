package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.example.demo.model.Client;
import com.example.demo.repositories.ClientRepository;

@SpringBootApplication
public class ClientServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientServiceApplication.class, args);
	}
	@Bean
    CommandLineRunner start(ClientRepository clientRepository, RepositoryRestConfiguration restConfiguration){
        return args -> {
            restConfiguration.exposeIdsFor(Client.class);
            clientRepository.save(new Client(null,"LMSALI 1","test1@gmail.com"));
            clientRepository.save(new Client(null,"LMSALI 2","test2@gmail.com"));
            clientRepository.save(new Client(null,"LMSALI 3","test3@gmail.com"));
            clientRepository.findAll().forEach(client->{
                System.out.println(client.getCode());
            });
        };
    }
}

package com.example.demo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.example.demo.models.Compte;
import com.example.demo.models.Operation;
import com.example.demo.services.ClientService;
import com.example.demo.services.CompteRepository;
import com.example.demo.services.OperationServiceImp;


@SpringBootApplication
@EnableFeignClients
public class CompteServiceApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(CompteServiceApplication.class, args);
	}
	
	@Autowired 
	OperationServiceImp osi;
	@Bean
    CommandLineRunner start(ClientService cltService,CompteRepository compteRepository, RepositoryRestConfiguration restConfiguration){
		
		List<Compte> comptes = new ArrayList<Compte>();

		return args -> {
			restConfiguration.exposeIdsFor(Compte.class);
	        compteRepository.save(new Compte(new Long(1),12000,new Date(),new ArrayList<Operation>(),new Long(1),cltService.findClientById(new Long(1))));
	        compteRepository.save(new Compte(null,40000,new Date(),new ArrayList<Operation>(),new Long(2),cltService.findClientById(new Long(2))));
	        compteRepository.save(new Compte(null,30000,new Date(),new ArrayList<Operation>(),new Long(3),cltService.findClientById(new Long(3))));
	        compteRepository.findAll().forEach(compte->{
	            comptes.add(compte);
	        });
	        
	        osi.virement(comptes.get(0), comptes.get(1), 1000);
	        osi.virement(comptes.get(2), comptes.get(0), 2000);
	        osi.virement(comptes.get(1), comptes.get(0), 4000);
            System.out.println("Operations Done !!!!");
        };
    }
}

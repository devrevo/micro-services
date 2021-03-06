package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Compte;
import com.example.demo.services.ClientService;
import com.example.demo.services.CompteRepository;
import com.example.demo.services.OperationRepository;

@RestController
public class CompteController {
	@Autowired
	private CompteRepository cpRep;
	@Autowired
	private ClientService cltService;
	@Autowired
	private OperationRepository opRep;
	
	Compte getCompte(@PathVariable("id") Long id) {
		Compte cpt = cpRep.findById(id).get();
		cpt.setClt(cltService.findClientById(cpt.getClientId()));
		cpt.setOperations(opRep.findByCompteCode(id));
		return cpt;			
	}
}

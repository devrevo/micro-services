package com.example.demo.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.models.Compte;
import com.example.demo.models.Operation;

@Service
@Transactional
public class OperationServiceImp implements OperationService{


    @Autowired
    private CompteRepository compteRepository;
    @Autowired
    private OperationRepository operationRepository;
    @Override
    public void virement(Compte debiteur, Compte crediteur, double montant) {
    	debiteur.setSolde(debiteur.getSolde()-montant);
    	crediteur.setSolde(crediteur.getSolde()+montant);
    	System.out.println(debiteur.getCode());
    	System.out.println(crediteur.getCode());

        compteRepository.save(debiteur);
        compteRepository.save(crediteur);
        
        operationRepository.save(new Operation(null,new Date(),montant,"DEBIT",debiteur));
        operationRepository.save(new Operation(null,new Date(),montant,"CREDIT",crediteur));

    }

}

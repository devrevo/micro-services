package com.example.demo.services;

import com.example.demo.models.Compte;

public interface OperationService {
	void virement(Compte debiteur,Compte crediteur, double montant);
}

package com.example.demo.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Operation {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long numero;
	private Date dateOperation;
	private double montant;
	private String type;
	@ManyToOne
	private Compte compte;
	
}

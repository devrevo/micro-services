package com.example.demo.models;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Compte {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long code;
	private double solde;
	private Date dateCreation;
	@OneToMany(mappedBy = "compte")
	private Collection<Operation> operations;
	private Long clientId;
	@Transient
	private Client clt;
}

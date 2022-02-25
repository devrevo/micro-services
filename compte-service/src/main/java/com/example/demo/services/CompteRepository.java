package com.example.demo.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.models.Compte;

@RepositoryRestResource
public interface CompteRepository extends JpaRepository<Compte,Long> {
}

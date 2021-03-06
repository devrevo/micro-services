package com.example.demo.services;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.models.Operation;

@RepositoryRestResource
public interface OperationRepository extends JpaRepository<Operation,Long> {
	public Collection<Operation> findByCompteCode(Long id);
}

package com.example.demo.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.models.Client;

@FeignClient(name="CLIENT-SERVICE")
public interface ClientService {
	@GetMapping("/clients/{id}")
	Client findClientById(@PathVariable("id") Long id);
}

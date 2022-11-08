package com.example.springbootredis.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootredis.model.Chaine;
import com.example.springbootredis.service.ChaineService;

@RestController
@RequestMapping("/api/chaine")
public class ChaineResource {

	@Autowired
	ChaineService chaineService;

	@GetMapping(path = "{id}")
	@Cacheable(value = "Chaine", key = "#id")
	public Chaine getChaine(@PathVariable("id") final Long id) {
		return chaineService.findById(id);
	}

	@PostMapping
	public Chaine saveChaine(@RequestBody Chaine chaine) {
		return chaineService.save(chaine);
	}

}

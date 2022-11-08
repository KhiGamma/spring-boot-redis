package com.example.springbootredis.service;

import com.example.springbootredis.model.Chaine;

public interface ChaineService {

	public Chaine save(Chaine emp);

	public Chaine findById(Long id);
}

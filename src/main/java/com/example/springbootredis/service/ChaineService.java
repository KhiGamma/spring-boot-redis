package com.example.springbootredis.service;

import com.example.springbootredis.model.Chaine;
import com.example.springbootredis.model.ChaineRequest;

public interface ChaineService {

	public Chaine save(ChaineRequest chaine);

	public Chaine findById(Long id);
}

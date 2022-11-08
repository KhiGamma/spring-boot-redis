package com.example.springbootredis.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.example.springbootredis.model.Chaine;

@Service
public class ChaineServiceImpl implements ChaineService {

	private static final String CHAINE = "Chaine";

	private RedisTemplate<String, Object> redisTemplate;

	private HashOperations<String, Long, Chaine> hashOperations;

	@Autowired
	public ChaineServiceImpl(RedisTemplate<String, Object> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}
	
	@PostConstruct
	public void init() {
		this.hashOperations = redisTemplate.opsForHash();
	}

	@Override
	public Chaine save(Chaine chaine) {
		chaine.setSignee(chaine.getInitiale() + " mais signée");
		hashOperations.put(CHAINE, chaine.getId(), chaine);
		return chaine;
	}

	@Override
	public Chaine findById(Long id) {
		return (Chaine) hashOperations.get(CHAINE, id);
	}

}

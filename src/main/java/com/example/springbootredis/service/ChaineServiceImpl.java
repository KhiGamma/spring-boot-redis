package com.example.springbootredis.service;

import javax.annotation.PostConstruct;

import com.example.springbootredis.model.ChaineRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.example.springbootredis.model.Chaine;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

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
	public Chaine save(ChaineRequest chaineRequest) {

		Chaine chaine = new Chaine(chaineRequest);
		String message = chaine.getInitiale();

		try {
			MessageDigest msg = MessageDigest.getInstance("SHA-256");
			byte[] hash = msg.digest(message.getBytes(StandardCharsets.UTF_8));

			StringBuilder sb = new StringBuilder();
			for (byte b : hash) {
				sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
			}
			chaine.setSignee(sb.toString());
			hashOperations.put(CHAINE, chaine.getId(), chaine);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return chaine;
	}

	@Override
	public Chaine findById(Long id) {
		return (Chaine) hashOperations.get(CHAINE, id);
	}

}

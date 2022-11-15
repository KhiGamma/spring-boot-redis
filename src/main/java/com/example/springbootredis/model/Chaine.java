package com.example.springbootredis.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Chaine implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String initiale;
	private String signee;


	public Chaine (ChaineRequest chaineRequest) {

		this.id = chaineRequest.getId();
		this.initiale = chaineRequest.getInitiale();
	}
}



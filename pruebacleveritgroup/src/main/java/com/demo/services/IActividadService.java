package com.demo.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.demo.entity.Actividad;

public interface IActividadService {
	
	public List<Actividad> findAll();
	
	public ResponseEntity<?> findById(Long id);
	
	public Actividad save(Actividad activiad);
	
	public ResponseEntity<?> delete(Long id);

}

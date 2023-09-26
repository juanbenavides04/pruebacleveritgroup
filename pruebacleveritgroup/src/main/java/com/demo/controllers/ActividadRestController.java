package com.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.Actividad;
import com.demo.services.IActividadService;

@RestController
@RequestMapping("/api")
public class ActividadRestController {
	
	@Autowired
	private IActividadService ActividadService;
	
	@PostMapping("/guardar")
	public Actividad guardar(@RequestBody Actividad actividad) {
		return ActividadService.save(actividad);
	}
	
	
	@PostMapping("/modificar")
	public Actividad modificar(@RequestBody Actividad actividad) {
		return ActividadService.save(actividad);
	}
	
	@GetMapping("/mostrar/{id}")
	public ResponseEntity<?> mostrar(@PathVariable Long id) {
		return ActividadService.findById(id);
	}
	
	@GetMapping("/mostrarlista")
	public List<Actividad> mostrarlista() {
		return ActividadService.findAll();
	}
	
	
	@GetMapping("/eliminar/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id) {
		 return ActividadService.delete(id);
	}

}

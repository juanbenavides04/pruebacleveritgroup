package com.demo.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.demo.dao.IActividadDao;
import com.demo.entity.Actividad;

import jakarta.transaction.Transactional;

@Service	
public class ActividadServiceImp implements IActividadService {
	
	@Autowired
	private IActividadDao iActividadDao;

	@Override
	public List<Actividad> findAll() {
		// TODO Auto-generated method stub
		return iActividadDao.findAll();
	}
	
	@Override
	public ResponseEntity<?> findById(Long id) {
	
		Optional<Actividad> cliente = null;
		Map<String, Object> response = new HashMap<>();

		try {
			cliente = iActividadDao.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (cliente == null) {
			response.put("mensaje", "La actividad ID: ".concat(id.toString()).concat(" no existe en la base de datos"));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Optional>(cliente, HttpStatus.OK);

		
	}


	@Override
	public Actividad save(Actividad actividad) {
		// TODO Auto-generated method stub
		return iActividadDao.save(actividad);
	}

	@Override
	@Transactional
	public ResponseEntity<?> delete(Long id) {
		
		Map<String, Object> response=new HashMap<>();
		try {
			
			Optional<Actividad> actividad=iActividadDao.findById(id);
			 if(actividad.isPresent()) {
				 iActividadDao.deleteById(id);
				 response.put("mensaje","La actividad ha sido eliminado con éxito!");
			 }else {
				 response.put("mensaje", "Error esta Actividad no existe en la base de datos.");
			 }
		
			
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar la Actividad en la base de datos.");
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}		
		
		
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.OK);
	}



}

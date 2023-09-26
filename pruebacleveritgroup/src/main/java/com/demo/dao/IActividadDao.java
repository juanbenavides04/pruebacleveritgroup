package com.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entity.Actividad;

public interface IActividadDao extends JpaRepository<Actividad, Long>{

}

package com.academia.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.academia.modelo.Estudiante;

public interface EstudianteRepositorio extends JpaRepository<Estudiante, Integer>{
	List<Estudiante> findByCedulaEquals(String cedula);

}

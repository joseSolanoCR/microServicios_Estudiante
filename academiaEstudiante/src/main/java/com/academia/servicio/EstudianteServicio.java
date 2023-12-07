package com.academia.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.academia.modelo.Estudiante;
import com.academia.repositorio.EstudianteRepositorio;

@Service
public class EstudianteServicio {
	@Autowired
	private EstudianteRepositorio repositorio;
	
	
	public List<Estudiante> listarEstudiantes(){
		return repositorio.findAll();
		
	}
	
	public Estudiante obtenerEstudianteById(Integer id){
		return repositorio.findById(id).get();	
	}
	
	public void guardarEstudiante(Estudiante datosEstudiante) {
		repositorio.save(datosEstudiante);
	}

	public List<Estudiante> obtenerEstudianteByCedula(String cedula){
		return repositorio.findByCedulaEquals(cedula);
	}
	
	public void borrarEstudianteById(Integer id){
		 repositorio.deleteById(id);
	}
}

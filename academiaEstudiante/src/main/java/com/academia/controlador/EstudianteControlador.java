package com.academia.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.academia.modelo.Estudiante;
import com.academia.servicio.EstudianteServicio;

@RestController
public class EstudianteControlador {
	
	@Autowired
	private EstudianteServicio servicio;
	
	@GetMapping("/estudiantes")
	public List<Estudiante> listarEstudiantes(){
		return servicio.listarEstudiantes(); 
	}
	
	@GetMapping("/estudiante/{id}")
	public ResponseEntity<Estudiante> obtenerEstudianteById(@PathVariable Integer id){
		try {
			Estudiante estudianteDato = servicio.obtenerEstudianteById(id);
			if (estudianteDato !=null) {
			return new ResponseEntity<>(estudianteDato, HttpStatus.OK);
			} else {}return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
	@PostMapping("/estudiantes")
	public void guardarEstudiante(@RequestBody Estudiante datosEstudiante){
		 servicio.guardarEstudiante(datosEstudiante);
	}
	
	@DeleteMapping("/estudiante/{id}")
	public void borrarEstudianteById(@PathVariable Integer id){
		 servicio.borrarEstudianteById(id);
	}


	@GetMapping("/estudianteByCedula/{cedula}")
	public ResponseEntity<Estudiante> obtenerEstudianteByCedula(@PathVariable String cedula){
		try {
			List<Estudiante> estudianteDato = servicio.obtenerEstudianteByCedula(cedula);
			if (!estudianteDato.isEmpty()) {
			return new ResponseEntity<>(estudianteDato.get(0), HttpStatus.OK);
			} else {}return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}

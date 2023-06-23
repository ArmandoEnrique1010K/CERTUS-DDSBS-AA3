package com.edu.certus.curso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.certus.curso.dto.CursoDto;
import com.edu.certus.curso.dto.ResponseDto;
import com.edu.certus.curso.service.CursoService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/v1/curso")
public class CursoController {
	
	@Autowired
	private CursoService cursoService;
	
        @ApiOperation("Metodo para listar todos los cursos")
	@GetMapping()
	public ResponseEntity<ResponseDto> readAllCurso(){
		return ResponseEntity.status(HttpStatus.OK).body(cursoService.getAllCurso());
	}
        
        @ApiOperation("Metodo para listar un curso por su ID")
	@GetMapping("/{id}")
	public ResponseEntity<ResponseDto> readCurso(@PathVariable("id")Long id){
		return ResponseEntity.status(HttpStatus.OK).body(cursoService.getCurso(id));
	}
        
        @ApiOperation("Metodo para añadir un curso")
	@PostMapping
	public ResponseEntity<ResponseDto> createCurso(@RequestBody CursoDto curso){
		return ResponseEntity.status(HttpStatus.CREATED).body(cursoService.createCurso(curso));
	}
        
        @ApiOperation("Metodo para actualizar un curso")
	@PutMapping
	public ResponseEntity<ResponseDto> updateCurso(@RequestBody CursoDto curso){
		return ResponseEntity.status(HttpStatus.CREATED).body(cursoService.updateCurso(curso));
	}
        
        @ApiOperation("Metodo para eliminar un curso (solo cambia su estado por un false)")
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseDto> deleteCurso(@PathVariable("id")Long id){
		return ResponseEntity.status(HttpStatus.OK).body(cursoService.deteleCurso(id));
	}
        
        @ApiOperation("Metodo para obtener una lista de los cursos + una lista de profesores")
        @GetMapping("all-profesor")
        public ResponseEntity<ResponseDto> getAllProfesorCurso(){
		return ResponseEntity.status(HttpStatus.OK).body(cursoService.getAllProfesorCurso());
        }
        
}
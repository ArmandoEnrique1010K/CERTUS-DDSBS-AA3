package com.edu.certus.curso.controller;

import com.edu.certus.curso.dto.CursoProfesorDto;
import com.edu.certus.curso.dto.ResponseDto;
import com.edu.certus.curso.service.CursoProfesorService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/curso-profesor")
public class CursoProfesorController {
    
    @Autowired
    private CursoProfesorService cursoProfesorService;
    
    @ApiOperation("Metodo para listar todos los cursos asignados a un profesor")
    @GetMapping
    public ResponseEntity<ResponseDto> getAllCursoProfesor(){
        return ResponseEntity.status(HttpStatus.OK).body(cursoProfesorService.getAllCursoProfesor());
    }
    
    @ApiOperation("Metodo para listar un curso asignado a un profesor")
    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> getCursoProfesor(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(cursoProfesorService.getCursoProfesor(id));
    }
    
    @ApiOperation("Metodo para conectar un curso a un profesor especifico")
    @PostMapping
    public ResponseEntity<ResponseDto> createCursoProfesor(@RequestBody CursoProfesorDto cursoProfesorDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(cursoProfesorService.createCursoProfesor(cursoProfesorDto));
    }
    
}
    


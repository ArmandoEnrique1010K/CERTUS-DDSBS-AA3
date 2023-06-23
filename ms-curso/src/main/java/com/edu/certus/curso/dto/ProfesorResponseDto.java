package com.edu.certus.curso.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfesorResponseDto {
    
    private List<CursoDto> curso;
    private Object profesor;
    
    /*
    private Long id;
    private String nombre;
    private String apellidos;
    private Boolean estado;
    */
}

package com.edu.certus.profesor.service;

import com.edu.certus.profesor.dto.ProfesorDto;
import com.edu.certus.profesor.dto.ResponseDto;
import com.edu.certus.profesor.entity.ProfesorEntity;
import com.edu.certus.profesor.repository.ProfesorRepository;
import com.edu.certus.profesor.util.Constantes;
import com.edu.certus.profesor.util.Util;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProfesorServiceImpl implements ProfesorService{
    
    @Autowired
    private ProfesorRepository profesorRepository;

    @Override
    public ResponseDto getAllProfesor() {
            try {
                    List<ProfesorEntity> listaprofesorsEntity = profesorRepository.findAll();
                    List<ProfesorDto> listProfesorDto = new ArrayList<ProfesorDto>();
                    for (ProfesorEntity profesorEntity : listaprofesorsEntity) {
                            listProfesorDto.add(ProfesorDto.builder()
                            .id(profesorEntity.getId())
                            .nombre(profesorEntity.getNombres())
                            .apellidos(profesorEntity.getApellidos())
                            .sexo(profesorEntity.getSexo())
                            .estado(profesorEntity.getEstado())
                            .build());
                    }
                    return Util.getResponse(true, Constantes.OPERATION_SUCCESS, listProfesorDto);
            } catch (Exception e) {
                    return Util.getResponse(false, Constantes.OPERATION_FAILED, null);
            }
    }

    @Override
    public ResponseDto getProfesor(Long id) {
            try {
                    ProfesorEntity profesorEntity= profesorRepository.findById(id).orElse(null);
                    if(null == profesorEntity) {
                            return Util.getResponse(true, Constantes.NO_RECORDS_ROUND, null);
                    }
                    ProfesorDto profesorDto = ProfesorDto.builder()
                            .id(profesorEntity.getId())
                            .nombre(profesorEntity.getNombres())
                            .apellidos(profesorEntity.getApellidos())
                            .sexo(profesorEntity.getSexo())
                            .estado(profesorEntity.getEstado())
                            .build();
                    return Util.getResponse(true, Constantes.OPERATION_SUCCESS, profesorDto);
            } catch (Exception e) {
                    return Util.getResponse(false, Constantes.OPERATION_FAILED, null);
            }
    }

    @Override
    public ResponseDto createProfesor(ProfesorDto profesor) {
            try {
                    ProfesorEntity profesorEntity = ProfesorEntity.builder()
                            .nombres(profesor.getNombre())
                            .apellidos(profesor.getApellidos())
                            .sexo(profesor.getSexo())
                            .estado(true)
                            .build();

                    profesorRepository.save(profesorEntity);
                    profesor.setId(profesorEntity.getId());
                    return Util.getResponse(true, Constantes.OPERATION_SUCCESS, profesor);
            } catch (Exception e) {
                    return Util.getResponse(false, Constantes.OPERATION_FAILED, null);
            }
    }

    @Override
    public ResponseDto updateProfesor(ProfesorDto profesor) {
            try {
                    ProfesorEntity profesorEntity = profesorRepository.findById(profesor.getId()).orElse(null);
                    if(null == profesorEntity) {
                            return Util.getResponse(true, Constantes.NO_RECORDS_ROUND, null);
                    }
                    profesorEntity.setNombres(profesor.getNombre());
                    profesorEntity.setApellidos(profesor.getApellidos());
                    profesorEntity.setSexo(profesor.getSexo());
                    profesorRepository.save(profesorEntity);
                    return Util.getResponse(true, Constantes.OPERATION_SUCCESS, profesor);
            } catch (Exception e) {
                    return Util.getResponse(false, Constantes.OPERATION_FAILED, null);
            }
    }

    @Override
    public ResponseDto deteleProfesor(Long id) {
            try {
                    ProfesorEntity profesorEntity= profesorRepository.findById(id).orElse(null);
                    profesorEntity.setEstado(false);
                    profesorRepository.save(profesorEntity);
                    return Util.getResponse(true, Constantes.OPERATION_SUCCESS, null);
            } catch (Exception e) {
                    return Util.getResponse(false, Constantes.OPERATION_FAILED, null);
            }
    }
    
}

    
    
    
    
    
    
    


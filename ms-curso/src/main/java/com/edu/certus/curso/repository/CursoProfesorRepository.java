package com.edu.certus.curso.repository;

import com.edu.certus.curso.entity.CursoProfesorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CursoProfesorRepository extends JpaRepository<CursoProfesorEntity, Long>{
    CursoProfesorEntity findByIdCurso(Long id);
}

package com.example.trabajoClases.Model.Dao;

import com.example.trabajoClases.Model.Entity.Clasificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClasificacionRepository extends JpaRepository<Clasificacion, Long> {
    Clasificacion findByGrupo(String grupo);
}

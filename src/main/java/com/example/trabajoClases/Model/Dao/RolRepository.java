package com.example.trabajoClases.Model.Dao;

import com.example.trabajoClases.Model.Entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {
    Rol findByRol(String rol);
    List<Rol> findByEstadoTrue();
}

package com.example.trabajoClases.Model.Dao;

import com.example.trabajoClases.Model.Entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {
    Persona findByDni(String dni);
    List<Persona> findByNombreContainingIgnoreCase(String nombre);
    List<Persona> findByApellidoContainingIgnoreCase(String apellido);

    @Query("SELECT p FROM Persona p WHERE p.nombre LIKE %:nombre% OR p.apellido LIKE %:apellido%")
    List<Persona> findByNombreOrApellido(@Param("nombre") String nombre, @Param("apellido") String apellido);
}
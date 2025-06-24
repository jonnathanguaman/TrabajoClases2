package com.example.trabajoClases.Model.Dao;

import com.example.trabajoClases.Model.Entity.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {
    Proveedor findByRuc(String ruc);
    List<Proveedor> findByRazonSocialContainingIgnoreCase(String razonSocial);
    List<Proveedor> findByPais(String pais);
}
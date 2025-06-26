package com.example.trabajoClases.Model.Dao;

import com.example.trabajoClases.Model.Entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    @Query("SELECT p FROM Producto p WHERE p.clasificacion.grupo = :grupo")
    List<Producto> findByClasificacionGrupo(@Param("grupo") String grupo);

    @Query("SELECT p FROM Producto p WHERE p.precioUnitario BETWEEN :min AND :max")
    List<Producto> findByPrecioRange(@Param("min") Double min, @Param("max") Double max);

    @Query("SELECT p FROM Producto p WHERE p.stock LIKE %:stock%")
    List<Producto> findByStockContaining(String stock);

    List<Producto> findByIvaTrue();

    @Query("SELECT p FROM Producto p WHERE p.proveedor.ruc = :ruc")
    List<Producto> findByProveedorRuc(@Param("ruc") String ruc);
}

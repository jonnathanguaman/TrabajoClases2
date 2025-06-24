package com.example.trabajoClases.Model.Services;

import com.example.trabajoClases.Model.Dao.ProductoRepository;
import com.example.trabajoClases.Model.Entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    public Optional<Producto> findById(Long id) {
        return productoRepository.findById(id);
    }

    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }

    public void deleteById(Long id) {
        productoRepository.deleteById(id);
    }

    public List<Producto> findByClasificacionGrupo(String grupo) {
        return productoRepository.findByClasificacionGrupo(grupo);
    }

    public List<Producto> findByPrecioRange(Double min, Double max) {
        return productoRepository.findByPrecioRange(min, max);
    }

    public List<Producto> findByProveedorRuc(String ruc) {
        return productoRepository.findByProveedorRuc(ruc);
    }
}

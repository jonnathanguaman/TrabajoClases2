package com.example.trabajoClases.Controler;

import com.example.trabajoClases.Model.Entity.Producto;
import com.example.trabajoClases.Model.Services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "*")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public ResponseEntity<List<Producto>> getAllProductos() {
        List<Producto> productos = productoService.findAll();
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> getProductoById(@PathVariable Long id) {
        Optional<Producto> producto = productoService.findById(id);
        return producto.map(p -> new ResponseEntity<>(p, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Producto> createProducto(@RequestBody Producto producto) {
        try {
            Producto nuevoProducto = productoService.save(producto);
            return new ResponseEntity<>(nuevoProducto, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> updateProducto(@PathVariable Long id, @RequestBody Producto producto) {
        Optional<Producto> productoExistente = productoService.findById(id);
        if (productoExistente.isPresent()) {
            producto.setIdProducto(id);
            Producto productoActualizado = productoService.save(producto);
            return new ResponseEntity<>(productoActualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProducto(@PathVariable Long id) {
        Optional<Producto> producto = productoService.findById(id);
        if (producto.isPresent()) {
            productoService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/clasificacion/{grupo}")
    public ResponseEntity<List<Producto>> getProductosByClasificacion(@PathVariable String grupo) {
        List<Producto> productos = productoService.findByClasificacionGrupo(grupo);
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }

    @GetMapping("/precio")
    public ResponseEntity<List<Producto>> getProductosByPrecioRange(
            @RequestParam Double min, @RequestParam Double max) {
        List<Producto> productos = productoService.findByPrecioRange(min, max);
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }

    @GetMapping("/proveedor/{ruc}")
    public ResponseEntity<List<Producto>> getProductosByProveedor(@PathVariable String ruc) {
        List<Producto> productos = productoService.findByProveedorRuc(ruc);
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }
}

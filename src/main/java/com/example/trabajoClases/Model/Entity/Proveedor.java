package com.example.trabajoClases.Model.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.List;

@Entity
@Table(name = "proveedores")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProveedor;

    @Column(nullable = false)
    private String ruc;

    @Column(nullable = false)
    private String telefono;

    @Column(nullable = false)
    private String razonSocial;

    private String pais;
    private String correo;
    private String moneda;

    @OneToMany(mappedBy = "proveedor", cascade = CascadeType.ALL)
    private List<Producto> productos;
}

package com.example.trabajoClases.Model.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.List;

@Entity
@Table(name = "productos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProducto;

    @Column(nullable = false)
    private String stock;

    @Column(nullable = false)
    private Double precioUnitario;

    @Column(nullable = false)
    private String unidades;

    @ManyToOne
    @JoinColumn(name = "id_clasificacion")
    private Clasificacion clasificacion;

    @ManyToOne
    @JoinColumn(name = "id_proveedor")
    private Proveedor proveedor;

    @Column(nullable = false)
    private Boolean iva = false;

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
    private List<ItemFactura> itemsFactura;
}
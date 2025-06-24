package com.example.trabajoClases.Model.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.List;

@Entity
@Table(name = "items_factura")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemFactura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idItemFactura;

    @ManyToOne
    @JoinColumn(name = "id_factura")
    private Factura factura;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;

    @Column(nullable = false)
    private Integer cantidad;

    @Column(nullable = false)
    private Double precio;

    @Column(nullable = false)
    private Double subtotal;
}
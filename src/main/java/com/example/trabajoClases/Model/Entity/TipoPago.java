package com.example.trabajoClases.Model.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.List;

@Entity
@Table(name = "tipos_pago")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TipoPago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTipoPago;

    @Column(nullable = false)
    private String tipo;

    private String descripcion;

    @OneToMany(mappedBy = "tipoPago", cascade = CascadeType.ALL)
    private List<Factura> facturas;
}
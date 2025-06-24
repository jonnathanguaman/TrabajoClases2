package com.example.trabajoClases.Model.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.List;

@Entity
@Table(name = "facturas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFactura;

    @Column(nullable = false)
    private String ruc;

    @Column(nullable = false)
    private java.time.LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "id_tipo_pago")
    private TipoPago tipoPago;

    @Column(nullable = false)
    private Double descuento = 0.0;

    @Column(nullable = false)
    private Double total = 0.0;

    @ManyToOne
    @JoinColumn(name = "id_persona")
    private Persona persona;

    @OneToMany(mappedBy = "factura", cascade = CascadeType.ALL)
    private List<ItemFactura> items;
}

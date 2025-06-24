package com.example.trabajoClases.Model.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.List;

@Entity
@Table(name = "personas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPersona;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Column(nullable = false)
    private String dni;

    private String celular;
    private String correo;

    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL)
    private List<Factura> facturas;

    public Persona buscarP(String dni) {
        // Lógica de búsqueda implementada en el servicio
        return this;
    }

    public String nombreComp(String dni) {
        return this.nombre + " " + this.apellido;
    }
}

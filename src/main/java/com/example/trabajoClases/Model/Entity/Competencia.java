package com.example.trabajoClases.Model.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.List;

@Entity
@Table(name = "competencias")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Competencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCompetencia;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String descripcion;

    public boolean sexoComp(String accion) {
        return this.nombre.contains(accion);
    }
}
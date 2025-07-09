package com.example.trabajoClases.Model.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.List;

@Entity
@Table(name = "clasificaciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Clasificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClasificacion;

    @Column(nullable = false)
    private String grupo;

    @OneToMany(mappedBy = "clasificacion", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Producto> productos;
}
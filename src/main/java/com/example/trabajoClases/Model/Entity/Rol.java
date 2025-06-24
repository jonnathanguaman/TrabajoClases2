package com.example.trabajoClases.Model.Entity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.List;

@Entity
@Table(name = "roles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRol;

    @Column(nullable = false)
    private String rol;

    @Column(nullable = false)
    private Boolean estado = true;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "rol_competencia",
            joinColumns = @JoinColumn(name = "id_rol"),
            inverseJoinColumns = @JoinColumn(name = "id_competencia")
    )
    private List<Competencia> competencias;

    public boolean acceso(String accion) {
        return competencias.stream()
                .anyMatch(comp -> comp.sexoComp(accion));
    }

    public boolean asado(String permiso) {
        // Lógica de permisos
        return true;
    }
}
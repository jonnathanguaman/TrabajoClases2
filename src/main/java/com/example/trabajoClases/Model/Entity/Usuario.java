package com.example.trabajoClases.Model.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.List;

@Entity
@Table(name = "usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType
            .IDENTITY)
    private Long idUsuario;

    @Column(nullable = false, unique = true)
    private String usuario;

    @Column(nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(name = "id_persona")
    private Persona persona;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "usuario_rol",
            joinColumns = @JoinColumn(name = "id_usuario"),
            inverseJoinColumns = @JoinColumn(name = "id_rol")
    )
    private List<Rol> roles;

    public boolean sesion(String usuario, String password) {
        return this.usuario.equals(usuario) && this.password.equals(password);
    }
}
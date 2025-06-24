package com.example.trabajoClases.Model.Dao;

import com.example.trabajoClases.Model.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByUsuario(String usuario);
    Usuario findByUsuarioAndPassword(String usuario, String password);
}
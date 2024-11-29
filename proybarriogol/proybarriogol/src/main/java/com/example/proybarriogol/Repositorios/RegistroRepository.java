package com.example.proybarriogol.Repositorios;

import com.example.proybarriogol.Entidades.Registro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface RegistroRepository extends JpaRepository<Registro, Long> {

    // Método para encontrar un usuario por correo y contraseña
    Optional<Registro> findByCorreoAndContraseña(String correo, String contraseña);

    // Método para encontrar un usuario por documento
    Optional<Registro> findByDocumento(String documento);

    Registro findByCorreo(String correo);



}





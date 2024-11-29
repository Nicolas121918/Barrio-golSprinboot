package com.example.proybarriogol.Servicios;

import com.example.proybarriogol.Entidades.Registro;
import com.example.proybarriogol.Repositorios.RegistroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private RegistroRepository registroRepository;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    // Método para autenticar al usuario
    public boolean autenticar(String correo, String contraseñaIngresada) {
        // Buscar el usuario por correo
        Registro usuario = registroRepository.findByCorreo(correo);
        if (usuario != null) {
            // Comparar la contraseña ingresada con la almacenada (encriptada)
            return encoder.matches(contraseñaIngresada, usuario.getContraseña());
        }
        return false; // El usuario no existe o la contraseña no coincide
    }
}

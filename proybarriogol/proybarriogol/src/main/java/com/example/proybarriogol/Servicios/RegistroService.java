package com.example.proybarriogol.Servicios;

import com.example.proybarriogol.Entidades.Registro;
import com.example.proybarriogol.Repositorios.RegistroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegistroService {

    @Autowired
    private RegistroRepository registroRepository;

    // Método para registrar un usuario
    public Registro registrarUsuario(Registro registro) {
        return registroRepository.save(registro);
    }

    // Método para iniciar sesión
    public Optional<Registro> iniciarSesion(String correo, String contraseña) {
        return registroRepository.findByCorreoAndContraseña(correo, contraseña);
    }

    // Método para obtener un usuario por documento
    public Optional<Registro> obtenerUsuarioPorDocumento(String documento) {
        return registroRepository.findByDocumento(documento);  // Cambié findById por findByDocumento
    }

    // Método para actualizar todos los campos de un usuario
    public Optional<Registro> actualizarUsuario(String documento, Registro registroActualizado) {
        Optional<Registro> usuarioOptional = registroRepository.findByDocumento(documento);

        if (usuarioOptional.isPresent()) {
            Registro usuarioExistente = usuarioOptional.get();

            // Actualizar los campos del usuario existente con los datos del usuario actualizado
            usuarioExistente.setNombre(registroActualizado.getNombre());
            usuarioExistente.setCorreo(registroActualizado.getCorreo());
            usuarioExistente.setContraseña(registroActualizado.getContraseña());
            usuarioExistente.setCiudad(registroActualizado.getCiudad());
            usuarioExistente.setTelefono(registroActualizado.getTelefono());
            usuarioExistente.setDescripcion(registroActualizado.getDescripcion());

            // Guardar los cambios
            registroRepository.save(usuarioExistente);
            return Optional.of(usuarioExistente);
        }

        return Optional.empty(); // Usuario no encontrado
    }

}

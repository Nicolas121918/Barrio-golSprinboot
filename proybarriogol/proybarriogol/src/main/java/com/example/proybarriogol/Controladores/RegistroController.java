package com.example.proybarriogol.Controladores;

import com.example.proybarriogol.Entidades.Registro;
import com.example.proybarriogol.Entidades.datosbasicos;
import com.example.proybarriogol.Entidades.jugadores_solic;
import com.example.proybarriogol.Repositorios.RegistroRepository;
import com.example.proybarriogol.Repositorios.DatosbasicosRepository;
import com.example.proybarriogol.Repositorios.JugadoressolicRepository;
import com.example.proybarriogol.Servicios.AuthService;
import com.example.proybarriogol.Servicios.RegistroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@RestController
@RequestMapping("/api/registro")
public class RegistroController {

    private final RegistroService registroService;
    private final RegistroRepository registroRepository;
    private final DatosbasicosRepository datosbasicosRepository;
    private final JugadoressolicRepository jugadoressolicRepository;
    private final AuthService authService;

    @Autowired
    public RegistroController(RegistroService registroService, RegistroRepository registroRepository,
                              DatosbasicosRepository datosbasicosRepository, JugadoressolicRepository jugadoressolicRepository,
                              AuthService authService) {
        this.registroService = registroService;
        this.registroRepository = registroRepository;
        this.datosbasicosRepository = datosbasicosRepository;
        this.jugadoressolicRepository = jugadoressolicRepository;
        this.authService = authService;
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrarUsuario(@RequestBody Registro registro) {
        try {
            if (registroRepository.findByCorreo(registro.getCorreo()) != null) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("El correo ya está registrado.");
            }
            Registro nuevoUsuario = registroRepository.save(registro);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoUsuario);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al registrar el usuario.");
        }
    }

    @PostMapping("/registrar12")
    public ResponseEntity<?> registrarDatosBasicos(@RequestBody datosbasicos registro) {
        try {
            datosbasicos nuevoRegistro = datosbasicosRepository.save(registro);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoRegistro);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al registrar los datos básicos.");
        }
    }

    @PostMapping("/registrar2")
    public ResponseEntity<?> registrarJugador(@RequestBody jugadores_solic registro) {
        try {
            jugadores_solic nuevoRegistro = jugadoressolicRepository.save(registro);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoRegistro);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al registrar al jugador.");
        }
    }

    @PostMapping("/iniciar")
    public ResponseEntity<?> iniciarSesion(@RequestBody LoginRequest loginRequest) {
        boolean autenticado = authService.autenticar(loginRequest.getCorreo(), loginRequest.getContraseña());

        if (autenticado) {
            Registro usuario = registroRepository.findByCorreo(loginRequest.getCorreo());
            if (usuario != null) {
                return ResponseEntity.ok(usuario);
            }
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Correo o contraseña incorrectos.");
    }

    @PutMapping("/usuario/actualizar")
    public ResponseEntity<?> actualizarUsuario(@RequestParam("correo") String correo, @RequestBody Registro registroActualizado) {
        Registro usuario = registroRepository.findByCorreo(correo);

        if (usuario == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado.");
        }

        usuario.setNombre(registroActualizado.getNombre());
        usuario.setCiudad(registroActualizado.getCiudad());
        usuario.setDescripcion(registroActualizado.getDescripcion());
        usuario.setImagen(registroActualizado.getImagen());
        registroRepository.save(usuario);

        return ResponseEntity.ok("Usuario actualizado exitosamente.");
    }

    @PostMapping("/insertarvideo")
    public ResponseEntity<?> insertarVideo(@RequestParam("file") MultipartFile file) throws IOException {
        String contentType = file.getContentType();
        if (!List.of("video/mp4", "video/mpeg").contains(contentType)) {
            return ResponseEntity.badRequest().body("Formato de archivo no soportado.");
        }

        Path videoDirectory = Paths.get("videos");
        if (!Files.exists(videoDirectory)) {
            Files.createDirectories(videoDirectory);
        }

        String fileLocation = videoDirectory.resolve(file.getOriginalFilename()).toString();
        file.transferTo(new File(fileLocation));

        Registro registro = new Registro();
        registro.setVideo(fileLocation);
        registroRepository.save(registro);

        return ResponseEntity.ok(Map.of("message", "Video guardado exitosamente.", "ruta", fileLocation));
    }


    @PutMapping("/usuario/actualizar-foto")
    public ResponseEntity<?> actualizarFotoPerfil(
            @RequestParam("correo") String correo,
            @RequestParam("file") MultipartFile file) throws IOException {

        // Validar que el archivo tenga un formato de imagen permitido
        if (!List.of("image/jpeg", "image/png", "image/gif", "image/bmp", "image/svg+xml", "image/webp").contains(file.getContentType())) {
            return ResponseEntity.badRequest().body("Formato de archivo no soportado");
        }

        // Buscar al usuario por correo
        Registro usuario = registroRepository.findByCorreo(correo);
        if (usuario == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
        }

        // Crear el directorio donde se almacenarán las imágenes si no existe
        File directory = new File("micarpeta");
        if (!directory.exists()) {
            directory.mkdirs();
        }

        // Guardar el archivo en el directorio
        String fileLocation = "micarpeta/" + file.getOriginalFilename();
        file.transferTo(new File(fileLocation));

        // Actualizar la ruta de la imagen en la base de datos
        usuario.setImagen(fileLocation);
        registroRepository.save(usuario);

        // Retornar respuesta con la nueva ruta
        return ResponseEntity.ok(Map.of("message", "Foto de perfil actualizada", "ruta", fileLocation));
    }

}

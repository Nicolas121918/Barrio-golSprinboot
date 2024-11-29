package com.example.proybarriogol.Repositorios;

import com.example.proybarriogol.Entidades.datosbasicos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // No es obligatorio, pero es buena práctica
public interface DatosbasicosRepository extends JpaRepository<datosbasicos, Long> {
}

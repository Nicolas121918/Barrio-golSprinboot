package com.example.proybarriogol.Entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "Solicitud_de_jugadores")
public class jugadores_solic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre", length = 50, nullable = false)
    private String nombre;

    @Column(name = "edad", nullable = false)
    private Integer edad;

    @Column(name = "posicion", length = 50, nullable = false)
    private String posicion;

    @Column(name = "email", length = 50, nullable = false, unique = true)
    private String email;

    @Column(name = "celular", length = 50, nullable = false,unique = true)
    private String celular;

    @Column(name = "equipo", length = 50, nullable = false)
    private String equipo;

    public jugadores_solic() {
    }


    public jugadores_solic(Integer id, String nombre, Integer edad, String posicion, String email, String celular, String equipo) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.posicion = posicion;
        this.email = email;
        this.celular = celular;
        this.equipo = equipo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    @Override
    public String toString() {
        return "jugadores_solic{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", posicion='" + posicion + '\'' +
                ", email='" + email + '\'' +
                ", celular='" + celular + '\'' +
                ", equipo='" + equipo + '\'' +
                '}';
    }
}

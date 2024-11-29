package com.example.proybarriogol.Entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "userdatabasic")
public class datosbasicos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre", length = 50, nullable = false)
    private String nombre;


    @Column(name = "email", length = 50, nullable = false,unique = true)
    private String email;

    @Column(name = "celular", length = 50, nullable = false,unique = true)
    private String celular;


    public datosbasicos() {
    }


    public datosbasicos(Integer id, String nombre, String email, String celular) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.celular = celular;
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

    @Override
    public String toString() {
        return "datosbasicos{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", celular='" + celular + '\'' +
                '}';
    }
}

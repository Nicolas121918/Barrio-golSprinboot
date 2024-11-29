package com.example.proybarriogol.Entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "contactos")
public class Contacto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre", length = 50, nullable = false)
    private String nombre;

    @Column(name = "quejareclamoquest", length = 50, nullable = false)
    private String quejareclamoquest;

    @Column(name = "email", length = 50, nullable = false, unique = true)
    private String email;

    @Column(name = "celular", length = 50, nullable = false)
    private String celular;

    @Column(name = "comentario", length = 250, nullable = false)
    private String comentario;

    public Contacto(){

    }

    public Contacto(Integer id, String nombre, String quejareclamoquest, String email, String celular, String comentario) {
        this.id = id;
        this.nombre = nombre;
        this.quejareclamoquest = quejareclamoquest;
        this.email = email;
        this.celular = celular;
        this.comentario = comentario;
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

    public String getquejareclamoquest() {
        return quejareclamoquest;
    }

    public void setquejareclamoQuest(String quejareclamoquest) {
        this.quejareclamoquest = quejareclamoquest;
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

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Override
    public String toString() {
        return "Contacto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", quejaReclamoQuest='" + quejareclamoquest + '\'' +
                ", email='" + email + '\'' +
                ", celular='" + celular + '\'' +
                ", comentario='" + comentario + '\'' +
                '}';
    }
}

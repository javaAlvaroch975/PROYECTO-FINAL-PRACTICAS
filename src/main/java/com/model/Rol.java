package com.model;

import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "Roles")

public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_rol")
    private int ID_rol;

    @Column(name = "Nombre_rol")
    private String nombre;

    @Column(name = "Tipo_daño")
    private String danyo;

    public Rol(String nombre, String danyo) {
        this.nombre = nombre;
        this.danyo = danyo;
    }
    
    public Rol() {
    }

    @ManyToMany(mappedBy = "roles", fetch = FetchType.EAGER)
    private Set<Usuario> usuarios = new HashSet<>();

    public void añadirUsuario(Usuario u) {
        usuarios.add(u); 
        u.getRoles().add(this); 
    }

    public void quitarUsuario(Usuario u) {
        usuarios.remove(u); 
        u.getRoles().remove(this); 
    }


    
    }

    
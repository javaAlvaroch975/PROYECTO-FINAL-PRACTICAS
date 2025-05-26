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

    @Column(name = "Tipo_dano")
    private String dano;

    public Rol(String nombre, String dano) {
        this.nombre = nombre;
        this.dano = dano;
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

    
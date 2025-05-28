package com.model;

import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "Usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_Usuario")
    private int ID_Usuario;

    @Column(name = "Nombre_usuario")
    private String nombre;

    @Column(name = "Clan")
    private String clan;


    public Usuario(String nombre, String clan) {
        this.nombre = nombre;
        this.clan = clan;
    }
    
    public Usuario() {
    }

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.EAGER)
    @JoinTable(
        name = "usuario_rol",
        joinColumns = @JoinColumn(name = "ID_Usuario"),
        inverseJoinColumns = @JoinColumn(name = "ID_rol")
    )
    private Set<Rol> roles = new HashSet<>();

    public void añadirRol(Rol r) {
        roles.add(r);
        r.getUsuarios().add(this); 
    }

    public void quitarRol(Rol r) {
        roles.remove(r);
        r.getUsuarios().remove(this); 
    }


}


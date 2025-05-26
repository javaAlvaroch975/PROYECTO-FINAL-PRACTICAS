package com.dao;

import org.hibernate.Session;

import com.model.Usuario;
import java.util.List;

public class UsuarioDAO {
    public void insertUsuario(Session session, Usuario u){
        session.persist(u);
        System.out.println("Usuario insertado");
    }

    public void updateUsuario(Session session, Usuario u){
        session.merge(u);
        System.out.println("Usuario actualizado");
    }

    public void deleteUsuario(Session session, Usuario u){
        if (u != null) {
            session.remove(u);
            System.out.println("Usuario eliminado");
        } else {
            System.out.println("Usuario no encontrado");
        }
    }

    public List<Usuario> sellectAllUsuarios(Session session) {
        return session.createQuery("FROM Usuario", Usuario.class).list();
    } 

    public Usuario selectUsuarioBYID(Session session, int id) {
        return session.get(Usuario.class, id);
    }
}

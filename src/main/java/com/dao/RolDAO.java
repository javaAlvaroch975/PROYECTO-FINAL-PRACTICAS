package com.dao;

import org.hibernate.Session;
import com.model.Rol;
import java.util.List;

public class RolDAO {

    public void insertRol(Session session, Rol rol) {
        session.persist(rol);
        System.out.println("Rol insertado");
    }

    public void updateRol(Session session, Rol rol) {
        session.merge(rol);
        System.out.println("Rol actualizado");
    }

    public void deleteRol(Session session, Rol rol) {
        if (rol != null) {
            session.remove(rol);
            System.out.println("Rol eliminado");
        } else {
            System.out.println("Rol no encontrado");
        }
    }

    public List<Rol> selectAllRoles(Session session) {
        return session.createQuery("FROM Rol", Rol.class).list();
    }

    public Rol selectRolBYID(Session session, int id) {
        return session.get(Rol.class, id);
    }
}

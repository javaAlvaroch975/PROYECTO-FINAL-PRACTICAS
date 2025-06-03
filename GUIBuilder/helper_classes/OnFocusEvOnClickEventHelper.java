package com.example.Gui.helper_classes;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dao.UsuarioDAO;
import com.dao.RolDAO;
import com.model.Usuario;
import com.model.Rol;
import com.util.HibernateUtil;

public class OnFocusEvOnClickEventHelper {

    //RECARGAR TABLA USUARIOS
    public static void recargarTablaUsuarios(DefaultTableModel modelU, Session session, UsuarioDAO usuarioDAO) {
        modelU.setRowCount(0);
        List<Usuario> usuarios = usuarioDAO.selectAllUsuarios(session);
        for (Usuario us : usuarios) {
            Object[] filaU = { us.getIdusuario(), us.getNombre(), us.getClan() };
            modelU.addRow(filaU);
        }
    }

    //RECARGAR TABLA ROLES
    public static void recargarTablaRoles(DefaultTableModel modelR, Session session, RolDAO rolDAO) {
        modelR.setRowCount(0);
        List<Rol> roles = rolDAO.selectAllRoles(session);
        for (Rol rol : roles) {
            Object[] filaR = { rol.getIdrol(), rol.getNombre(), rol.getTipoDanyo() };
            modelR.addRow(filaR);
        }
    }

    //RECARGAR TABLA USUARIOROL
    public static void recargarTablaUsuarioRol(DefaultTableModel modelUR, Session session, UsuarioDAO usuarioDAO) {
        modelUR.setRowCount(0);
        List<Usuario> usuarios = usuarioDAO.selectAllUsuarios(session);
        for (Usuario us : usuarios) {
            for (Rol rol : us.getRoles()) {
                Object[] filaUR = { us.getIdusuario(), us.getNombre(), rol.getIdrol(), rol.getNombre() };
                modelUR.addRow(filaUR);
            }
        }
    }

    

    public static void setOnClickColor(JButton button, Color pressedColor, Color originalColor,
                                       DefaultTableModel modelU, JTextField idUsuario, JTextField nombreUsuario, JTextField clanUsuario,
                                       DefaultTableModel modelR, JTextField idRol, JTextField nombreRol, JTextField tipoDanyoRol,
                                       DefaultTableModel modelUR, JTextField idUsuarioUR, JTextField idRolUR,
                                       Session session) {

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button.setContentAreaFilled(false);
                button.setBackground(pressedColor);
                button.setOpaque(true);
                button.repaint();

                Usuario usuario = new Usuario();
                Rol rol = new Rol();

                UsuarioDAO usuarioDAO = new UsuarioDAO();
                RolDAO rolDAO = new RolDAO();

                Session sesionDB = HibernateUtil.getSessionFactory().openSession();
                Transaction tx = sesionDB.beginTransaction();

                try {
                    String accion = button.getText();

                    // INSERTAR USUARIO
                    if (accion.equals("Insertar Usuario")) {
                        String nombre = nombreUsuario.getText();
                        String clan = clanUsuario.getText();

                        if (nombre.isEmpty()) {
                            mostrarError(nombreUsuario, "Nombre vacío");
                        } else if (clan.isEmpty()) {
                            mostrarError(clanUsuario, "Clan vacío");
                        } else {
                            usuario = new Usuario(nombre, clan);
                            usuarioDAO.insertarUsuario(sesionDB, usuario);
                            nombreUsuario.setText("");
                            clanUsuario.setText("");
                            recargarTablaUsuarios(modelU, sesionDB, usuarioDAO);
                        }

                        //ACTUALIZAR USUARIO
                    } else if (accion.equals("Actualizar Usuario")) {
                        String idTexto = idUsuario.getText();
                        String nombre = nombreUsuario.getText();
                        String clan = clanUsuario.getText();

                        if (idTexto.isEmpty()) {
                            mostrarError(idUsuario, "ID vacío");
                        } else if (nombre.isEmpty()) {
                            mostrarError(nombreUsuario, "Nombre vacío");
                        } else if (clan.isEmpty()) {
                            mostrarError(clanUsuario, "Clan vacío");
                        } else {
                            int id = Integer.parseInt(idTexto);
                            usuario = usuarioDAO.selectUsuarioById(sesionDB, id);
                            usuario.setNombre(nombre);
                            usuario.setClan(clan);
                            usuarioDAO.actualizarUsuario(sesionDB, usuario);
                            idUsuario.setText("");
                            nombreUsuario.setText("");
                            clanUsuario.setText("");
                            recargarTablaUsuarios(modelU, sesionDB, usuarioDAO);
                        }

                        //BORRAR USUARIO
                    } else if (accion.equals("Borrar Usuario")) {
                        String idTexto = idUsuario.getText();
                        if (idTexto.isEmpty()) {
                            mostrarError(idUsuario, "ID vacío");
                        } else {
                            int id = Integer.parseInt(idTexto);
                            usuarioDAO.deleteUsuario(sesionDB, id);
                            idUsuario.setText("");
                            nombreUsuario.setText("");
                            clanUsuario.setText("");
                            recargarTablaUsuarios(modelU, sesionDB, usuarioDAO);
                            recargarTablaUsuarioRol(modelUR, sesionDB, usuarioDAO);
                        }

                    // INSERTAR ROL
                    } else if (accion.equals("Insertar Rol")) {
                        String nombre = nombreRol.getText();
                        String tipo = tipoDanyoRol.getText();

                        if (nombre.isEmpty()) {
                            mostrarError(nombreRol, "Nombre vacío");
                        } else if (tipo.isEmpty()) {
                            mostrarError(tipoDanyoRol, "Tipo de daño vacío");
                        } else {
                            rol = new Rol(nombre, tipo);
                            rolDAO.insertarRol(sesionDB, rol);
                            nombreRol.setText("");
                            tipoDanyoRol.setText("");
                            recargarTablaRoles(modelR, sesionDB, rolDAO);
                        }

                        //ACTUALIZAR ROL
                    } else if (accion.equals("Actualizar Rol")) {
                        String idTexto = idRol.getText();
                        String nombre = nombreRol.getText();
                        String tipo = tipoDanyoRol.getText();

                        if (idTexto.isEmpty()) {
                            mostrarError(idRol, "ID vacío");
                        } else if (nombre.isEmpty()) {
                            mostrarError(nombreRol, "Nombre vacío");
                        } else if (tipo.isEmpty()) {
                            mostrarError(tipoDanyoRol, "Tipo vacío");
                        } else {
                            int id = Integer.parseInt(idTexto);
                            rol = rolDAO.selectRolById(sesionDB, id);
                            rol.setNombre(nombre);
                            rol.setTipoDanyo(tipo);
                            rolDAO.actualizarRol(sesionDB, rol);
                            idRol.setText("");
                            nombreRol.setText("");
                            tipoDanyoRol.setText("");
                            recargarTablaRoles(modelR, sesionDB, rolDAO);
                        }

                        //BORRAR ROL
                    } else if (accion.equals("Borrar Rol")) {
                        String idTexto = idRol.getText();
                        if (idTexto.isEmpty()) {
                            mostrarError(idRol, "ID vacío");
                        } else {
                            int id = Integer.parseInt(idTexto);
                            rolDAO.deleteRol(sesionDB, id);
                            idRol.setText("");
                            nombreRol.setText("");
                            tipoDanyoRol.setText("");
                            recargarTablaRoles(modelR, sesionDB, rolDAO);
                            sesionDB.clear();
                            recargarTablaUsuarioRol(modelUR, sesionDB, usuarioDAO);
                        }

                    //INSERTAR EN USUARIOROL (LA TABLA CONJUNTA)
                    } else if (accion.equals("Asignar Rol")) {
                        String idUsuarioTxt = idUsuarioUR.getText();
                        String idRolTxt = idRolUR.getText();

                        if (idUsuarioTxt.isEmpty()) {
                            mostrarError(idUsuarioUR, "ID de Usuario vacío");
                        } else if (idRolTxt.isEmpty()) {
                            mostrarError(idRolUR, "ID de Rol vacío");
                        } else {
                            int idU = Integer.parseInt(idUsuarioTxt);
                            int idR = Integer.parseInt(idRolTxt);
                            Usuario u = usuarioDAO.selectUsuarioById(sesionDB, idU);
                            Rol r = rolDAO.selectRolById(sesionDB, idR);
                            u.añadirRol(r);
                            tx.commit();
                            idUsuarioUR.setText("");
                            idRolUR.setText("");
                            recargarTablaUsuarioRol(modelUR, sesionDB, usuarioDAO);
                        }

                        //DESASIGNAR ROL EN USUARIOROL (LA TABLA CONJUNTA)
                    } else if (accion.equals("Quitar Rol")) {
                        String idUsuarioTxt = idUsuarioUR.getText();
                        String idRolTxt = idRolUR.getText();

                        if (idUsuarioTxt.isEmpty()) {
                            mostrarError(idUsuarioUR, "ID de Usuario vacío");
                        } else if (idRolTxt.isEmpty()) {
                            mostrarError(idRolUR, "ID de Rol vacío");
                        } else {
                            int idU = Integer.parseInt(idUsuarioTxt);
                            int idR = Integer.parseInt(idRolTxt);
                            Usuario u = usuarioDAO.selectUsuarioById(sesionDB, idU);
                            Rol r = rolDAO.selectRolById(sesionDB, idR);
                            u.quitarRol(r);
                            tx.commit();
                            recargarTablaUsuarioRol(modelUR, sesionDB, usuarioDAO);
                        }
                    }

                } catch (Exception ex) {
                    if (tx != null && tx.getStatus().canRollback()) tx.rollback();
                    ex.printStackTrace();
                } finally {
                    sesionDB.close();
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                button.setBackground(originalColor);
                button.repaint();
            }
        });
    }

    private static void mostrarError(JTextField campo, String mensaje) {
        JOptionPane.showMessageDialog(campo, mensaje);
    }
}

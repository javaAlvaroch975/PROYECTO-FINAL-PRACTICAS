package GUIBuilder;

import com.dao.RolDAO;
import com.dao.UsuarioDAO;
import com.model.Usuario;
import com.model.Rol;
import com.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class GestionUsuarioyRolesGUI {
    public static void main(String[] args){
        Usuario u = new Usuario();
        Rol r = new Rol();
        UsuarioDAO usDAO = new UsuarioDAO();
        RolDAO roDAO = new RolDAO();

        JFrame frame = new JFrame("GESTION DE ROLES Y USUARIOS");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(888, 479);
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.decode("#f4c064"));
        frame.add(panel);

        Session session = HibernateUtil.getSessionFactory().openSession();

        Pane pane = new Pane();
        Scene scene = new Scene(pane, 888, 479);
        stage.setScene(scene);
        stage.show();


    JButton btnAñadirUsuario = new JButton("Añadir Alumno");
    btnAñadirUsuario.setBounds(61, 291, 106, 30);
    btnAñadirUsuario.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
    btnAñadirUsuario.setBackground(Color.decode("#bca8e4"));
    btnAñadirUsuario.setForeground(Color.decode("#000"));
    btnAñadirUsuario.setBorder(BorderFactory.createLineBorder(Color.decode("#3d364a")));
    panel.add(btnAñadirUsuario);

    JButton btnActualizarUsuario = new JButton("Actualizar Alumno");
    btnActualizarUsuario.setBounds(213, 292, 106, 30);
    btnActualizarUsuario.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
    btnActualizarUsuario.setBackground(Color.decode("#bca8e4"));
    btnActualizarUsuario.setForeground(Color.decode("#000"));
    btnActualizarUsuario.setBorder(BorderFactory.createLineBorder(Color.decode("#3d364a")));
    panel.add(btnActualizarUsuario);

    JButton btnBorrarAlumno = new JButton("Borrar Alumno");
    btnBorrarAlumno.setBounds(136, 347, 106, 30);
    btnBorrarAlumno.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
    btnBorrarAlumno.setBackground(Color.decode("#bca8e4"));
    btnBorrarAlumno.setForeground(Color.decode("#000"));
    btnBorrarAlumno.setBorder(BorderFactory.createLineBorder(Color.decode("#3d364a")));
    panel.add(btnBorrarAlumno);

    JButton btnAñadirRol = new JButton("Añadir");
    btnAñadirRol.setBounds(595, 285, 106, 30);
    btnAñadirRol.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
    btnAñadirRol.setBackground(Color.decode("#bca8e4"));
    btnAñadirRol.setForeground(Color.decode("#000"));
    btnAñadirRol.setBorder(BorderFactory.createLineBorder(Color.decode("#3d364a")));
    panel.add(btnAñadirRol);

    JButton btnActualizarRol = new JButton("Rol");
    btnActualizarRol.setBounds(746, 285, 106, 30);
    btnActualizarRol.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
    btnActualizarRol.setBackground(Color.decode("#bca8e4"));
    btnActualizarRol.setForeground(Color.decode("#000"));
    btnActualizarRol.setBorder(BorderFactory.createLineBorder(Color.decode("#3d364a")));
    panel.add(btnActualizarRol);

    JButton btnBorrarRol = new JButton("Borrar");
    btnBorrarRol.setBounds(671, 337, 106, 30);
    btnBorrarRol.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
    btnBorrarRol.setBackground(Color.decode("#bca8e4"));
    btnBorrarRol.setForeground(Color.decode("#000"));
    btnBorrarRol.setBorder(BorderFactory.createLineBorder(Color.decode("#3d364a")));
    panel.add(btnBorrarRol);

    JTextField txtIDAlumno = new JTextField();
    txtIDAlumno.setBounds(155, 130, 106, 24);
    txtIDAlumno.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
    txtIDAlumno.setBackground(Color.decode("#ffe7bf"));
    txtIDAlumno.setForeground(Color.decode("#000"));
    txtIDAlumno.setBorder(BorderFactory.createLineBorder(Color.decode("#000")));
    panel.add(txtIDAlumno);
    txtIDAlumno.setEditable(false);

    JTextField txtNombreAlumno = new JTextField();
    txtNombreAlumno.setBounds(154, 181, 106, 24);
    txtNombreAlumno.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
    txtNombreAlumno.setBackground(Color.decode("#ffe7bf"));
    txtNombreAlumno.setForeground(Color.decode("#000"));
    txtNombreAlumno.setBorder(BorderFactory.createLineBorder(Color.decode("#000")));
    panel.add(txtNombreAlumno);
    txtNombreAlumno.setEditable(false);

    JTextField txtNombreClan = new JTextField();
    txtNombreClan.setBounds(154, 237, 106, 24);
    txtNombreClan.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
    txtNombreClan.setBackground(Color.decode("#ffe7bf"));
    txtNombreClan.setForeground(Color.decode("#000"));
    txtNombreClan.setBorder(BorderFactory.createLineBorder(Color.decode("#000")));
    panel.add(txtNombreClan);
    txtNombreClan.setEditable(false);

    JTextField txtIDRol = new JTextField();
    txtIDRol.setBounds(738, 130, 106, 24);
    txtIDRol.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
    txtIDRol.setBackground(Color.decode("#ffe7bf"));
    txtIDRol.setForeground(Color.decode("#000"));
    txtIDRol.setBorder(BorderFactory.createLineBorder(Color.decode("#000")));
    panel.add(txtIDRol);
    txtIDRol.setEditable(false);

    JTextField txtNombreRol = new JTextField();
    txtNombreRol.setBounds(739, 180, 106, 24);
    txtNombreRol.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
    txtNombreRol.setBackground(Color.decode("#ffe7bf"));
    txtNombreRol.setForeground(Color.decode("#000"));
    txtNombreRol.setBorder(BorderFactory.createLineBorder(Color.decode("#000")));
    panel.add(txtNombreRol);
    txtNombreRol.setEditable(false);

    JTextField txtTipoDanyo = new JTextField();
    txtTipoDanyo.setBounds(742, 237, 106, 24);
    txtTipoDanyo.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
    txtTipoDanyo.setBackground(Color.decode("#ffe7bf"));
    txtTipoDanyo.setForeground(Color.decode("#000"));
    txtTipoDanyo.setBorder(BorderFactory.createLineBorder(Color.decode("#000")));
    panel.add(txtTipoDanyo);
    txtTipoDanyo.setEditable(false);

    frame.add(panel);
    frame.setVisible(true);

    }
}
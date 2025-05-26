package com.juego;
import java.util.Scanner;
import com.util.HibernateUtil;
import com.model.*;
import com.dao.RolDAO;
import com.dao.UsuarioDAO;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {

    static void imprimirmenu(){
    System.out.println("1 Añadir Usuario");
    System.out.println("2 Actualizar Usuario");
    System.out.println("3 Borrar Usuario");
    System.out.println("4 Añadir Rol");
    System.out.println("5 Actualizar Rol");
    System.out.println("6 Borrar Rol");
    System.out.println("7 Ver usuarios");
    System.out.println("8 Ver roles");
    System.out.println("0 Salir");
}

static void imprimirrol(){
    System.out.println("Mago");
    System.out.println("Tanque");
    System.out.println("Asesino");
    System.out.println("Tirador");
    System.out.println("Luchador");
    System.out.println("Soporte");
}
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    UsuarioDAO  usuDAO = new UsuarioDAO();
    RolDAO roDAO = new RolDAO();
    Usuario usu = new Usuario();
    Rol ro = new Rol();

    imprimirmenu();    
    int opc = sc.nextInt();
    String nombre;
    String clan;
    String rol;
    
    do {
        switch (opc) {
            case 0:
            System.out.println("Adios");
                sc.close();
                break;
            
            case 1:
            System.out.println("Dime un nombre");
            nombre = sc.next();
            System.out.println();

            System.out.println("Dime a que clan perteneces");
            clan = sc.next();
            System.out.println();

            imprimirrol();
            rol = sc.next();
            
            Session session = HibernateUtil.getSessionFactory().openSession();
T           ransaction tx = session.beginTransaction();


            usu = new Usuario(nombre, clan, rol);
            UsuarioDAO.insertUsuario(session, usu);

            tx.commit();
            session.close();
                break;

                
            case 2:
                System.out.println("Dime cual es tu rol");
                sc.close();
                break;
        
            default:
            System.out.println("Elige una opcion valida");
                break;
        }
        

    }while (opc != 0);
    
    

    }
}
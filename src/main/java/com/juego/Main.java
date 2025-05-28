package com.juego;
import java.util.List;
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
    System.out.println("9 Asociar Usuario a rol");
    System.out.println("10 Desaciociar rol a Usuario");
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

static void actualizarcampo_us(){
    System.out.println("1 Nombre");
    System.out.println("2 Clan");
    System.out.println("3 Rol");
    System.out.println("4 Todos los campos");
}

static void actualizarcampo_rol(){
    System.out.println("1 Nombre");
    System.out.println("2 Tipo de daño");
    System.out.println("3 Todos los campos");
}

    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    UsuarioDAO  usuDAO = new UsuarioDAO();
    RolDAO roDAO = new RolDAO();
    Usuario usu = new Usuario();
    Rol ro = new Rol();

    int opc;
    int id;
    String nombre_us;
    String nombre_rol;
    String clan;
    String rol;
    String tipo_danyo;
    Session session = null;
    Transaction tx = null;

        do {
            imprimirmenu();    
             opc = sc.nextInt();
    
             try{
                session = HibernateUtil.getSessionFactory().openSession();
                tx = session.beginTransaction();

            switch (opc) {
                case 0:
                System.out.println("Adios");
                    sc.close();
                    break;
                
                case 1:
    
                System.out.println("Dime un nombre");
                nombre_us = sc.next();
                System.out.println();
    
                System.out.println("Dime a que clan perteneces");
                clan = sc.next();
                System.out.println();
    
                imprimirrol();
                System.out.println("Dime que rol quieres");
                rol = sc.next();
    
                usu = new Usuario(nombre_us, clan);
                usuDAO.insertUsuario(session, usu);
    
                    break;
                    
                case 2:
    
                    System.out.println("Dime cual es tu id");
                    id = sc.nextInt();
                    Usuario uact = usuDAO.selectUsuarioBYID(session, id);
                    
                    sc.nextLine(); 

                    actualizarcampo_us();
                    int opcu2 = sc.nextInt();
                    switch (opcu2) {
                        case 1:
                        System.out.println("Dime tu nuevo nombre");
                            nombre_us = sc.next();
                            uact.setNombre(nombre_us);
                            usuDAO.updateUsuario(session, uact);
    
                            break;
    
                        case 2:
                        System.out.println("Dime tu nuevo clan");
                            clan = sc.next();
                            uact.setClan(clan);
                            usuDAO.updateUsuario(session, uact);

                            break;
    
                        case 3:
                        System.out.println("Dime tu nuevo rol");
                            rol = sc.next();
                            usuDAO.updateUsuario(session, uact);

                            break;   
                            
                        case 4:
                        System.out.println("Dime tu nuevo nombre");
                            nombre_us = sc.next();

                        System.out.println("Dime tu nuevo clan");
                            clan = sc.next();

                            System.out.println();
                            imprimirrol();
                            
                        System.out.println("Dime tu nuevo rol");
                            rol = sc.next();
        
                            uact.setNombre(nombre_us);
                            uact.setClan(clan);

                            usuDAO.updateUsuario(session, uact);

                            break;  
                            
                        default:
                        System.out.println("Elige una opcion valida");
                            break;
                    }
                    System.out.println();
                    break;
            

            case 3:
                System.out.println("Dime cual es tu id");
                id = sc.nextInt();
                Usuario udel = usuDAO.selectUsuarioBYID(session, id);
            
                usuDAO.deleteUsuario(session, udel);
                System.out.println();

                break;
            
            case 4:
                    System.out.println("Dime el nombre del nuevo rol");
                    nombre_rol = sc.next();
                    System.out.println();

                    System.out.println("Dime el tipo de daño del rol");
                    tipo_danyo = sc.next();
                    System.out.println();

                    ro = new Rol(nombre_rol, tipo_danyo);
                    roDAO.insertRol(session, ro);

                break;

            case 5:
            System.out.println("Dime cual es tu id");
            id = sc.nextInt();
            Rol roact = roDAO.selectRolBYID(session, id);
            
            sc.nextLine(); 

            actualizarcampo_rol();
            int opcr2 = sc.nextInt();
            switch (opcr2) {
                case 1:
                System.out.println("Dime tu nuevo nombre");
                    nombre_rol = sc.next();
                    roact.setNombre(nombre_rol);
                    roDAO.updateRol(session, roact);

                    break;

                case 2:
                System.out.println("Dime el nuevo tipo de daño");
                    tipo_danyo = sc.next();
                    roact.setDanyo(tipo_danyo);
                    roDAO.updateRol(session, roact);

                    break;            
                    
                case 3:
                System.out.println("Dime tu nuevo nombre");
                    nombre_rol = sc.next();

                    System.out.println("Dime el nuevo tipo de daño");
                    tipo_danyo = sc.next();

                    roact.setNombre(nombre_rol);
                    roact.setDanyo(tipo_danyo);

                    roDAO.updateRol(session, roact);

                    break;  
                    
                default:
                System.out.println("Elige una opcion valida");
                    break;
            }
            System.out.println();
            break;
    
            case 6:
            System.out.println("Dime cual es el id");
            id = sc.nextInt();
            Rol robor = roDAO.selectRolBYID(session, id);
        
            roDAO.deleteRol(session, robor);
            System.out.println();

            break;

            case 7:
            List<Usuario> listaUsuarios = usuDAO.sellectAllUsuarios(session);
    
            System.out.println("Lista de usuarios:");
            for (Usuario u : listaUsuarios) {
                System.out.println("ID: " + u.getID_Usuario());
                System.out.println("Nombre: " + u.getNombre());
                System.out.println("Clan: " + u.getClan());
                System.out.println(" ");
            }
        

            break;

            case 8:
            List<Rol> listaRoles = roDAO.selectAllRoles(session);

            System.out.println("Lista de roles:");
            for (Rol r : listaRoles) {
                System.out.println("ID: " + r.getID_rol());
                System.out.println("Nombre: " + r.getNombre());
                System.out.println("Tipo de daño: " + r.getDanyo());
                System.out.println("---------------");
            }
            
            break;

            default:
            System.out.println("Elige una opcion valida");
                break;
            }

            
            tx.commit();
            session.clear();
        }catch (Exception e){
            if (tx != null)
            
            tx.rollback();
            e.printStackTrace();
        }finally{
            session.close();
        }
        }while (opc != 0);

    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.simpleloginmysql;

import com.comunidad.simpleloginmysql.login.dao.vo.LoginVo;
import com.comunidad.simpleloginmysql.login.service.LoginService;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Santiago
 */
public class SimpleLoginMysql {

    private static LoginService loginService = new LoginService();
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sn = new Scanner(System.in);
        Scanner cadena = new Scanner(System.in);
        LoginVo loginVo = new LoginVo();
        String username;
        String password;
        boolean salir = false;
        int opcion;
        while (!salir) {
            System.out.println("******************************");
            System.out.println("      Menu de opciones        ");
            System.out.println("******************************");
            System.out.println("*   Selecciona una opcion:   *");
            System.out.println("*   1. Login 1    *");
            System.out.println("*   2. Salir                 *");
            System.out.println("******************************");
            System.out.println("******************************");
            try {

                System.out.println("Escribe una de las opciones: ");
                opcion = sn.nextInt();
                System.out.println("------------------------------");
                switch (opcion) {
                    case 1:
                        System.out.println("******************************");
                        System.out.println("*** Login ***");
                        System.out.println("Ingresa tu usuario: ");
                        username = cadena.nextLine();
                        System.out.println("Ingresa tu password: ");
                        password = cadena.nextLine();

                        if (username == null && password == null) {
                            System.out.println("Datos erroneos: ");
                        } else {
                            loginVo.setUsername(username);
                            loginVo.setPassword(password);
                            if (loginService.buscar(loginVo)!=0) {
                                System.out.println("Bienvenido!!!");
                            } else {
                                System.out.println("Datos erroneos: ");
                            }
                        }
                        break;
                    case 2:
                        System.out.println("Hasta luego!, vuelve pronto.");
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 2");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            } catch (Exception ex) {
                System.out.println("Exception-> ");
                ex.printStackTrace(System.out);
            }
        }
    }
    
}

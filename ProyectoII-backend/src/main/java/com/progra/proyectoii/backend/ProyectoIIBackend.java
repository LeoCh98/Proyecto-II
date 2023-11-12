package com.progra.proyectoii.backend;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */


import com.progra.proyectoii.backend.entidades.GestorEncuestas;
import com.progra.proyectoii.backend.entidades.GestorPreguntas;
import com.progra.proyectoii.backend.entidades.GestorRespuestas;
import cr.ac.una.db.Database;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author leoch
 */

// Just for ensure access to the db... Delete later.

public class ProyectoIIBackend {

    public static void main(String[] args) {
        try {
            Database db = Database.createMySQLDatabase("db.properties");
            System.out.println(db);

            System.out.println("Connecting..");
            try (Connection cnx = db.getConnection()) {
                System.out.println(cnx);
                System.out.println("Successful connection..");
            }
            System.out.println("Connection closed.");

        } catch (SQLException ex) {
            System.err.printf("Exception: '%s'%n", ex.getMessage());
        }
        
        GestorRespuestas respuestas = GestorRespuestas.obtenerInstancia();
        System.out.println(respuestas);
        System.out.println();
        
        GestorPreguntas preguntas = GestorPreguntas.obtenerInstancia();
        System.out.println(preguntas);
        System.out.println();
        
        GestorEncuestas encuestas = GestorEncuestas.obtenerInstancia();
        System.out.println(encuestas);
        System.out.println();
    }
}
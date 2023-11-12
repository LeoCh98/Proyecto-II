/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.progra.proyectoii.backend.entidades;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.DataSourceConnectionSource;
import com.mysql.cj.jdbc.MysqlDataSource;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * -----------------------------------------------------------------
 *
 * (c) 2023
 * 
 * @author Jean Paul Castillo Vives
 * @author Jorge Andrés Durán Campos
 * @author Leonardo Jesús Chaves Hernández
 * 
 * @version 1.0.0 2023-11-15
 * 
 * -----------------------------------------------------------------
 */

public class GestorEncuestas {
    public GestorEncuestas() {
        try {
            InitialContext ctx = new InitialContext();
            bd = (DataSource) ctx.lookup("jdbc/bd_grupos");
            System.out.println("Usando JNDI para acceder a la base de datos..");

        } catch (NamingException | NullPointerException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());

            bd = new MysqlDataSource();
            MysqlDataSource mds = (MysqlDataSource) bd;
            mds.setServerName("localhost");
            mds.setPortNumber(3306);
            mds.setDatabaseName("bd_encuestas");
            mds.setUser("root");
            mds.setPassword("root");

            System.out.println("Usando el manejador JDBC para acceder a la base de datos..");
        }

        try {
            String url = null;
            if (bd != null) {
                url = bd.getConnection().getMetaData().getURL();
                System.out.printf("Origen de datos: %s%n", url);
            } else {
                System.err.println("No se pudo establecer el origen de datos.");
            }
            System.out.println();

            DataSourceConnectionSource connectionSource
                    = new DataSourceConnectionSource(bd, url);
            encuestaDAO = DaoManager.createDao(connectionSource, Encuesta.class);
        } catch (SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }
    
    public static GestorEncuestas obtenerInstancia() {
        if (instancia == null) {
            instancia = new GestorEncuestas();
        }
        return instancia;
    }
    
    public boolean encontrarId(String id) throws SQLException {
        if(encuestaDAO.queryForId(id)!=null){
            return true;
        } else{
            return false;
        }
    }
    
    public int agregar(Encuesta nuevo) throws SQLException {
        return encuestaDAO.create(nuevo);
    }

    public Encuesta recuperar(String id) throws SQLException {
        return encuestaDAO.queryForId(id);
    }

    public int actualizar(Encuesta encuesta) throws SQLException {
        return encuestaDAO.update(encuesta);
    }

    public int eliminar(String id) throws SQLException {
        return encuestaDAO.deleteById(id);
    }

    public List<Encuesta> listarTodos() throws SQLException {
        return encuestaDAO.queryForAll();
    }

    public void actualizar() {
        encuestas.clear();
        try {
            encuestas.addAll(listarTodos());
        } catch (SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }
    
    @Override
    public String toString() {
        StringBuilder r = new StringBuilder("{");
        actualizar();
        for (Encuesta e : encuestas) {
            r.append(String.format("\n\t%s,", e));
        }
        r.append("\n}");
        return r.toString();
    }
    
    private static GestorEncuestas instancia = null;

    private DataSource bd = null;
    private Dao<Encuesta, String> encuestaDAO;

    @XmlElementWrapper(name = "encuestas")
    @XmlElement(name = "encuesta")
    private List<Encuesta> encuestas = new ArrayList<>();
}

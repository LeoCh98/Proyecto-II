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

public class GestorRespuestas {
    
    public GestorRespuestas() {
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
            respuestaDAO = DaoManager.createDao(connectionSource, Respuesta.class);
        } catch (SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }
    
    public static GestorRespuestas obtenerInstancia() {
        if (instancia == null) {
            instancia = new GestorRespuestas();
        }
        return instancia;
    }
    
    public boolean encontrarId(String id) throws SQLException {
        if(respuestaDAO.queryForId(id)!=null){
            return true;
        } else{
            return false;
        }
    }
    
    public int agregar(Respuesta nuevo) throws SQLException {
        return respuestaDAO.create(nuevo);
    }

    public Respuesta recuperar(String id) throws SQLException {
        return respuestaDAO.queryForId(id);
    }

    public int actualizar(Respuesta respuesta) throws SQLException {
        return respuestaDAO.update(respuesta);
    }

    public int eliminar(String id) throws SQLException {
        return respuestaDAO.deleteById(id);
    }

    public List<Respuesta> listarTodos() throws SQLException {
        return respuestaDAO.queryForAll();
    }

    public void actualizar() {
        respuestas.clear();
        try {
            respuestas.addAll(listarTodos());
        } catch (SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }
    
    @Override
    public String toString() {
        StringBuilder r = new StringBuilder("{");
        actualizar();
        for (Respuesta e : respuestas) {
            r.append(String.format("\n\t%s,", e));
        }
        r.append("\n}");
        return r.toString();
    }
    
    private static GestorRespuestas instancia = null;

    private DataSource bd = null;
    private Dao<Respuesta, String> respuestaDAO;

    @XmlElementWrapper(name = "respuestas")
    @XmlElement(name = "respuesta")
    private List<Respuesta> respuestas = new ArrayList<>();
}

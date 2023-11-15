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
import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
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
@XmlRootElement(name = "lista_preguntas")
public class GestorPreguntas implements Serializable {
    public GestorPreguntas() {
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
            preguntaDAO = DaoManager.createDao(connectionSource, Pregunta.class);
        } catch (SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }
    
    public static GestorPreguntas obtenerInstancia() {
        if (instancia == null) {
            instancia = new GestorPreguntas();
        }
        return instancia;
    }
    
    public boolean encontrarId(String id) throws SQLException {
        if(preguntaDAO.queryForId(id)!=null){
            return true;
        } else{
            return false;
        }
    }
    
    public int agregar(Pregunta nuevo) throws SQLException {
        return preguntaDAO.create(nuevo);
    }

    public Pregunta recuperar(String id) throws SQLException {
        return preguntaDAO.queryForId(id);
    }

    public int actualizar(Pregunta pregunta) throws SQLException {
        return preguntaDAO.update(pregunta);
    }

    public int eliminar(String id) throws SQLException {
        return preguntaDAO.deleteById(id);
    }

    public List<Pregunta> listarTodos() throws SQLException {
        return preguntaDAO.queryForAll();
    }

    public void actualizar() {
        preguntas.clear();
        try {
            preguntas.addAll(listarTodos());
        } catch (SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }
    
    @Override
    public String toString() {
        StringBuilder r = new StringBuilder("{");
        actualizar();
        for (Pregunta e : preguntas) {
            r.append(String.format("\n\t%s,", e));
        }
        r.append("\n}");
        return r.toString();
    }
    
    private static GestorPreguntas instancia = null;

    private DataSource bd = null;
    private Dao<Pregunta, String> preguntaDAO;

    @XmlElementWrapper(name = "preguntas")
    @XmlElement(name = "pregunta")
    private List<Pregunta> preguntas = new ArrayList<>();
}

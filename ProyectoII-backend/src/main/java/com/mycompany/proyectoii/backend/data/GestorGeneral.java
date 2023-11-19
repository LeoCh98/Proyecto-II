/*
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

package com.mycompany.proyectoii.backend.data;

import com.mycompany.proyectoii.backend.logic.*;
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

@XmlRootElement(name = "lista")
public class GestorGeneral implements Serializable {
    
    public GestorGeneral() {
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
            preguntaDAO = DaoManager.createDao(connectionSource, Pregunta.class);
            respuestaDAO = DaoManager.createDao(connectionSource, Respuesta.class);
        } catch (SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }
    
    public static GestorGeneral obtenerInstancia() {
        if (instancia == null) {
            instancia = new GestorGeneral();
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

    public Encuesta recuperarE(String id) throws SQLException {
        return encuestaDAO.queryForId(id);
    }
    
    public Pregunta recuperarP(String id) throws SQLException {
        return preguntaDAO.queryForId(id);
    }
    
    public Respuesta recuperarR(String id) throws SQLException {
        return respuestaDAO.queryForId(id);
    }

    public int actualizarR(Respuesta respuesta) throws SQLException {
        return respuestaDAO.update(respuesta);
    }

    public int eliminar(String id) throws SQLException {
        return respuestaDAO.deleteById(id);
    }

    public List<Encuesta> listarTodosE() throws SQLException {
        return encuestaDAO.queryForAll();
    }
    public List<Pregunta> listarTodosP() throws SQLException {
        return preguntaDAO.queryForAll();
    }
    public List<Respuesta> listarTodosR() throws SQLException {
        return respuestaDAO.queryForAll();
    }

    public void actualizar() {
        encuestas.clear();
        preguntas.clear();
        respuestas.clear();
        try {
            encuestas.addAll(listarTodosE());
            preguntas.addAll(listarTodosP());
            respuestas.addAll(listarTodosR());
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
        for (Pregunta e : preguntas) {
            r.append(String.format("\n\t%s,", e));
        }
        for (Respuesta e : respuestas) {
            r.append(String.format("\n\t%s,", e));
        }
        r.append("\n}");
        return r.toString();
    }
    
    private static GestorGeneral instancia = null;

    private DataSource bd = null;
    private Dao<Respuesta, String> respuestaDAO;
    private Dao<Pregunta, String> preguntaDAO;
    private Dao<Encuesta, String> encuestaDAO;

    @XmlElementWrapper(name = "encuestas")
    @XmlElement(name = "encuesta")
    private List<Encuesta> encuestas = new ArrayList<>();
    
    @XmlElementWrapper(name = "preguntas")
    @XmlElement(name = "pregunta")
    private List<Pregunta> preguntas = new ArrayList<>();
    
    @XmlElementWrapper(name = "respuestas")
    @XmlElement(name = "respuesta")
    private List<Respuesta> respuestas = new ArrayList<>();
}
package com.mycompany.proyectoii.backend.data;

import com.mycompany.proyectoii.backend.logic.Encuesta;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

public class EncuestaDao {
    RelDatabase db;
    
    public EncuestaDao(RelDatabase db) {
        this.db = db;
    }
    
    public Encuesta from(ResultSet rs, String alias) {
        try {
            Encuesta e = new Encuesta();
            e.setId(rs.getInt(alias + ".id_encuesta"));
            e.setFechaCreacion(rs.getDate(alias + ".fecha_creacion"));
            e.setFechaInicio(rs.getDate(alias + ".fecha_inicio"));
            e.setFechaFinal(rs.getDate(alias + ".fecha_final"));
            return e;
        } catch (SQLException ex) {
            return null;
        }
    }
    
    public ArrayList<Encuesta> findAll() throws Exception {
        ArrayList<Encuesta> result = new ArrayList<>();
        String sql = "select " +
                "* " +
                "from encuesta e";
        PreparedStatement stm = db.prepareStatement(sql);
        ResultSet rs = db.executeQuery(stm);
        PreguntaDao preguntaDao = new PreguntaDao(db);
        Encuesta e;
        while(rs.next()) {
            e = from(rs, "e");
            e.setPreguntas(preguntaDao.findBySurvey(e.getId()));
            result.add(e);
        }
        return result;
    }
    
    public ArrayList<Encuesta> findById(Integer id) throws Exception {
        ArrayList<Encuesta> result = new ArrayList<>();
        String sql = "select " +
                "* " +
                "from encuesta e " +
                "where id_encuesta=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setInt(1, id);
        ResultSet rs = db.executeQuery(stm);
        PreguntaDao preguntaDao = new PreguntaDao(db);
        Encuesta e;
        while(rs.next()) {
            e = from(rs, "e");
            e.setPreguntas(preguntaDao.findBySurvey(e.getId()));
            result.add(e);
        }
        return result;
    }
}

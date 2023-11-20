package com.mycompany.proyectoii.backend.data;

import com.mycompany.proyectoii.backend.logic.Pregunta;
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

public class PreguntaDao {
    RelDatabase db;
    
    public PreguntaDao(RelDatabase db) {
        this.db = db;
    }
    
    public Pregunta from(ResultSet rs, String alias) {
        try {
            Pregunta p = new Pregunta();
            p.setId(rs.getInt(alias + ".id_pregunta"));
            p.setIdEncuesta(rs.getInt(alias + ".id_encuesta_asignada"));
            p.setCategoria(rs.getString(alias + ".categoria"));
            p.setEnunciado(rs.getString(alias + ".enunciado"));
            return p;
        } catch (SQLException ex) {
            return null;
        }
    }
    
    public ArrayList<Pregunta> findAll() throws Exception {
        ArrayList<Pregunta> result = new ArrayList<>();
        String sql = "select " +
                "* " +
                "from pregunta p";
        PreparedStatement stm = db.prepareStatement(sql);
        ResultSet rs = db.executeQuery(stm);
        RespuestaDao respuestaDao = new RespuestaDao(db);
        Pregunta p;
        while(rs.next()) {
            p = from(rs, "p");
            p.setRespuestas(respuestaDao.findByQuestion(p.getId()));
            result.add(p);
        }
        return result;
    }
    
    public ArrayList<Pregunta> findBySurvey(Integer id) throws Exception {
        ArrayList<Pregunta> result = new ArrayList<>();
        String sql = "select " +
                "* " +
                "from pregunta p " +
                "where id_encuesta_asignada = ?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setInt(1, id);
        ResultSet rs = db.executeQuery(stm);
        RespuestaDao respuestaDao = new RespuestaDao(db);
        Pregunta p;
        while(rs.next()) {
            p = from(rs, "p");
            p.setRespuestas(respuestaDao.findByQuestion(p.getId()));
            result.add(p);
        }
        return result;
    }
}

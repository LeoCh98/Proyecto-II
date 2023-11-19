package com.mycompany.proyectoii.backend.data;

import com.mycompany.proyectoii.backend.logic.Respuesta;
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

public class RespuestaDao {
    RelDatabase db;
    
    public RespuestaDao(RelDatabase db) {
        this.db = db;
    }
    
    public Respuesta from(ResultSet rs, String alias) {
        try {
            Respuesta e = new Respuesta();
            e.setId(rs.getInt(alias + ".id_respuesta"));
            e.setIdPregunta(rs.getInt(alias + ".id_pregunta_asignada"));
            e.setLaRespuesta(rs.getString(alias + ".la_respuesta"));
            e.setCorrecto(rs.getBoolean(alias + ".correcto"));
            return e;
        } catch (SQLException ex) {
            return null;
        }
    }
    
    public ArrayList<Respuesta> findAll() throws Exception {
        ArrayList<Respuesta> result = new ArrayList<>();
        String sql = "select " +
                "* " +
                "from respuesta r";
        PreparedStatement stm = db.prepareStatement(sql);
        ResultSet rs = db.executeQuery(stm);
        while(rs.next()) {
            result.add(from(rs, "r"));
        }
        return result;
    }
    
    public ArrayList<Respuesta> findByQuestion(Integer id) throws Exception {
        ArrayList<Respuesta> result = new ArrayList<>();
        String sql = "select " +
                "* " +
                "from respuesta r" +
                "where id_pregunta_asignada = ?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setInt(1, id);
        ResultSet rs = db.executeQuery(stm);
        while(rs.next()) {
            result.add(from(rs, "r"));
        }
        return result;
    }
}

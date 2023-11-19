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
    
    public ArrayList<Encuesta> selectAll() throws Exception {
        ArrayList<Encuesta> result = new ArrayList<>();
        String sql = "select " +
                "* " +
                "from encuesta e";
        PreparedStatement stm = db.prepareStatement(sql);
        ResultSet rs = db.executeQuery(stm);
        while(rs.next()) {
            result.add(from(rs, "e"));
        }
        return result;
    }
    
    public Encuesta from(ResultSet rs, String alias) {
        try {
            Encuesta e = new Encuesta();
            e.setId(rs.getInt(alias + "id_encuesta"));
            e.setFechaCreacion(rs.getDate(alias + "fecha_creacion"));
            e.setFechaInicio(rs.getDate(alias + "fecha_inicio"));
            e.setFechaFinal(rs.getDate(alias + "fecha_final"));
            return e;
        } catch (SQLException ex) {
            return null;
        }
    }
}

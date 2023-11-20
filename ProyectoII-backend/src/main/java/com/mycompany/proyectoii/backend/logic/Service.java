package com.mycompany.proyectoii.backend.logic;

import com.mycompany.proyectoii.backend.data.*;
import java.util.List;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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

public class Service {
    private static Service uniqueInstance;
    
    public static Service instance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Service();
        }
        return uniqueInstance;
    }
    
    RelDatabase relDatabase;
    RespuestaDao respuestaDao;
    PreguntaDao preguntaDao;
    EncuestaDao encuestaDao;
    
    private Service() {
        relDatabase = new RelDatabase();
        respuestaDao = new RespuestaDao(relDatabase);
        preguntaDao = new PreguntaDao(relDatabase);
        encuestaDao = new EncuestaDao(relDatabase);
    }
    
    public ArrayList<Respuesta> selectAllRespuestas() throws Exception {
        return respuestaDao.findAll();
    }
    
    public ArrayList<Respuesta> selectRespuestas(Integer id) throws Exception {
        return respuestaDao.findByQuestion(id);
    }
    
    public ArrayList<Pregunta> selectAllPreguntas() throws Exception {
        return preguntaDao.findAll();
    }
    
    public ArrayList<Pregunta> selectPreguntas(Integer id) throws Exception {
        return preguntaDao.findBySurvey(id);
    }
    
    public ArrayList<Encuesta> selectAllEncuestas() throws Exception {
        return encuestaDao.findAll();
    }
    
    public ArrayList<Encuesta> selectEncuestas(Integer id) throws Exception {
        return encuestaDao.findById(id);
    }
}

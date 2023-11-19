package com.mycompany.proyectoii.backend.logic;

import java.io.Serializable;
import java.util.*;

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

public class Respuesta implements Serializable {
    private int id;
    private int idPregunta;
    private String laRespuesta;
    private boolean correcto;

    public Respuesta() {
        this.id = 0;
        this.idPregunta = 0;
        this.laRespuesta = "";
        this.correcto = false;
    }
    
    public Respuesta(int id, int idPregunta, String laRespuesta, boolean correcto) {
        this.id = id;
        this.idPregunta = idPregunta;
        this.laRespuesta = laRespuesta;
        this.correcto = correcto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(int idPregunta) {
        this.idPregunta = idPregunta;
    }

    public String getLaRespuesta() {
        return laRespuesta;
    }

    public void setLaRespuesta(String laRespuesta) {
        this.laRespuesta = laRespuesta;
    }

    public boolean isCorrecto() {
        return correcto;
    }

    public void setCorrecto(boolean correcto) {
        this.correcto = correcto;
    }

    @Override
    public String toString() {
        return "Respuesta{" + "id=" + id + ", idPregunta=" + idPregunta + ", laRespuesta=" + laRespuesta + ", correcto=" + correcto + '}';
    }
}
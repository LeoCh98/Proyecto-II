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

public class Encuesta implements Serializable {
    private int id;
    private Date fechaCreacion;
    private Date fechaInicio;
    private Date fechaFinal;
    
    public Encuesta() {
        this.id = 0;
        this.fechaCreacion = new Date();
        this.fechaInicio = new Date();
        this.fechaFinal = new Date();
    }

    public Encuesta(int id, Date fechaCreacion, Date fechaInicio, Date fechaFinal) {
        this.id = id;
        this.fechaCreacion = fechaCreacion;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    @Override
    public String toString() {
        return "Encuesta{" + "id=" + id + ", fechaCreacion=" + fechaCreacion + ", fechaInicio=" + fechaInicio + ", fechaFinal=" + fechaFinal + '}';
    }
}
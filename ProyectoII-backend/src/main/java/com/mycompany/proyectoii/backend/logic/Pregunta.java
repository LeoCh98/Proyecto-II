package com.mycompany.proyectoii.backend.logic;

import java.io.Serializable;

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

public class Pregunta implements Serializable {
    private int id;
    private int idEncuesta;
    private String categoria;
    private String enunciado;

    public Pregunta() {
        this.id = 0;
        this.idEncuesta = 0;
        this.categoria = "";
        this.enunciado = "";
    }

    public Pregunta(int id, int idEncuesta, String categoria, String enunciado) {
        this.id = id;
        this.idEncuesta = idEncuesta;
        this.categoria = categoria;
        this.enunciado = enunciado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdEncuesta() {
        return idEncuesta;
    }

    public void setIdEncuesta(int idEncuesta) {
        this.idEncuesta = idEncuesta;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    @Override
    public String toString() {
        return "Pregunta{" + "id=" + id + ", idEncuesta=" + idEncuesta + ", categoria=" + categoria + ", enunciado=" + enunciado + '}';
    }
}
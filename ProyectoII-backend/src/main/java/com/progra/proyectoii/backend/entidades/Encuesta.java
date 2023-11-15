/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.progra.proyectoii.backend.entidades;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import jakarta.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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

@NoArgsConstructor
@AllArgsConstructor
@ToString
@XmlType
@DatabaseTable(tableName = "encuesta")
public class Encuesta implements Serializable {
    
    @Getter
    @Setter
    @DatabaseField(columnName = "id_encuesta", id = true)
    private int id;
    @Getter
    @Setter
    @DatabaseField(columnName = "fecha_creacion")
    private Date fechaCreacion;
    @Getter
    @Setter
    @DatabaseField(columnName = "fecha_inicio")
    private Date fechaInicio;
    @Getter
    @Setter
    @DatabaseField(columnName = "fecha_final")
    private Date fechaFinal;
}

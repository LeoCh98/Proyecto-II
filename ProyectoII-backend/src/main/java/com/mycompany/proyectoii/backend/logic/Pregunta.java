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

package com.mycompany.proyectoii.backend.logic;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import jakarta.xml.bind.annotation.XmlType;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@XmlType
@DatabaseTable(tableName = "pregunta")
public class Pregunta implements Serializable {
    
    @Getter
    @Setter
    @DatabaseField(columnName = "id_pregunta", id = true)
    private int id;
    @Getter
    @Setter
    @DatabaseField(columnName = "id_encuesta_asignada")
    private int idEncuesta;
    @Getter
    @Setter
    @DatabaseField(columnName = "categoria")
    private String categoria;
    @Getter
    @Setter
    @DatabaseField(columnName = "enunciado")
    private String enunciado;
}
package com.mycompany.proyectoii.backend;

import com.mycompany.proyectoii.backend.resources.*;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

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

@ApplicationPath("api")
public class JakartaRestConfiguration extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        HashSet<Class<?>> classes = new HashSet<>();
        classes.add(Respuestas.class);
        classes.add(Preguntas.class);
        classes.add(Encuestas.class);
        /*
        classes.add(Policies.class);
        classes.add(Categories.class);
        classes.add(Coverages.class);
        classes.add(Login.class);
        classes.add(Vehicles.class);
        classes.add(Clients.class);
        */
        return classes;
    } 
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.couchdbexamples;

import com.avbravo.couchdbexamples.ejb.PlanetasFacade;
import com.avbravo.couchdbexamples.entity.Planetas;
import com.couchbase.client.java.document.json.JsonArray;
import com.couchbase.client.java.document.json.JsonObject;

/**
 *
 * @author avbravo
 */
public class Example {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
           // Planetas planetas = new Planetas();
           PlanetasFacade planetasFacade  = new PlanetasFacade();
           Planetas planetas = new Planetas();
           
              JsonObject arthur = JsonObject.create()
            .put("name", "Aristides")
            .put("email", "avbravo@gmail..com")
            .put("interests", JsonArray.from("Java", "Nosql"));
              if(planetasFacade.save(arthur)){
                  System.out.println("Guardador");
              }else{
                  System.out.println("no se guardo "+planetasFacade.getException());
              }
              
        } catch (Exception e) {
            System.out.println("Error() "+e.getLocalizedMessage());
        }
    }

}

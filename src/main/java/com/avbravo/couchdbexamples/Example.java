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
import java.util.Date;

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
          // Planetas planetas = new Planetas("tierra", "Tierra", new Date());
           
           
              JsonObject planeta = JsonObject.create()
            .put("idplaneta", "tierra")
            .put("planeta", "Tierra");
            //.put("fecha", new Date());
//            .put("interests", JsonArray.from("Java", "Nosql"));
              if(planetasFacade.save(planeta)){
                  System.out.println("Guardado");
              }else{
                  System.out.println("no se guardo "+planetasFacade.getException());
              }
              
        } catch (Exception e) {
            System.out.println("Error() "+e.getLocalizedMessage());
        }
    }

}

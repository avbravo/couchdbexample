/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.couchbexamples.entity;



import com.avbravo.jmoordb.anotations.Id;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author avbravo
 */
@Getter
@Setter
public class Planetas {
@Id
    private String idplaneta;
    private String planeta;
   //@Ignore    
 //   private Date fecha;

    public Planetas() {
    }

    public Planetas(String idplaneta, String planeta) {
        this.idplaneta = idplaneta;
        this.planeta = planeta;
       
    }

    @Override
    public String toString() {
        return "Planetas{" + "idplaneta=" + idplaneta + ", planeta=" + planeta + '}';
    }

    

  

    
    
}
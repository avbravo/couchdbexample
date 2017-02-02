/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.couchdbexamples.entity;

import com.avbravo.jmoordb.anotations.Id;
import java.util.Date;
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
    private Date fecha;

    public Planetas() {
    }

    public Planetas(String idplaneta, String planeta, Date fecha) {
        this.idplaneta = idplaneta;
        this.planeta = planeta;
        this.fecha = fecha;
    }

    

    @Override
    public String toString() {
        return "Planetas{" + "idplaneta=" + idplaneta + ", planeta=" + planeta + ", fecha=" + fecha + '}';
    }

    
    
}

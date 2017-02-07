/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.couchdbexamples;

import com.avbravo.couchdbexamples.ejb.PlanetasFacade;
import com.avbravo.couchdbexamples.entity.Planetas;
import java.util.List;
import java.util.Optional;

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

            PlanetasFacade planetasFacade = new PlanetasFacade();
            //   PlanetasDaoImpl p = new PlanetasDaoImpl();

            Planetas planetas = new Planetas();
            find();
        } catch (Exception e) {
            System.out.println("Error() " + e.getLocalizedMessage());
        }
    }

    public static void save() {
        PlanetasFacade planetasFacade = new PlanetasFacade();
        Planetas p1 = new Planetas("jupiter", "Jupiter");
        if (planetasFacade.save(p1)) {
            System.out.println("guardado ");
        } else {
            System.out.println("no se guardo " + planetasFacade.getException());
        }
    }

    public static void findAll() {
        PlanetasFacade planetasFacade = new PlanetasFacade();
        List<Planetas> list = planetasFacade.findAll();
        list.forEach((p) -> {
            System.out.println(p.toString());
        });
    }

    public static void findBy() {
        PlanetasFacade planetasFacade = new PlanetasFacade();
        List<Planetas> list = planetasFacade.findBy("select  * from default where planeta='Marte'");
        list.forEach((p) -> {
            System.out.println(p.toString());
        });
    }

    public static void find() {
        PlanetasFacade planetasFacade = new PlanetasFacade();
        Planetas planetas = new Planetas();
        Optional<Planetas> p2 = planetasFacade.find("select * from default where planeta ='Marte'");

        if (!p2.isPresent()) {
            System.out.println("no hay planetas");
        } else {
            planetas = p2.get();
            System.out.println("el planeta es " + p2.toString());
        }
    }

}

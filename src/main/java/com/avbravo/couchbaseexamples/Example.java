/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.couchbaseexamples;

import com.avbravo.couchbaseexamples.ejb.ContinentesFacade;
import com.avbravo.couchbaseexamples.ejb.PlanetasFacade;
import com.avbravo.couchbexamples.entity.Continentes;
import com.avbravo.couchbexamples.entity.Planetas;
import com.couchbase.client.java.PersistTo;
import com.couchbase.client.java.ReplicateTo;
import com.couchbase.client.java.document.JsonDocument;
import com.couchbase.client.java.document.json.JsonObject;
import com.couchbase.client.java.query.N1qlQuery;
import static com.couchbase.client.java.query.Select.select;
import com.couchbase.client.java.search.SearchQuery;
import com.couchbase.client.java.search.facet.SearchFacet;
import com.couchbase.client.java.search.queries.MatchQuery;
import java.util.ArrayList;
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
//            ContinentesFacade continentesFacade = new ContinentesFacade();
//            PlanetasFacade planetasFacade = new PlanetasFacade();
//            //   PlanetasDaoImpl p = new PlanetasDaoImpl();
//
//            Planetas planetas = new Planetas();
//           
//crearIndiceContinentes();
//crearIndicePlanetas();
           
//findAll();

       //    save();
         // saveJsonObject();
//saveContinentes();
findAllContinentes();


//        deleteAll();
//            find();
//            findById();

//replace();
//upsert();
//upsertReplicate();
//            fullTextSearchMatch();
//saveJsonDocument();
            //    update();
//findN1qlQuery();
            // planetasFacade.disconnect();
        } catch (Exception e) {
            System.out.println("Error() " + e.getLocalizedMessage());
        }
    }

    public static void crearIndiceContinentes(){
                ContinentesFacade continentesFacade = new ContinentesFacade();
                continentesFacade.createPrimaryIndex();
    }
    public static void crearIndicePlanetas(){
                PlanetasFacade planetasFacade = new PlanetasFacade();
                planetasFacade.createPrimaryIndex();
    }
    public static void save() {
        PlanetasFacade planetasFacade = new PlanetasFacade();
        Planetas p1 = new Planetas("jupiter", "Jupiter");
        if (planetasFacade.save(p1, false)) {
            System.out.println("guardado ");
        } else {
            System.out.println("no se guardo " + planetasFacade.getException());
        }
    }

    public static void saveContinentes() {
        PlanetasFacade planetasFacade = new PlanetasFacade();
        ContinentesFacade continentesFacade = new ContinentesFacade();
        Planetas planetas = new Planetas();
        planetas.setIdplaneta("saturno");
        Optional<Planetas> p2 = planetasFacade.findById(planetas);

        if (!p2.isPresent()) {
            System.out.println("no hay planetas "+planetasFacade.getException());
        } else {
        
            Planetas planetas3 = new Planetas();
            planetas3.setIdplaneta("jupiter");
            Optional<Planetas> p3 = planetasFacade.findById(planetas3);
            
            List<Planetas> list = new ArrayList<>();
            list.add(p2.get());
            list.add(p3.get());
            Continentes continentes = new Continentes();
            continentes.setIdcontinente("america");
            continentes.setContinente("America");
            
       //     continentes.setPlanetas(p2.get());
//            continentes.setPlanetas(list);
            if(continentesFacade.save(continentes,false)){
                System.out.println("continente guardado");
            }else{
                System.out.println("no se pudo guardar el continente "+continentesFacade.getException());
            }
           
        }

    }

     public static void findAllContinentes() {
     ContinentesFacade continentesFacade = new ContinentesFacade();
        List<Continentes> list = continentesFacade.findAll();
        list.forEach((p) -> {
            System.out.println(p.toString());
        });
    }
    public static void saveJsonObject() {
        PlanetasFacade planetasFacade = new PlanetasFacade();
        JsonObject planetaJson = JsonObject.empty()
                .put("idplaneta", "saturno")
                .put("planeta", "Saturno");

        if (planetasFacade.save(planetaJson, false)) {
            System.out.println("guardado ");
        } else {
            System.out.println("no se guardo " + planetasFacade.getException());
        }

//planetasFacade.saveQueYaTieneID(doc);
    }

    public static void saveJsonDocument() {
        try {

            PlanetasFacade planetasFacade = new PlanetasFacade();
            JsonObject mercurioJson = JsonObject.create()
                    .put("idplaneta", "mercurio")
                    .put("planeta", "Mercurio");

            JsonDocument doc = JsonDocument.create("mercurio", mercurioJson);

            if (planetasFacade.saveWithPreID(doc)) {
                System.out.println("guardado ");
            } else {
                System.out.println("no se guardo " + planetasFacade.getException());
            }
        } catch (Exception e) {
            System.out.println("saveJsonDocument() " + e.getLocalizedMessage());
        }

    }

    public static void findAll() {
        PlanetasFacade planetasFacade = new PlanetasFacade();
        List<Planetas> list = planetasFacade.findAll();
        if(list.isEmpty()){
            System.out.println("No hay registros de planetas "+planetasFacade.getException());
        }
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

    public static void fullTextSearchMatch() {
        PlanetasFacade planetasFacade = new PlanetasFacade();

        MatchQuery fts = SearchQuery.match("term");

        List<Planetas> list = planetasFacade.fullTexSearch(fts);
        list.forEach((p) -> {
            System.out.println(p.toString());
        });
    }

    public static void fullTextSearchQueryType() {
        PlanetasFacade planetasFacade = new PlanetasFacade();

        MatchQuery fts = SearchQuery.match("term")
                //query options:
                .fuzziness(2).field("content");
        SearchQuery query = new SearchQuery("default", fts)
                //search options:
                //will show value for idplaneta and planeta
                .fields("idplaneta", "planeta")
                //will have max 3 hits
                .limit(3);

        List<Planetas> list = planetasFacade.fullTexSearch(fts);
        list.forEach((p) -> {
            System.out.println(p.toString());
        });
    }

    public static void fullTextSearchQueryFacet() {
        PlanetasFacade planetasFacade = new PlanetasFacade();

        MatchQuery fts = SearchQuery.match("term")
                //query options:
                .fuzziness(2).field("content");
        SearchQuery query = new SearchQuery("travel-search", fts)
                //will have max 3 hits
                .limit(3)
                //will have a "category" facet on the top 3 countries in terms of hits
                .addFacet("planetas", SearchFacet.term("planetas", 3));

        List<Planetas> list = planetasFacade.fullTexSearch(fts);
        list.forEach((p) -> {
            System.out.println(p.toString());
        });
    }

    public static void findN1qlQuery() {

        N1qlQuery query = N1qlQuery
                .simple(select("*")
                        .from("default")
                        .limit(10));

        PlanetasFacade planetasFacade = new PlanetasFacade();
        List<Planetas> list = planetasFacade.findBy(query);
        list.forEach((p) -> {
            System.out.println(p.toString());
        });
    }

    public static void findById() {
        PlanetasFacade planetasFacade = new PlanetasFacade();
        Planetas planetas = new Planetas();
        planetas.setIdplaneta("saturno");
        Optional<Planetas> p2 = planetasFacade.findById(planetas);

        if (!p2.isPresent()) {
            System.out.println("no hay planetas");
        } else {
            planetas = p2.get();
            System.out.println("el planeta es " + p2.toString());
        }
    }

    public static void update() {
        PlanetasFacade planetasFacade = new PlanetasFacade();
        Planetas planetas = new Planetas();
        planetas.setIdplaneta("saturno");
        Optional<Planetas> p2 = planetasFacade.findById(planetas);

        if (!p2.isPresent()) {
            System.out.println("no hay planetas");
        } else {

            planetas = p2.get();
            planetas.setPlaneta("Saturno actualizado");
            if (planetasFacade.update(planetas)) {
                System.out.println("se actualizo");
            } else {
                System.out.println("No se actualizo " + planetasFacade.getException());
            }
        }
    }

    /**
     *
     */
    public static void replace() {
        PlanetasFacade planetasFacade = new PlanetasFacade();
        JsonObject content = JsonObject.empty().put("idplaneta", "saturno")
                .put("planeta", "Saturno replace");
        JsonDocument doc = JsonDocument.create("saturno", content);

        if (planetasFacade.replace(doc)) {
            System.out.println("se reemplazo");
        } else {
            System.out.println("No se reemplazo " + planetasFacade.getException());
        }

    }

    public static void upsert() {
        PlanetasFacade planetasFacade = new PlanetasFacade();
        JsonObject content = JsonObject.empty().put("idplaneta", "saturno")
                .put("planeta", "Saturno ");
        JsonDocument doc = JsonDocument.create("saturno", content);

        if (planetasFacade.upsert(doc)) {
            System.out.println("se reemplazo");
        } else {
            System.out.println("No se reemplazo " + planetasFacade.getException());
        }

    }

    public static void upsertReplicate() {
        PlanetasFacade planetasFacade = new PlanetasFacade();
        JsonObject content = JsonObject.empty().put("idplaneta", "saturno")
                .put("planeta", "Saturno ");
        JsonDocument doc = JsonDocument.create("saturno", content);

        if (planetasFacade.upsert(doc, PersistTo.MASTER, ReplicateTo.TWO)) {
            System.out.println("se reemplazo");
        } else {
            System.out.println("No se reemplazo " + planetasFacade.getException());
        }

    }

    public static void deleteValue() {
        PlanetasFacade planetasFacade = new PlanetasFacade();

        if (planetasFacade.delete("mercurio")) {
            System.out.println("se removio");
        } else {
            System.out.println("no se pudo eliminar " + planetasFacade.getException());
        }

    }

    public static void deleteAll() {
        PlanetasFacade planetasFacade = new PlanetasFacade();

        if (planetasFacade.deleteAll()) {
            System.out.println("se eliminaron todos los documentos");
        } else {
            System.out.println("no se eliminaron todos los documentos " + planetasFacade.getException());
        }

    }

    public static void delete() {
        PlanetasFacade planetasFacade = new PlanetasFacade();
        Planetas planetas = new Planetas();
        planetas.setIdplaneta("saturno");
        Optional<Planetas> p2 = planetasFacade.findById(planetas);

        if (!p2.isPresent()) {
            System.out.println("no hay planetas");
        } else {
            planetas = p2.get();
            if (planetasFacade.delete(planetas)) {
                System.out.println("se removio");
            } else {
                System.out.println("no se pudo eliminar " + planetasFacade.getException());
            }

        }
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

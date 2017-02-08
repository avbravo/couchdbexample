/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.couchbaseexamples;

import com.avbravo.couchbexamples.entity.Planetas;
import flexjson.JSONSerializer;

/**
 *
 * @author avbravo
 */
public class Example11 {

    /**
     * @param args the command line arguments
     */
    public void main() {

        try {
            PlanetasDaoImpl p = new PlanetasDaoImpl();
//   Guardar
//            Planetas p1= new Planetas("tierra", "Tierra");
//            p.insert(p1);
//
//          Planetas p2 = new Planetas("venus", "Venus");
//            p.insert(p2,false);
//            
//             
//             

//  Planetas p3 = new Planetas("tierra", "Tierra");
//             p.insert(p3);




//             //Buscar
//            Planetas psearch  = new Planetas();
//           psearch.setIdplaneta("sol1");
//     
//
//
//            Planetas presultado=   p.get(psearch);
//           System.out.println("p2 "+presultado.toString()); 
//             
//            
//           
//            Planetas presultado2=   p.findByPlaneta("Marte");
//           System.out.println("presultado2 "+presultado2.toString()); 
             
           Planetas s = p.query("select * from default ");
            System.out.println("---> "+s.toString());
           
//            
//           Planetas p3= new Planetas();
//           p3.setIdplaneta("Planetas1");
////         Planetas p2=   p.get(planetas);
////            System.out.println("p2 "+p2.toString());
//         Planetas p2=   p.get(p3);
//            System.out.println("p2 "+p2.toString());
            
            
            
           // Planetas planetas = new Planetas();
//           PlanetasFacade planetasFacade  = new PlanetasFacade();
//          Planetas planetas = new Planetas("jupiter", "Jupiter");
//
//  EntityDocument<Planetas> document = EntityDocument.create(planetas);
//  Repository repo = CouchbaseCluster.create().openBucket().repository();
//  repo.upsert(document);
  
//          
          
          
        //  planetasFacade.findAll("select  * from default");
           
//JsonObject user = JsonObject.empty()
//    .put("idplaneta", "tierra")
//    .put("planeta", "Tierra");
//JsonDocument doc = JsonDocument.create("tierra", user);
//
//planetasFacade.saveQueYaTieneID(doc);


//          
//           
//              JsonObject planeta = JsonObject.create()
//           .put("idplaneta", "jupiter")
//            .put("planeta", "Jupiter");
//            //.put("fecha", new Date());
////            .put("interests", JsonArray.from("Java", "Nosql"));
//              if(planetasFacade.save(planeta)){
//                  System.out.println("Guardado");
//              }else{
//                  System.out.println("no se guardo "+planetasFacade.getException());
//              }
//              
        } catch (Exception e) {
            System.out.println("Error() "+e.getLocalizedMessage());
        }
    }
    
//     public static Planetas insert(Planetas entity) {
//         JSONSerializer serializer = new JSONSerializer();
//    String key = getNextUid( entity.getClassName() );
//    entity.setObjectId(key);
//    String jsonString = serializer.deepSerialize(entity);
//    RawJsonDocument jsonDoc = RawJsonDocument.create(key, jsonString);
//    RawJsonDocument retJsonDoc = db.insert(jsonDoc);
//    Planetas newPlanetas = new JSONDeserializer<Planetas>().deserialize( retJsonDoc.content() , Planetas.class );
//    return newPlanetas;
//}

    
    private void test(){
         JSONSerializer serializer = new JSONSerializer();
//       Cluster cluster = CouchbaseCluster.create("localhost");
//        Bucket bucket = cluster.openBucket("default");
    
           //  String jsonString = serializer.deepSerialize(planetas);
            // System.out.println("to String "+jsonString);
//    RawJsonDocument jsonDocument = RawJsonDocument.create(planetas.getIdplaneta(), jsonString);
//    RawJsonDocument retrievedJsonDocument = bucket.get(jsonDocument);
  //Planetas retrievedPlanetas = new JSONDeserializer<Planetas>().deserialize(retrievedJsonDocument.content(), Planetas.class);
  //Planetas retrievedPlanetas = new JSONDeserializer<Planetas>().deserialize("{default={idplaneta=marte, planeta=Marte}}", Planetas.class);
//            System.out.println("---> "+retrievedPlanetas.getIdplaneta() + "  "+retrievedPlanetas.getPlaneta());
//            System.out.println("retrievedPlanetas ==== "+retrievedPlanetas.toString());
//            System.out.println("============
    }
}

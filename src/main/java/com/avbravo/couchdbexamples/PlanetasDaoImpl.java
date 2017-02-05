/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.couchdbexamples;

import com.avbravo.couchdbexamples.entity.Planetas;
import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.CouchbaseCluster;
import com.couchbase.client.java.document.JsonDocument;
import com.couchbase.client.java.document.JsonLongDocument;
import com.couchbase.client.java.document.RawJsonDocument;
import com.couchbase.client.java.query.N1qlQuery;
import com.couchbase.client.java.query.N1qlQueryResult;
import com.couchbase.client.java.query.N1qlQueryRow;
import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;

/**
 *
 * @author avbravo
 */
public class PlanetasDaoImpl {
     Cluster cluster = CouchbaseCluster.create("localhost");
        Bucket bucket = cluster.openBucket("default");
// Cluster cluster  = CouchBaseManager.getSingleton().cluster;

JSONSerializer serializer = new JSONSerializer();

private String getNextUid(String className ) {
    //String counterName = className + "Counter";
    String counterName = "Counter";
    JsonLongDocument val = bucket.counter(counterName, 1, 1);
    String keyPrefix = className;
    String nextKey = keyPrefix + val.content().longValue();
    return nextKey;
}



public Planetas insert(Planetas entity,Boolean autoincrementable) {
 
//  String key = getNextUid( entity.getClass().getSimpleName());
 String key="";
if(autoincrementable){
    key = getNextUid( entity.getIdplaneta());
}else
{
    key = entity.getIdplaneta();
}
  
 //  String key = entity.getIdplaneta();
    entity.setIdplaneta(key);
    String jsonString = serializer.deepSerialize(entity);
    RawJsonDocument jsonDoc = RawJsonDocument.create(key, jsonString);
    RawJsonDocument retJsonDoc = bucket.insert(jsonDoc);
    Planetas newPlanetas = new JSONDeserializer<Planetas>().deserialize( retJsonDoc.content() , Planetas.class );
    return newPlanetas;
}


public Planetas replace(Planetas entity) {
    String jsonString = serializer.deepSerialize(entity);
    RawJsonDocument jsonDocument = RawJsonDocument.create(entity.getIdplaneta(), jsonString);
    RawJsonDocument replacedJsonDocument = bucket.replace(jsonDocument);
    Planetas replacedPlanetas = new JSONDeserializer<Planetas>().deserialize(replacedJsonDocument.content(), Planetas.class);
    return replacedPlanetas;
}



public Planetas remove(Planetas entity) {
    String jsonString = serializer.deepSerialize(entity);
    RawJsonDocument jsonDocument = RawJsonDocument.create(entity.getIdplaneta(), jsonString);
    RawJsonDocument removedJsonDocument = bucket.remove(jsonDocument);
    Planetas removedPlanetas = new JSONDeserializer<Planetas>().deserialize(removedJsonDocument.content(), Planetas.class);
    return removedPlanetas;
}



public Planetas get(Planetas entity) {
    String jsonString = serializer.deepSerialize(entity);
    RawJsonDocument jsonDocument = RawJsonDocument.create(entity.getIdplaneta(), jsonString);
    RawJsonDocument retrievedJsonDocument = bucket.get(jsonDocument);
    Planetas retrievedPlanetas = new JSONDeserializer<Planetas>().deserialize(retrievedJsonDocument.content(), Planetas.class);
    return retrievedPlanetas;
}
public Planetas query(String statement) {
    Planetas retrievedPlanetas = new Planetas();
    try {
        
   
     N1qlQuery query = N1qlQuery.simple(statement);
     System.out.println("query "+statement);
      N1qlQueryResult result = bucket.query(query);
      if(result == null){
          System.out.println("es null");
      }else{
          System.out.println("no es null");
      }
       
           for (N1qlQueryRow row : result) {
               System.out.println("dentro del for");
               System.out.println("row "+row.value().toString());
             
                 String content=      JsonDocument.create("id",row.value()).toString();
               System.out.println("content "+content);
                    
                   retrievedPlanetas = new JSONDeserializer<Planetas>().deserialize(content, Planetas.class);
                    
           }
     
//    String jsonString = serializer.deepSerialize(entity);
//    RawJsonDocument jsonDocument = RawJsonDocument.create(entity.getIdplaneta(), jsonString);
//    
   
 } catch (Exception e) {
        System.out.println("query() "+e.getLocalizedMessage());
    }
    return retrievedPlanetas;
}


public Planetas get(String uid) {
    Planetas  retrievedPlanetas = new Planetas();
    retrievedPlanetas.setIdplaneta(uid);
    retrievedPlanetas = get( retrievedPlanetas );
    return retrievedPlanetas;
}
public Planetas findByPlaneta(String uid) {
    Planetas  retrievedPlanetas = new Planetas();
    retrievedPlanetas.setPlaneta(uid);
    retrievedPlanetas = get( retrievedPlanetas );
    return retrievedPlanetas;
}



public boolean exists( String key) {
    boolean exists = false;
    JsonDocument jsonDocument = bucket.get(key);
    if(jsonDocument.id().equals(key)) {
        exists = true;
    }
    return exists;
}
}

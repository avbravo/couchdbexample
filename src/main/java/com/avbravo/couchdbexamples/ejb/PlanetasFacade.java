/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.couchdbexamples.ejb;

import com.avbravo.couchdbexamples.entity.Planetas;
import com.avbravo.couchdbexamples.provider.CouchbaseClientProvider;
import com.avbravo.jmoordb.facade.CouchbaseAbstractFacade;
import com.couchbase.client.java.Cluster;
import org.bson.Document;


/**
 *
 * @author avbravo
 */
public class PlanetasFacade extends CouchbaseAbstractFacade<Planetas> {
 CouchbaseClientProvider couchbseclientProvider = new  CouchbaseClientProvider();
    public PlanetasFacade() {
        super(Planetas.class, "default", "planetas");
    }

//    @Override
//    protected Bucket getBucket() {
//       return mongoclientProvider.getMongoClient();
//    }

    @Override
    protected Cluster getCluster() {
    return  couchbseclientProvider.getCluster();
    }

     @Override
    public Object findById(String key, String value) {
        return find(key, value);
    }

    @Override
    public Object findById(String key, Integer value) {
        return find(key, value);
    }

  
   

    

   

  
  

}

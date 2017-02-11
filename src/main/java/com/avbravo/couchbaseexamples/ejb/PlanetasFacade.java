/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.couchbaseexamples.ejb;

import com.avbravo.couchbexamples.entity.Planetas;
import com.avbravo.couchbaseexamples.provider.CouchbaseClientProvider;
import com.avbravo.jmoordb.couchbase.facade.CouchbaseAbstractFacade;
import com.couchbase.client.java.Cluster;
import org.bson.Document;


/**
 *
 * @author avbravo
 */
public class PlanetasFacade extends CouchbaseAbstractFacade<Planetas> {
 CouchbaseClientProvider couchbseclientProvider = new  CouchbaseClientProvider();
    public PlanetasFacade() {
        super(Planetas.class, "planetas", "planetas");
    }

    @Override
    protected Cluster getCluster() {
    return  couchbseclientProvider.getCluster();
    }

     @Override
    public Object findById(String key, String value) {
        return search(key, value);
    }

    @Override
    public Object findById(String key, Integer value) {
        return search(key, value);
    }


}

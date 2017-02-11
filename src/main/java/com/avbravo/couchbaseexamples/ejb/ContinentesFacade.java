/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.couchbaseexamples.ejb;

import com.avbravo.couchbexamples.entity.Continentes;
import com.avbravo.couchbaseexamples.provider.CouchbaseClientProvider;
import com.avbravo.jmoordb.couchbase.facade.CouchbaseAbstractFacade;
import com.couchbase.client.java.Cluster;
import org.bson.Document;


/**
 *
 * @author avbravo
 */
public class ContinentesFacade extends CouchbaseAbstractFacade<Continentes> {
 CouchbaseClientProvider couchbseclientProvider = new  CouchbaseClientProvider();
    public ContinentesFacade() {
        super(Continentes.class, "continentes", "continentes");
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

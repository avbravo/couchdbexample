/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.couchdbexamples.provider;

import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.CouchbaseCluster;
import com.couchbase.client.java.env.CouchbaseEnvironment;
import com.couchbase.client.java.env.DefaultCouchbaseEnvironment;



/**
 *
 * @author avbravo
 */
public class CouchbaseClientProvider {
private Cluster cluster;


    public Cluster getCluster() {
           CouchbaseEnvironment env = DefaultCouchbaseEnvironment.builder()
                    .connectTimeout(10000) //10000ms = 10s, default is 5s
                    .build();
            System.out.println("Create connection");
            cluster = CouchbaseCluster.create("localhost");
        return cluster;
    }
 

}

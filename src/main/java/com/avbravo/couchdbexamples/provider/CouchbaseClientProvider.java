/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.couchdbexamples.provider;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.CouchbaseCluster;



/**
 *
 * @author avbravo
 */
public class CouchbaseClientProvider {
private Cluster cluster = CouchbaseCluster.create("localhost");


    public Cluster getCluster() {
        return cluster;
    }
 

}

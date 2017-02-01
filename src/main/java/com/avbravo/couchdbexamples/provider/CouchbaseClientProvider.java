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
private Bucket bucket = cluster.openBucket("default");
 

    public Bucket getCouchbaseClient() {
   bucket = cluster.openBucket("default");
        try {
            /**
             * autentificacion
             */
            /*
             String database = "";
            String username = "";
            String password = "";
            String host = "localhost";
            int port = 27017;
            char[] charArray = password.toCharArray();
            MongoCredential credential = MongoCredential.createCredential(username, database, charArray);
            mongoClient = new MongoClient(new ServerAddress(host, port), Arrays.asList(credential));
             */
        } catch (Exception e) {
            System.out.println("getMongoClient() " + e.getLocalizedMessage());
        }
        return bucket;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.couchbaseexamples;

import com.avbravo.couchbexamples.entity.Planetas;
import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.CouchbaseCluster;
import com.couchbase.client.java.document.JsonDocument;
import com.couchbase.client.java.document.json.JsonArray;
import com.couchbase.client.java.document.json.JsonObject;
import com.couchbase.client.java.query.N1qlQuery;
import com.couchbase.client.java.query.N1qlQueryResult;
import com.couchbase.client.java.query.N1qlQueryRow;
import flexjson.JSONDeserializer;

/**
 *
 * @author avbravo
 */
public class Example1 {

    /**
     * @param args the command line arguments
     */
    public  void run() {
    Cluster cluster = CouchbaseCluster.create("localhost");
        Bucket bucket = cluster.openBucket("default");
//CouchbaseClientProvider couchbaseClientProvider = new CouchbaseClientProvider() ;

        // Create a JSON Document
        JsonObject arthur = JsonObject.create()
            .put("name", "Arthur")
            .put("email", "kingarthur@couchbase.com")
            .put("interests", JsonArray.from("Holy Grail", "African Swallows"));

        // Store the Document
        bucket.upsert(JsonDocument.create("u:king_arthur", arthur));

        // Load the Document and print it
        // Prints Content and Metadata of the stored Document
        System.out.println(bucket.get("u:king_arthur"));
       JsonDocument doc = bucket.get("u:king_arthur");
        System.out.println("---> doc "+doc.toString());

        // Create a N1QL Primary Index (but ignore if it exists)
        bucket.bucketManager().createN1qlPrimaryIndex(true, false);

        // Perform a N1QL Query
        N1qlQueryResult result = bucket.query(
            N1qlQuery.parameterized("SELECT name,email FROM default WHERE $1 IN interests",
            JsonArray.from("African Swallows"))
        );
        N1qlQueryResult result2 = bucket.query(
            N1qlQuery.simple("SELECT name,email FROM default ")
        );

        // Print each found Row
        for (N1qlQueryRow row : result) {
            // Prints {"name":"Arthur"}
            
            System.out.println(row);
        }
        System.out.println("========================");
        for (N1qlQueryRow row : result2) {
            // Prints {"name":"Arthur"}
            System.out.println(row);
        }
        
        
    }
   
    
}

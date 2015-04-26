package com.atrakeur.web.restserver.db;

import com.mongodb.*;

import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * Created by Valentin on 26/04/2015.
 */
public class MongoDB {

    private MongoClient mongoClient;

    /**
     * Retrieve MongoDB database collection
     *
     * @return the collection of the mongodb database
     * @throws UnknownHostException when the database can't be found
     */
    public DBCollection getCollection(String collection) throws UnknownHostException {
        this.openDatabase();

        DB db = mongoClient.getDB("cv");
        if (!db.collectionExists(collection)) {
            db.createCollection(collection, null);
        }

        return db.getCollection("cv");
    }

    public void openDatabase() {
        if (mongoClient == null) {
            String host = System.getenv("OPENSHIFT_MONGODB_DB_HOST");
            String port = System.getenv("OPENSHIFT_MONGODB_DB_PORT");
            String username = "admin";
            String password = System.getenv("OPENSHIFT_MONGODB_DB_PASSWORD");

            MongoCredential credential = MongoCredential.createCredential(username, "cv", password.toCharArray());

            try {
                mongoClient = new MongoClient(
                        new ServerAddress(host, Integer.parseInt(port)),
                        Arrays.asList(credential)
                );
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
        }
    }

    public void forceClose() {
        if (mongoClient != null) {
            mongoClient.close();;
            mongoClient = null;
        }
    }
}

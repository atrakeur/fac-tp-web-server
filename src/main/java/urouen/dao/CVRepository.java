package urouen.dao;

import com.google.gson.Gson;
import com.mongodb.*;
import com.mongodb.util.JSON;
import urouen.model.CV;
import urouen.model.CVList;

import java.net.UnknownHostException;
import java.util.Arrays;

public class CVRepository {

    public CVList getAll() {
        CVList list = new CVList();
        DBCollection collection = null;
        DBCursor cursor = null;
        try {
            collection = getDatabase();
            cursor = collection.find();

            while (cursor.hasNext()) {
                DBObject retrieved = cursor.next();
                CVDao cvDao = new Gson().fromJson(retrieved.toString(), CVDao.class);
                cvDao.setId(retrieved.get("_id").toString());
                list.getListCV().add(cvDao.toCV());
            }

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } finally {
            cursor.close();
        }

        return list;
    }

    public CV get(String hash) {
        DBCollection collection = null;
        DBCursor cursor = null;
        try {
            collection = getDatabase();
            BasicDBObject query = new BasicDBObject("_id", hash);
            cursor = collection.find(query);

            while (cursor.hasNext()) {
                DBObject retrieved = cursor.next();
                CVDao cvDao = new Gson().fromJson(retrieved.toString(), CVDao.class);
                cvDao.setId(retrieved.get("_id").toString());
                return cvDao.toCV();
            }

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } finally {
            cursor.close();
        }

        return null;
    }

    public CV add(CV cvEntry) {
        DBCollection collection = null;
        try {
            collection = getDatabase();
            CVDao cvDao = new CVDao(cvEntry);
            DBObject dbObject = (DBObject) JSON.parse(new Gson().toJson(cvDao));
            WriteResult retVal = collection.insert(dbObject);
            //cvEntry.setId(retVal.getUpsertedId().toString());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        return cvEntry;
    }

    /**
     * Retrieve MongoDB database collection
     *
     * @return the collection of the mongodb database
     * @throws UnknownHostException when the database can't be found
     */
    private DBCollection getDatabase() throws UnknownHostException {
        String host = System.getenv("OPENSHIFT_MONGODB_DB_HOST");
        String port = System.getenv("OPENSHIFT_MONGODB_DB_PORT");
        String username = "admin";
        String password = "GBWyuxW2Atp3";

        MongoCredential credential = MongoCredential.createCredential(username, "cv", password.toCharArray());

        MongoClient mongoClient = new MongoClient(
                new ServerAddress(host, Integer.parseInt(port)),
                Arrays.asList(credential)
        );

        DB db = mongoClient.getDB("cv");
        if (!db.collectionExists("cv")) {
            db.createCollection("cv", null);
        }

        return db.getCollection("cv");
    }

}

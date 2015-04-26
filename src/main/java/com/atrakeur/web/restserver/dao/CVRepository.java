package com.atrakeur.web.restserver.dao;

import com.atrakeur.web.restserver.db.MongoDB;
import com.google.gson.Gson;
import com.mongodb.*;
import com.mongodb.util.JSON;
import org.bson.types.ObjectId;
import com.atrakeur.web.restserver.model.CV;
import com.atrakeur.web.restserver.model.CVList;

import java.net.UnknownHostException;
import java.util.Arrays;

public class CVRepository {

    public CVList getAll() {
        CVList list = new CVList();
        DBCollection collection = null;
        DBCursor cursor = null;
        MongoDB db = new MongoDB();
        try {
            collection = db.getCollection("cv");
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
            db.forceClose();
        }

        return list;
    }

    public CV get(String hash) {
        DBCollection collection = null;
        DBCursor cursor = null;
        MongoDB db = new MongoDB();
        try {
            collection = db.getCollection("cv");
            BasicDBObject query = new BasicDBObject();
            query.put("_id", new ObjectId(hash));
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
            db.forceClose();
        }

        return null;
    }


    public CV delete(String hash) {
        DBCollection collection = null;
        DBCursor cursor = null;
        MongoDB db = new MongoDB();
        try {
            collection = db.getCollection("cv");
            BasicDBObject query = new BasicDBObject();
            query.put("_id", new ObjectId(hash));
            cursor = collection.find(query);

            while (cursor.hasNext()) {
                DBObject retrieved = cursor.next();
                CVDao cvDao = new Gson().fromJson(retrieved.toString(), CVDao.class);
                cvDao.setId(retrieved.get("_id").toString());
                collection.remove(retrieved);
                return cvDao.toCV();
            }

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } finally {
            cursor.close();
            db.forceClose();
        }

        return null;
    }

    public CV add(CV cvEntry) {
        DBCollection collection = null;
        MongoDB db = new MongoDB();
        try {
            collection = db.getCollection("cv");
            CVDao cvDao = new CVDao(cvEntry);
            DBObject dbObject = (DBObject) JSON.parse(new Gson().toJson(cvDao));
            collection.insert(dbObject);
            cvEntry.setId(dbObject.get("_id").toString());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } finally {
            db.forceClose();
        }

        return cvEntry;
    }

}

package com.mkyong.core;

import java.net.UnknownHostException;
import java.util.Date;
import java.util.ArrayList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;

/**
 * Java + MongoDB Hello world Example
 * 
 */
public class App {
	public static void main(String[] args) {

		try {

			/**** Connect to MongoDB ****/
			// Since 2.10.0, uses MongoClient
			MongoClient mongo = new MongoClient("localhost", 27017);

			/**** Get database ****/
			// if database doesn't exists, MongoDB will create it for you
			DB db = mongo.getDB("cars");

			ArrayList<Sensor> sensors = new ArrayList<Sensor>();
			/**** Get collection / table from 'testdb' ****/
			// if collection doesn't exists, MongoDB will create it for you
			DBCollection table = db.getCollection("Sensor");

			/**** Insert ****/
			// create a document to store key and value
			BasicDBObject document = new BasicDBObject();
			document.put("ID", "1");
			document.put("NAME", "aghiles");
			document.put("INTERVALL", "3");
			table.insert(document);

			DBCursor cursor = table.find();

			while(cursor.hasNext()){
				DBObject result = cursor.next();
				Sensor sensor = new Sensor();
				sensor.id = (String)result.get("ID");
				sensor.name = (String)result.get("NAME");
				sensor.interval = (String)result.get("INTERVALL");
				sensors.add(sensor);
			}

		System.out.println(sensors);

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (MongoException e) {
			e.printStackTrace();
		}

	}
}

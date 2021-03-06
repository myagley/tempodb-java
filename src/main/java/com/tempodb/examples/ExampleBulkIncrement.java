package com.tempodb.examples;

import java.util.ArrayList;

import org.joda.time.DateTime;

import com.tempodb.client.Client;
import com.tempodb.client.ClientBuilder;
import com.tempodb.models.BulkDataSet;
import com.tempodb.models.BulkPoint;
import com.tempodb.models.BulkIdPoint;
import com.tempodb.models.BulkKeyPoint;


public class ExampleBulkIncrement {

    public static void main(String[] args) throws Exception {
        Client client = new ClientBuilder()
            .key("your-api-key")
            .secret("your-api-secret")
            .build();

        DateTime ts = new DateTime(2012, 7, 4, 15, 2, 0, 0);

        ArrayList<BulkPoint> points = new ArrayList<BulkPoint>();
        points.add(new BulkKeyPoint("increment.java.1", 123.6));
        points.add(new BulkKeyPoint("increment.java.2", 3.4));

        BulkDataSet dataset = new BulkDataSet(ts, points);
        client.bulkWrite(dataset);
    }
}

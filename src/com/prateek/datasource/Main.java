package com.prateek.datasource;

import com.prateek.client.DataClient;
import com.prateek.client.RelativePosition;

public class Main {

    public static void main(String[] args) {
        DataSource dataSource = new DataSource();
        DataClient dataClient = new DataClient(dataSource);

        dataSource.add("a", 1);
        dataSource.add("b", 3);
        dataSource.add("c", 20);
        dataSource.add("d", 30);
        dataSource.add("e", 75);

        dataClient.displayItems();

        dataClient.reshuffle(4, RelativePosition.BEFORE, 2);

        dataClient.displayItems();
    }
}

package com.prateek.client;

import com.prateek.datasource.DataSource;
import com.prateek.shared.Item;

import java.util.*;

/**
 * Created by prateek.gupta on 16/02/17.
 */
public class DataClient {
    private final DataSource dataSource;

    public DataClient(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * Prints and returns the items in the order they should be displayed. This is determined by the displayOrder field of each item.
     * @return the list of items in the order they should be displayed.
     */
    public List<Item> displayItems(){
        Set<Item> items = dataSource.getItems();

        new ArrayList<>(items).forEach(System.out::println);

        //todo : complete the implementation to print and return the list of items. The items should be printed with a corresponding sequence no. 1, 2, 3 and so on.
        //todo : e.g.,       1 [ id: "a", displayOrder: 1]
        //todo :             2 [ id: "b", displayOrder: 3]
        //todo :             3 [ id: "c", displayOrder: 20]
        //todo :             4 [ id: "d", displayOrder: 30]
        //todo :             5 [ id: "e", displayOrder: 75]
        return new ArrayList<>();
    }

    public void reshuffle(int sourcePosition, RelativePosition relative, int position){

        //todo: put logic to create what alteration is required to perform the shift
        //todo : e.g., if in the following case
        //todo : e.g.,       1 [ id: "a", displayOrder: 1]
        //todo :             2 [ id: "b", displayOrder: 3]
        //todo :             3 [ id: "c", displayOrder: 20]
        //todo :             4 [ id: "d", displayOrder: 30]
        //todo :             5 [ id: "e", displayOrder: 75]
        //todo :
        //todo :   if input is
        //todo :            sourcePosition = 4,
        //todo :            relative = BEFORE,
        //todo :            position = 2
        //todo :
        //todo :   then the call to dataSource.shuffle should contain the follwing map in args
        //todo :
        //todo :            "b" -> 20,
        //todo :            "c" -> 30,
        //todo :            "d" -> 3
        //todo :
        //todo :  and a subsequent call to displayItems should print this
        //todo :
        //todo :             1 [ id: "a", displayOrder: 1]
        //todo :             2 [ id: "d", displayOrder: 3]
        //todo :             3 [ id: "b", displayOrder: 20]
        //todo :             4 [ id: "c", displayOrder: 30]
        //todo :             5 [ id: "e", displayOrder: 75]
        //todo :
        //todo :

        Map<String, Integer> inputToShuffle = new HashMap<>();
        dataSource.reshuffle(inputToShuffle);
    }


}

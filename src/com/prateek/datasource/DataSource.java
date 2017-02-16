package com.prateek.datasource;

import com.prateek.shared.Item;

import java.util.*;


/**
 * Created by prateek.gupta on 16/02/17.
 */
public class DataSource {
    private Map<String, Integer> data = new HashMap<>();
    private Map<Integer, String> invertedData = new HashMap<>();

    public DataSource() {
    }

    void addItem (Item item){
        data.put(item.id, item.displayOrder);
        invertedData.put(item.displayOrder, item.id);
    }

    void add(String id, int displayOrder){
        addItem(new Item(id, displayOrder));
    }

    void addNew (int displayOrder){
        Item item = new Item(UUID.randomUUID().toString(), displayOrder);
        addItem(item);
    }

    public Set<Item> getItems (){
        Set<Item> setToReturn = new HashSet<>();
        for (Map.Entry<String, Integer> each : data.entrySet()) {
            setToReturn.add(new Item(each.getKey(), each.getValue()));
        }
        return setToReturn;
    }

    public void reshuffle (Map<String, Integer> itemsToShuffle){
        if(new HashSet<>(itemsToShuffle.values()).size() != itemsToShuffle.entrySet().size()){
            throw new IllegalArgumentException("Duplicate displayOrder is not allowed.");
        }

        for (Map.Entry<String, Integer> eachItemToShuffle : itemsToShuffle.entrySet()) {
            if(data.get(eachItemToShuffle.getKey()) != null && invertedData.get(eachItemToShuffle.getValue()) != null){
                data.put(eachItemToShuffle.getKey(), eachItemToShuffle.getValue());
                invertedData.put(eachItemToShuffle.getValue(), eachItemToShuffle.getKey());
            }
            else{
                throw new IllegalArgumentException("No item found for key " + eachItemToShuffle.getKey());
            }
        }

        for (Map.Entry<String, Integer> each : data.entrySet()) {
            if(each.getKey().equals(invertedData.get(each.getValue())) == false)
                throw new IllegalArgumentException("the shuffling causes the data to be in a corrupt state. Are you sure you didn't modify the data ?");
        }
    }

}

package com.prateek.shared;

/**
 * Created by prateek.gupta on 16/02/17.
 */
public class Item {
    public String id;
    public int displayOrder;

    public Item(String id, int displayOrder) {
        this.id = id;
        this.displayOrder = displayOrder;
    }

    public Item (Item item){
        this(item.id, item.displayOrder);
    }

    @Override
    public int hashCode() {
        return id.hashCode() * 51 + displayOrder;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj) && this.id.equals(((Item)obj).id) && this.displayOrder == ((Item)obj).displayOrder;
    }

    @Override
    public String toString() {
        return "[ id: '" +
                id +
                "', displayOrder: " +
                displayOrder +
                "]";
    }
}

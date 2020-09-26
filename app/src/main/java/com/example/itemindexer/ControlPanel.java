package com.example.itemindexer;

import java.util.ArrayList;

public class ControlPanel {

    static private ArrayList<Item> itemStorage = new ArrayList<>();

    public static void addItem(Item i) {
        itemStorage.add(i);
    }

    public static void search(Tag tag) {

        ArrayList<Item> highlightedItems = new ArrayList<Item>();

        for (int i = 0; i < itemStorage.size(); i++) {
            if ((itemStorage.get(i)).getTag(tag)) {
                highlightedItems.add(itemStorage.get(i));
                // A mechanism to display the image
                // and then a mechanism to display the tags, check marked
            }
        }
    }

    public static ArrayList<Item> getItemStorage(){
        return itemStorage;
    }

}

package com.example.itemindexer;

import java.util.ArrayList;

public class ControlPanel {

    private ArrayList<Item> itemStorage;

    public void addItem() {
        Item i = new Item();
        // Something with the UI in which we check boxes in order to categorize
        // If check box -> setTag(t)
        itemStorage.add(i);
    }

    public void search(Tag tag) {

        ArrayList<Item> highlightedItems = new ArrayList<Item>();

        for (int i = 0; i < itemStorage.size(); i++) {
            if ((itemStorage.get(i)).getTag(tag)) {
                highlightedItems.add(itemStorage.get(i));
                // A mechanism to display the image
                // and then a mechanism to display the tags, check marked
            }
        }


    }

}

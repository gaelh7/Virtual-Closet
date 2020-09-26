package com.example.itemindexer;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.stream;

import java.util.ArrayList;



public class ControlPanel {

    static private ArrayList<Item> itemStorage = new ArrayList<>();

    public static void addItem(Item i) {
        itemStorage.add(i);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void search(Tag tag) {

        boolean[] selectedTags = new boolean[Tag.NUMTAGS.ordinal()];
        selectedTags = [// Input from the user];

        ArrayList<Item> highlightedItems = itemStorage.stream().filter{ t -> t.matchTags(selectedTags) }.collect(Collectors.toList());

        for (int i = 0; i < highlightedItems.size(); i++) {
            // Display highlightedItems.get(i)
            // We should probably assign each item the same path variable that allows us to access the image
        }

        /* Old code
        ArrayList<Item> highlightedItems = new ArrayList<Item>();

        for (int i = 0; i < itemStorage.size(); i++) {
            if ((itemStorage.get(i)).getTag(tag)) {
                highlightedItems.add(itemStorage.get(i));
                // A mechanism to display the image
                // and then a mechanism to display the tags, check marked
            }
        }

        */
    }

    public static ArrayList<Item> getItemStorage(){
        return itemStorage;
    }



}

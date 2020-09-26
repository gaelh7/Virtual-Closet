package com.example.itemindexer;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.List;

import java.util.ArrayList;
import java.util.stream.Collectors;


public class ControlPanel {

    static private ArrayList<Item> itemStorage = new ArrayList<>();

    public static void addItem(Item i) {
        itemStorage.add(i);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static List<Item> search(boolean[] selectedTags) {
        List<Item> highlightedItems = itemStorage.stream().filter(t -> t.matchTags(selectedTags) ).collect(Collectors.toList());

        return highlightedItems;
    }

    public static ArrayList<Item> getItemStorage(){
        return itemStorage;
    }



}

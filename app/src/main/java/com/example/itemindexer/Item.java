package com.example.itemindexer;

public class Item {
    enum Tag{
        ACTIVEWEAR, DRESSES, JACKETS, COATS, JEANS,
        JUMPSUITS, LINGERIE, PANTS, SHORTS, SKIRTS,
        SWEATERS, SWIMWEAR, TOPS, SUITS, BLAZERS, UNDERWEAR,
        LOUNGEWEAR, NUMTAGS
    }

    private boolean[] tags;
    private Image im;

    //@ Precondition length(tags) == NUMTAGS
    public Item(boolean[] tags){
        this.tags = tags; // Maybe copy
    }

    public boolean getTag(Tag t){
        return tags[t.ordinal()];
    }
}

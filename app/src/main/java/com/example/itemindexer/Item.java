package com.example.itemindexer;

enum Tag{
    ACTIVEWEAR, DRESSES, JACKETS, COATS, JEANS,
    JUMPSUITS, LINGERIE, PANTS, SHORTS, SKIRTS,
    SWEATERS, SWIMWEAR, TOPS, SUITS, BLAZERS, UNDERWEAR,
    LOUNGEWEAR, NUMTAGS
}

public class Item {

    private boolean[] tags;
    private String name;
    private Image im;

    //@ Precondition length(tags) == NUMTAGS
    public Item(){
        this.tags = tags; // Maybe copy
    }

    public boolean getTag(Tag t){
        return tags[t.ordinal()];
    }

    public void setTagTrue(Tag t) { tags[t.ordinal()] = true; }

    public void setTagFalse(Tag t) { tags[t.ordinal()] = false; }

}

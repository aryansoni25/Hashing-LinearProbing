package org.studyeasy;

public class Main {
    public static void main(String[] args) {
        LinearProbing lp=new LinearProbing(13);
        lp.insertInHashtable("The");
        lp.insertInHashtable("Quick");
        lp.insertInHashtable("brown");
        lp.insertInHashtable("fox");
        lp.insertInHashtable("over");
        lp.searchHashtable("over");
        lp.deleteKeyHashtable("over");
        lp.displayHashTable();
    }
}
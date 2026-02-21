package org.studyeasy;

public class Main {
    public static void main(String[] args) {
        LinearProbing l=new LinearProbing(13);
        l.insertInHashtable("The");
        l.insertInHashtable("Quick");
        l.insertInHashtable("brown");
        l.insertInHashtable("fox");
        l.searchHashtable("over");
        l.deleteKeyHashtable("over");
        l.displayHashTable();
    }
}
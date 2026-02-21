  package org.studyeasy;

import java.util.ArrayList;  
public class LinearProbing {
    String[] hashTable;
    int usedCellNumber;

    LinearProbing(int size){
        hashTable=new String[size];
        usedCellNumber=0;
    }

    public int modASCII(String word,int M){
        char ch[];
        ch=word.toCharArray();
        int i,sum;
        for( sum=0,i=0;i<word.length();i++){
            sum=sum+ch[i];
        }
        return sum%M;
    }

    public double loadFactor(){
        double loadFactor=usedCellNumber*1.0/hashTable.length;
        return loadFactor;
    }

    public void rehashKey(String word){
        ArrayList<String> data=new ArrayList<>();
        for(String s:hashTable){
            if(s!=null){
                data.add(s);
            }
            data.add(word);
            hashTable=new String[hashTable.length*2];
            for(String d:data){
                insertInHashtable(d);
            }
        }
    }

    public void insertInHashtable(String word){
        double loadFactor=loadFactor();
        if(loadFactor>=0.75){
            rehashKey(word);
        }else{
            int index=modASCII(word,hashTable.length);
            for(int i=index;i<index+hashTable.length;i++){
                int newIndex=i%hashTable.length;
                if(hashTable[newIndex]==null){
                    hashTable[newIndex]=word;
                    System.out.println("The word "+word+" successfully inserted at the location: "+newIndex);
                    break;
                }else {
                    System.out.println(newIndex+" is already occupied .Trying next empty cell");
                }
            }
        }
        usedCellNumber++;
    }


    public void displayHashTable(){
        if(hashTable==null){
            System.out.println("The Hashtable does not exists ");
        }else{
            System.out.println("\n-------------Hashtable------------");
            for(int i=0;i<hashTable.length;i++){
                System.out.println("Index: "+i+",Key: "+hashTable[i]);
            }
        }
    }

    public boolean searchHashtable(String word){
        int index=modASCII(word,hashTable.length);
        for(int i=0;i<index+hashTable.length;i++){
            int newIndex= i%hashTable.length;
            if(hashTable[newIndex]!=null && hashTable[newIndex].equals(word)){
                System.out.println(word+" found at the location: "+newIndex);
                return true;
            }
        }
        System.out.println(word+" not found in the HashTable.");
        return false;
    }

    public void deleteKeyHashtable(String word){
        int index=modASCII(word,hashTable.length);
        for(int i=0;i<index+hashTable.length;i++){
            int newIndex= i%hashTable.length;
            if(hashTable[newIndex]!=null && hashTable[newIndex].equals(word)){
                hashTable[newIndex]=null;
                System.out.println(word+" is deleted from  the HashTable.");

            }
        }
        System.out.println(word+" not found in the HashTable.");
    }
}

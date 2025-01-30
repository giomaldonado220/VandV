package org.example;

public class ArraySet {

    int[] theSet = null;

    int theSize;
    public ArraySet(int dimension){
        theSet = new int[dimension];
        theSize = 0;
    }


    public int getSize(){
        return theSize;
    }

    public int[] getArray(){
        return theSet;
    }

    public boolean contains(int n){
        int index = 0;
        while (index < getSize() && getArray()[index] != n){
            index++;
        }
        if (index == theSize){
            return false;
        }
        return true;
    }

    public void add(int n){
        if (!contains(n)) {
            getArray()[getSize()] = n;
            theSize++;
        }
    }

    public void remove(int n){
        int index = 0;
        while (index < getSize() && getArray()[index] != n){
            index++;
        }
        if (index < getSize()) {
            for (int i = index; i < getSize(); i++) {
                getArray()[i] = getArray()[i + 1];
            }
            theSize--;
        }
    }

}

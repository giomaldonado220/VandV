package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// Do at least 2 tests each

public class AvlTreeTests {


    int howManyTimesInserting = 40;

    /**
     *keeps on adding higher and higher node values until how many times inserting is reached
     * since its parameterized it runs it the different ints given for incrementation
     * @param incrementingValue what number are you incrementing the added node by
     */
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    void keepInsertingSmaller(int incrementingValue) {
        AvlTree avlTree = new AvlTree();
        int valueToInsert = 0;

        for (int i = 0; i < howManyTimesInserting; i++ ) {
            avlTree.insert(avlTree, valueToInsert);
            valueToInsert += incrementingValue;

        }
        assertTrue(avlTree.repOK_Concrete(avlTree));
        //repoOk_Concrete checks ordering and structure
        //assertTrue(avlTree.repOK_Ordered(avlTree));
        //assertTrue(avlTree.repOK_Structure(avlTree));
        assertTrue(avlTree.repOK_Concrete(avlTree));
        //It seems that the tree has a limit of branch size "LIMIT"
        //and this version of repo concrete also checks that
    }



    /**
     *keeps on adding lower and lower node values until how many times inserting is reached
     * since its parameterized it runs it the different ints given for decrementation (down)
     * @param incrementingValue what number are you incrementing the added node by
     */
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    void keepInsertingLarger(int incrementingValue) {
        AvlTree avlTree = new AvlTree();
        int valueToInsert = 0;

        for (int i = 0; i < howManyTimesInserting; i++) {
            avlTree.insert(avlTree, valueToInsert);
            valueToInsert -= incrementingValue;
        }

        assertTrue(avlTree.repOK_ConcretePost(avlTree));

        assertTrue(avlTree.repOK_Concrete(avlTree));

    }

    /**
     * Keeps on adding the same value over and over to the tree and checks if its
     * still follows all its rules after
     * @param valueToInsert which value to keep on inserting in the tree
     */
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    void keepInsertingEqual(int valueToInsert) {
        AvlTree avlTree = new AvlTree();

        for (int i = 0; i < howManyTimesInserting;i++) {
            avlTree.insert(avlTree, valueToInsert);
        }
        assertTrue(avlTree.repOK_Concrete(avlTree));
        assertTrue(avlTree.repOK_ConcretePost(avlTree));
    }


}




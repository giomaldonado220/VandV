package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.Test;
import java.util.Random;
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

    /**
    FR
    Insert duplicate elements 10 and 10 and ensures that duplicate insertions do not
    modify the tree meaning left and right should remain null.
    */
    @Test
    void insertDuplicateValues(){
        AvlTree tree = new AvlTree();
        //duplicate insert of value 10
        tree = tree.insert(tree,10);
        tree = tree.insert(tree,10);
        assertNotNull(tree, "the tree is not null after insert");
        assertEquals(10, tree.element, "root should be 10");
        assertNull(tree.left, "left should be null");
        assertNull(tree.right, "right should be null");

    }
    /**
    FR
    We insert values in descending order and ensure the AVL tree maintains balance
    by doing left rotation.
     */
    @Test
    void insertDesendingUnbalancedValues(){
        AvlTree tree = new AvlTree();
        tree = tree.insert(tree,5);
        tree = tree.insert(tree,3);
        tree = tree.insert(tree,1);
        assertEquals(3, tree.element, "root should be rotated t0 3");
        assertEquals(1, tree.left.element, "left child should be 1");
        assertEquals(5, tree.right.element, "right child should be 5");
        assertEquals(2, tree.height, "height should be correct");

    }

}




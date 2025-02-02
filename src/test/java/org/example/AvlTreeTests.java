/*
Authors:
Giovanni Maldonado
Derek Gamboa
Franz Reyes
 */
package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.Test;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;


public class AvlTreeTests {
    private AvlTree tree;

    @BeforeEach
    public void setUp() {
        tree = new AvlTree();
    }


    int howManyTimesInserting = 40;

    /**
     *keeps on adding higher and higher node values until how many times inserting is reached
     * since its parameterized it runs it the different ints given for incrementation
     * @param incrementingValue what number are you incrementing the added node by
     */
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    void keepInsertingSmaller(int incrementingValue) {
        int valueToInsert = 0;

        for (int i = 0; i < howManyTimesInserting; i++ ) {
            tree.insert(tree, valueToInsert);
            valueToInsert += incrementingValue;

        }
        assertTrue(tree.repOK_Concrete(tree));
        //repoOk_Concrete checks ordering and structure
        //assertTrue(avlTree.repOK_Ordered(avlTree));
        //assertTrue(avlTree.repOK_Structure(avlTree));
        assertTrue(tree.repOK_Concrete(tree));
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
        int valueToInsert = 0;

        for (int i = 0; i < howManyTimesInserting; i++) {
            tree.insert(tree, valueToInsert);
            valueToInsert -= incrementingValue;
        }

        assertTrue(tree.repOK_ConcretePost(tree));

        assertTrue(tree.repOK_Concrete(tree));

    }

    /**
     * Keeps on adding the same value over and over to the tree and checks if its
     * still follows all its rules after
     * @param valueToInsert which value to keep on inserting in the tree
     */
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    void keepInsertingEqual(int valueToInsert) {

        for (int i = 0; i < howManyTimesInserting;i++) {
            tree.insert(tree, valueToInsert);
        }
        assertTrue(tree.repOK_Concrete(tree));
        assertTrue(tree.repOK_ConcretePost(tree));
    }

    /**
    Insert duplicate elements 10 and 10 and ensures that duplicate insertions do not
    modify the tree meaning left and right should remain null.
    */
    @Test
    void insertDuplicateValues(){
        //duplicate insert of value 10
        tree = tree.insert(tree,10);
        tree = tree.insert(tree,10);
        assertNotNull(tree, "the tree is not null after insert");
        assertEquals(10, tree.element, "root should be 10");
        assertNull(tree.left, "left should be null");
        assertNull(tree.right, "right should be null");

    }
    /**
    We insert values in descending order and ensure the AVL tree maintains balance
    by doing left rotation.
     */
    @Test
    void insertDesendingUnbalancedValues(){
        tree = tree.insert(tree,5);
        tree = tree.insert(tree,3);
        tree = tree.insert(tree,1);
        assertEquals(3, tree.element, "root should be rotated t0 3");
        assertEquals(1, tree.left.element, "left child should be 1");
        assertEquals(5, tree.right.element, "right child should be 5");
        assertEquals(2, tree.height, "height should be correct");

    }


    @Test
    void testRandomInsertions(){
        Random random = new Random(30);
        int numInsertions = 30;

        for(int i = 0; i < numInsertions; i++){
            int randomInt = random.nextInt();
            tree.insert(tree, randomInt);
        }
        assertTrue(tree.repOK_ConcretePost(tree));
        assertTrue(tree.repOK_Concrete(tree));
    }

    @Test
    void testAVLBalanceAfterInsertions() {
        tree = tree.insert(tree, 50);
        tree = tree.insert(tree, 40);
        tree = tree.insert(tree, 45);
        tree = tree.insert(tree, 60);
        tree = tree.insert(tree, 70);
        tree = tree.insert(tree, 30);
        tree = tree.insert(tree, 35);
        tree = tree.insert(tree, 80);
        tree = tree.insert(tree, 5);

        assertTrue(tree.repOK_Structure(tree));

        int numNodes = 9;
        int height = (int)(Math.log(numNodes)/ Math.log(2));


        // Checks AVL balance property
    }

}

































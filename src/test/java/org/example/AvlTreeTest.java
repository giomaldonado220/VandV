package org.example;
import java.util.Random;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class AvlTreeTest {
    private AvlTree tree;
    @BeforeEach
    public void setUp(){
        tree = new AvlTree();
    }

    @Test
    public void testAVLBalanceAfterInsertions() {
        tree.insert(tree, 10);
        tree.insert(tree, 5);
        tree.insert(tree, 15);
        tree.insert(tree, 3);
        tree.insert(tree, 7);
        tree.insert(tree, 13);
        tree.insert(tree, 17);

        assertTrue(tree.repOK_Structure(tree)); // Checks AVL balance property
    }

    @Test
    public void testRandomInsertions(){
        Random random = new random(30);
        int numInsertions = 30;
        int min = -100;
        int max = 100;

        for(int i = 0; i < numInsertions; i++){
            int randomInt = random.nextInt();
            tree.insert(avlTree, randomInt);
        }
    }

    public void testInsertions(){
        tree.insert(tree, 50);
        tree.insert(tree, 40);
        tree.insert(tree, 45);
        tree.insert(tree, 60);
        tree.insert(tree, 70);
        tree.insert(tree, 30);
        tree.insert(tree, 35);
        tree.insert(tree, 80);
        tree.insert(tree, 5);

        assertTrue(tree.repOK_Structure(tree));

        int numNodes = 9;
        int H
        int height = (int)(Math.log(numNodes)/Math.log(2));

        assertTrue(tree.height == height);
        assertEquals(45, tree.element);
    }
        
        
        
        
}

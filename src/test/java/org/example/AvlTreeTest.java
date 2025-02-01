package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AvlTreeTest {

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
}

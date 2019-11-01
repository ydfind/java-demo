package com.ydfind.datastructure.avl;

import com.ydfind.datastructure.tree.MyRedBlackTree;
import org.junit.Test;

public class RedBlackTreeTest {

    @Test
    public void testInsert(){
        MyRedBlackTree redBlackTree = new MyRedBlackTree();
        int[] items = {10, 85, 15, 70, 20, 60, 30, 50, 65, 80, 90, 40, 5, 55};
        for(int item: items) {
            redBlackTree.insert(item);
        }
        redBlackTree.printTree();
        System.out.print("\n");
    }
}

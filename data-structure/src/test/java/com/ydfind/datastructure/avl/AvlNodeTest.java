package com.ydfind.datastructure.avl;

import org.junit.Test;

import java.util.Objects;

/**
 * avl树测试
 * @author ydifnd
 * @date 2019.10.30
 */
public class AvlNodeTest {


    /**
     * 树的中序遍历
     * @param node
     */
    public void printTree(AvlNode node){
        System.out.print(node.getData());
        if(Objects.nonNull(node.getLeft()) || Objects.nonNull(node.getRight())) {
            System.out.print("(");
            if (Objects.nonNull(node.getLeft())) {
                printTree(node.getLeft());
            }
            System.out.print(",");
            if (Objects.nonNull(node.getRight())) {
                printTree(node.getRight());
            }
            System.out.print(")");
        }
    }

    /**
     * 左右子节点和父节点关联
     * @param node
     */
    public void processParent(AvlNode node){
        if(Objects.nonNull(node.getLeft())){
            node.getLeft().setParent(node);
            processParent(node.getLeft());
        }
        if(Objects.nonNull(node.getRight())){
            node.getRight().setParent(node);
            processParent(node.getRight());
        }
    }

    /***************************************左单旋转***************************/
    /**
     * 左单旋转:加入6
     *             5
     *         /     \
     *       2         8
     *      /  \      /
     *    1     4    7
     *        /     /
     *      3     6
     *    结果：
     *             5
     *         /     \
     *       2         7
     *      /  \      /  \
     *    1     4    6     8
     *        /
     *      3
     */
    @Test
    public void testAvlNodeLeftSingle(){
        // 左单旋转:插入和直接单旋转比较
        System.out.println("\n左-单旋转1");
        AvlNode root = createLeftSingleData();
        printTree(root);
        System.out.print("\n");
        root.insert(new AvlNode(6));
        printTree(root);

        System.out.println("\n左-单旋转2");
        root = createLeftSingleData();
        printTree(root);
        System.out.print("\n");
        root.getRight().getLeft().setLeft(new AvlNode(6));
        // 对8节点进行左单旋转
        root.setRight(AvlNode.singleRotateWithLeft(root.getRight()));
        printTree(root);
        System.out.print("\n");
    }

    public AvlNode createLeftSingleData(){
        AvlNode root = new AvlNode(5);
        root.setChild(2, 8);
        root.getLeft().setChild(1, 4);
        root.getLeft().getRight().setLeft(new AvlNode(3));

        root.getRight().setLeft(new AvlNode(7));
        processParent(root);
        return root;
    }

    /**************************************右单旋转***************************/
    /**
     * 右单旋转：加入5
     *        2
     *      /   \
     *     1      3
     *              \
     *                4
     *                  \
     *                    5
     *    结果：
     *       2
     *     /   \
     *   1      4
     *        /  \
     *       3     5
     */
    @Test
    public void testAvlNodeRightSingle(){
        // 左单旋转:插入和直接单旋转比较
        System.out.println("\n右-单旋转1");
        AvlNode root = createRightSingleData();
        printTree(root);
        System.out.print("\n");
        root.insert(new AvlNode(5));
        printTree(root);

        System.out.println("\n右-单旋转2");
        root = createRightSingleData();
        printTree(root);
        System.out.print("\n");
        root.getRight().getRight().setRight(new AvlNode(5));
        root.setRight(AvlNode.singleRotateWithRight(root.getRight()));
        printTree(root);
        System.out.print("\n");
    }

    public AvlNode createRightSingleData(){
        AvlNode root = new AvlNode(2);
        root.setChild(1, 3);

        root.getRight().setRight(new AvlNode(4));
        processParent(root);
        return root;
    }

    /**************************************右双旋转***************************/
    /**
     * 右单旋转：加入14时，在6、15、7触发右双旋转
     *             4
     *         /     \
     *       2         6
     *      /  \      /  \
     *    1     3    5    15
     *                   /   \
     *                 7      16
     *                  \
     *                   14
     *    结果：
     *             4
     *         /     \
     *       2         7
     *      /  \      /  \
     *    1     3    6    15
     *              /    /   \
     *             5   14     16
     */
    @Test
    public void testAvlNodeLeftDouble(){
        // 左单旋转:插入和直接单旋转比较
        System.out.println("\n右双旋转1");
        AvlNode root = createLeftDoubleData();
        printTree(root);
        System.out.print("\n");
        root.insert(new AvlNode(14));
        printTree(root);

        System.out.println("\n右双旋转2");
        root = createLeftDoubleData();
        printTree(root);
        System.out.print("\n");
        root.getRight().getRight().getLeft().setRight(new AvlNode(14));
        root.setRight(AvlNode.doubleRotate(root.getRight(), false));
        printTree(root);
        System.out.print("\n");
    }

    public AvlNode createLeftDoubleData(){
        AvlNode root = new AvlNode(4);
        root.setChild(2, 6);
        root.getLeft().setChild(1, 3);

        root.getRight().setChild(5, 15);
        root.getRight().getRight().setChild(7, 16);

        processParent(root);
        return root;
    }

}

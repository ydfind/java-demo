package com.ydfind.datastructure.tree;

/**
 * 红黑树
 * @param <T> 数据的类型
 * @author ydfind
 * @date 2019.11.1
 */
public class MyRedBlackTree<T extends Comparable<? super T>>{

    /**
     * 黑色
     */
    private static final int BLACK = 1;
    /**
     * 红色
     */
    private static final int RED   = 0;

    private RedBlackNode<T> header;
    private RedBlackNode<T> nullNode;
    // 当前节点、父、祖父、曾祖父节点
    private RedBlackNode<T> current;
    private RedBlackNode<T> parent;
    private RedBlackNode<T> grand;
    private RedBlackNode<T> great;
    /*************************************************节点类**********************************/
    /**
     * 红黑树节点 类
     * @param <T>
     */
    private static class RedBlackNode<T> {
        T data;
        RedBlackNode<T> left;
        RedBlackNode<T> right;
        int color;

        RedBlackNode(T data){
            this(data, null, null );
        }

        RedBlackNode(T data, RedBlackNode<T> left, RedBlackNode<T> right) {
            this.data = data;
            this.left = left;
            this.right = right;
            // 默认节点为黑色
            this.color = MyRedBlackTree.BLACK;
        }
    }


    public MyRedBlackTree(){
        // 初始化根节点和空节点（默认的叶子节点）
        nullNode = new RedBlackNode<>(null);
        nullNode.left = nullNode.right = nullNode;
        header = new RedBlackNode<>(null);
        header.left = header.right = nullNode;
    }

    private final int compare(T item, RedBlackNode<T> t){
        if(t == header){
            // header默认为空，默认比其他都小
            return 1;
        }else{
            return item.compareTo(t.data);
        }
    }

    public void insert(T item){
        // 默认都等于头节点
        current = parent = grand = header;
        nullNode.data = item;
        int cp;
        while ((cp = compare(item, current)) != 0){// 会有相等的时候吗？？？？？？？？是不是插入后，和自己比较就相等了
            // 往下面一个节点
            great = grand;
            grand = parent;
            parent = current;
            // 第一个节点必然再header的右边
            current = cp < 0 ? current.left : current.right;

            // 两个子节点为红，重新确定红黑色
            if(current.left.color == RED && current.right.color == RED){
                handleReorient(item);
            }
        }
        // 找到对应节点current不为空，无法进行插入
        if(nullNode != current){
            return;
        }
        // 执行插入操作
        current = new RedBlackNode<>(item, nullNode, nullNode);
        if(compare(item, parent) < 0){
            parent.left = current;
        }else{
            parent.right = current;
        }
        handleReorient(item);
    }

    /**
     * 全局变量current两个子节点为红，重新确定红黑色
     */
    private void handleReorient(T item){// current等变量传入这里会不会有问题?????????????????????
        current.color = RED;
        current.left.color = BLACK;
        current.right.color = BLACK;
        if(parent.color == RED){
            grand.color = RED;
            if((compare(item, parent) < 0) != (compare(item, grand) < 0)){
                // 需要进行双旋转
                // 第一步：current、parent两个节点进行，传入parent的parent即grand
                parent = rotate(item, grand);
            }
            // 单旋转或双旋转的第二步
            // 这里可能会使insert中current往前了，是不是会多了一层????????????????
            current = rotate(item, great);
            // 新树根默认黑色，这样树上面的节点的结构
            current.color = BLACK;
        }
        header.right.color = BLACK;
    }
    /***************************************************旋转************************************/

    /**
     * 对parent的left或right节点，进行 单旋转 或 双旋转中单旋转;
     * 并将新子树的树根 重新赋值；
     * 其中颜色需要外部处理
     * @param item
     * @param parent
     * @return
     */
    private RedBlackNode<T> rotate(T item, RedBlackNode<T> parent){
        if(compare(item, parent) < 0){
            // 判断LL，还是LR型，单旋转后面的L或R
            parent.left = compare(item, parent.left) < 0 ?
                    rotateWithLeftChild(parent.left) :
                    rotateWithRightChild(parent.left);
            return parent.left;
        }else{
            parent.right = compare(item, parent.right) < 0 ?
                    rotateWithLeftChild(parent.right) :
                    rotateWithRightChild(parent.right);
            return parent.right;
        }
    }

    /**
     * 左子树，向右单旋转
     */
    private RedBlackNode<T> rotateWithLeftChild( RedBlackNode<T> k2 ){
        RedBlackNode<T> k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        return k1;
    }

    /**
     * 右子树，向左单旋转
     */
    private RedBlackNode<T> rotateWithRightChild( RedBlackNode<T> k1 )
    {
        RedBlackNode<T> k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        return k2;
    }
    /*******************************************打印***********************************************/
    public void printTree() {
        if(isEmpty()) {
            System.out.println("Empty tree");
        } else {
            System.out.println("\n中序：left data right--------------");
            printTree(header.right);
            System.out.println("\n先序：data left right--------------");
            printPreTree(header.right);
        }
    }

    private void printPreTree( MyRedBlackTree.RedBlackNode<T> t ) {
        if(t != nullNode){
            if(t.color == BLACK) {
                System.out.print(t.data + " ");
            }else {
                System.out.print(t.data + "_ ");
            }
            if(t.right != nullNode || t.left != nullNode) {
//                System.out.print("(");
                printPreTree(t.left);
//                System.out.print(",");
                printPreTree(t.right);
//                System.out.print(")");
            }
        }
    }

    private void printTree( MyRedBlackTree.RedBlackNode<T> t ) {
        if(t != nullNode){
            if(t.left != nullNode) {
//                System.out.print("(");
                printTree(t.left);
//                System.out.print(")");
            }
            if(t.color == BLACK) {
                System.out.print(t.data + " ");
            }else {
                System.out.print(t.data + "_ ");
            }
            if(t.right != nullNode) {
//                System.out.print("(");
                printTree(t.right);
//                System.out.print(")");
            }
        }
    }

    public boolean isEmpty( ) {
        return header.right == nullNode;
    }
}

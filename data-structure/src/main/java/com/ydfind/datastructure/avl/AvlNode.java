package com.ydfind.datastructure.avl;

import lombok.Data;

import java.util.Objects;

/**
 * 树节点 对象
 * @author ydifnd
 * @date 2019.10.30
 */
@Data
public class AvlNode {

    private Integer data;
    private AvlNode parent;
    private AvlNode left;
    private AvlNode right;

    public AvlNode(Integer data){
        this.data = data;
    }

    public void setChild(int left, int right){
        this.left = new AvlNode(left);
        this.right = new AvlNode(right);
    }

    /**
     * 计算高度 单节点为0
     * @return 高度
     */
    public static int calcHeight(AvlNode node){
        // 无节点为-1
        if(Objects.isNull(node) || Objects.isNull(node.data)){
            return -1;
        }
        int leftHeight = Objects.nonNull(node.left) ? calcHeight(node.left) : -1;
        int rightHeight = Objects.nonNull(node.right) ? calcHeight(node.right) : -1;
        int height = leftHeight > rightHeight ? 1 + leftHeight : 1 + rightHeight;
        return height;
    }

    /*********************************************插入************************************************/

    /**
     * 插入
     * @param node
     * @return
     */
    public AvlNode insert(AvlNode node){
        int data = node.getData();
        AvlNode result = this;
        // 暂时不支持等于的情况
        if(data < this.data){
            this.left = Objects.isNull(left) ? node : this.left.insert(node);
            if(calcHeight(left) - calcHeight(right) == 2){
                if(data < left.data){
                    result = singleRotateWithLeft(this);
                }else {
                    result = doubleRotate(this, true);
                }
            }
        }else if(data > this.data){
            this.right = Objects.isNull(right) ? node : this.right.insert(node);
            if(calcHeight(right) - calcHeight(left) == 2){
                if(data > right.data){
                    result = singleRotateWithRight(this);
                }else {
                    result = doubleRotate(this, false);
                }
            }
        }
        return result;
    }

    /**
     * 单选择：左往右
     * @param k2
     * @return 返回旋转后的树
     */
    public static AvlNode singleRotateWithLeft(AvlNode k2){
        // k2.left修改。k1的右节点 变为 k2的左节点
        AvlNode k1 = k2.left;
        k2.left = k1.right;
        if(Objects.nonNull(k2.left)) {
            k2.left.parent = k2.left;
        }
        // k1作为新的根节点
        k1.right = k2;
        k1.parent = k2.parent;
        k2.parent = k1;
        return k1;
    }

    /**
     * 单选择：右往左
     * @param k1
     * @return 返回旋转后的树
     */
    public static AvlNode singleRotateWithRight(AvlNode k1){
        AvlNode k2 = k1.right;
        k1.right = k2.left;
        if(Objects.nonNull(k1.right)) {
            k1.right.parent = k2;
        }
        // k2作为新根节点
        k2.left = k1;
        k2.parent = k1.parent;
        k1.parent = k2;
        return k2;
    }

    /**
     * isLeft=true,先下面节点左旋转，再上面节点右旋转;否则相反
     * @param k3
     * @param isLeft 是否是左分支
     * @return
     */
    public static AvlNode doubleRotate(AvlNode k3, boolean isLeft){
        if(isLeft) {
            k3.left = singleRotateWithRight(k3.getLeft());
            k3.left.parent = k3;

            return singleRotateWithLeft(k3);
        }else{
            k3.right = singleRotateWithLeft(k3.getRight());
            k3.right.parent = k3;

            return singleRotateWithRight(k3);
        }
    }

    /*********************************************查找************************************************/
    public static AvlNode findMin(AvlNode root){
        if(Objects.isNull(root)){
            return null;
        }
        AvlNode result = root;
        while(Objects.nonNull(result.left)){
            result = result.left;
        }
        return result;
    }

    public static AvlNode findMax(AvlNode root){
        if(Objects.isNull(root)){
            return null;
        }
        AvlNode result = root;
        while(Objects.nonNull(result.right)){
            result = result.right;
        }
        return result;
    }


    /*********************************************删除************************************************/
//    /**
//     * 删除
//     * @param root
//     * @param data
//     * @return 返回新的树
//     */
//    public static AvlNode delete(AvlNode root, int data){
//        AvlNode result = root;
//        // 暂时不支持等于的情况
//        if(data == root.data){
//            AvlNode parent;
//            if(calcHeight(root.left) < calcHeight(root.right)) {
//                // 将右子树的最左儿子（最小值）作为新根节点
//                result = findMin(root.right);
//                parent = result.parent;
//                // minParent必然不为null，最上面也会有root
//                parent.left = result.right;
//                if(Objects.nonNull(result.right)){
//                    result.right.parent = result.parent;
//                }
//
//                result.parent = root.parent;
//                result.left = root.left;
//                if(!root.right.equals(result)) {
//                    result.right = root.right;
//                }
//            }else if(Objects.isNull(root.left)){
//                return null;
//            }else{
//                // 将左子树的最右儿子（最大值）作为新根节点
//                result = findMax(root.left);
//                parent = result.parent;
//                parent.right = result.left;
//                if(Objects.nonNull(result.left)){
//                    result.left.parent = parent;
//                }
//                result.parent = root.parent;
//                result.right = root.right;
//                if(!root.left.equals(result)){
//                    result.left = root.left;
//                }
//            }
//            // 然后从minParent开始调整平衡
//            while(Objects.nonNull(parent)){
//                int height = calcHeight(parent.left) - calcHeight(parent.right);
//                if(height == 2){
//
//                }
//            }
//            return result;
//        }
//        else if(data < root.data){
//            root.left = Objects.isNull(root.left) ? null : root.left.insert(node);
//            if(calcHeight(left) - calcHeight(right) == 2){
//                if(data < left.data){
//                    result = singleRotateWithLeft(this);
//                }else {
//                    result = doubleRotate(this, true);
//                }
//            }
//        }else if(data > this.data){
//            this.right = Objects.isNull(right) ? node : this.right.insert(node);
//            if(calcHeight(right) - calcHeight(left) == 2){
//                if(data > right.data){
//                    result = singleRotateWithRight(this);
//                }else {
//                    result = doubleRotate(this, false);
//                }
//            }
//        }
//        return null;
//    }
}

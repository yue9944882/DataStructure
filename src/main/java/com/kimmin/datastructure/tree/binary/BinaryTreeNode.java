package com.kimmin.datastructure.tree.binary;

import java.util.Comparator;

/**
 * Created by kimmin on 15/11/2016.
 */

class BinaryTreeNode<T> {

    /* Fields */
    private Comparator<T> comparator;
    BinaryTreeNode<T> leftChild = null;
    BinaryTreeNode<T> rightChild = null;
    BinaryTreeNode<T> parent = null;
    T val = null;

    /* Constructor */
    public BinaryTreeNode(T val){
        this.val = val;
    }
    public BinaryTreeNode(T val, BinaryTreeNode<T> parent){
        this(val);
        this.parent = parent;
    }
    public BinaryTreeNode(T val,
                          BinaryTreeNode<T> parent, BinaryTreeNode<T> leftChild, BinaryTreeNode<T> rightChild){
        this(val, parent);
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }


    public void rightRotate(){
        BinaryTreeNode<T> tmp = this.leftChild;
        this.leftChild = tmp.rightChild;
        if(tmp.rightChild != null) tmp.rightChild.parent = this;
        if(this.parent != null){
            if(this.parent.leftChild == this){
                this.parent.leftChild = tmp;
                tmp.parent = this.parent;
                this.parent = tmp;
            }
            if(this.parent.rightChild == this){
                this.parent.rightChild = tmp;
                tmp.parent = this.parent;
                this.parent = tmp;
            }
        }else{
            tmp.parent = null;
            this.parent = tmp;
        }
        tmp.rightChild = this;
    }


    public void leftRotate(){
        BinaryTreeNode<T> tmp = this.rightChild;
        this.rightChild = tmp.leftChild;
        if(tmp.leftChild != null) tmp.leftChild.parent = this;
        if(this.parent != null){
            // This is not a root node
            if(this.parent.leftChild == this){
                this.parent.leftChild = tmp;
                tmp.parent = this.parent;
                this.parent = tmp;
            }
            if(this.parent.rightChild == this){
                this.parent.rightChild = tmp;
                tmp.parent = this.parent;
                this.parent = tmp;
            }
        }else{
            tmp.parent = null;
            this.parent = tmp;
        }
        tmp.leftChild = this;
    }

    public boolean canRightRotate(){
        return this.leftChild != null;
    }

    public boolean canLeftRotate(){
        return this.rightChild != null;
    }

    public void printInMidOrder(){
        if(this.leftChild != null) this.leftChild.printInMidOrder();
        System.out.println(this.val.toString());
        if(this.rightChild != null) this.rightChild.printInMidOrder();
    }

    public void printInPreOrder(){
        System.out.println(this.val.toString());
        if(this.leftChild != null) this.leftChild.printInPreOrder();
        if(this.rightChild != null) this.rightChild.printInPreOrder();
    }

    public BinaryTreeNode<T> getRootNode(){
        BinaryTreeNode<T> node = this;
        while(node.parent != null){
            node = node.parent;
        }
        return node;
    }


}

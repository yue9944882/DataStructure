package com.kimmin.datastructure.tree.binary;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by kimmin on 15/11/2016.
 */
public class BinaryTreeTest {

    @Test
    public void testSimpleRedBlackTree(){

    }


    @Test
    public void testBinaryTreeLeftRotate(){
        SimpleRedBlackTree<Integer> tree = new SimpleRedBlackTree<Integer>(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);
        tree.delete(2);
        tree.delete(5);
        SimpleRedBlackTree.RedBlackTreeNode<Integer> root = tree.getRootNode();
        root.printInPreOrder();
        System.out.println();
        root.printInMidOrder();
    }

    @Test
    public void testRBTreeInsertDelete(){
        SimpleRedBlackTree<Integer> tree = new SimpleRedBlackTree<Integer>(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        for(int i = 0; i < 100000; i++){
            tree.insert(i);
        }
        Random random = new Random(System.currentTimeMillis());
        for(int i = 0; i < 99997; i++) {
            int r = random.nextInt(100000);
            if (tree.find(r) != null) {
                tree.delete(r);
            }
        }
        tree.getRootNode().printInMidOrder();
    }

    public static void main(String[] args) throws IOException {
        SimpleRedBlackTree<Integer> tree = new SimpleRedBlackTree<Integer>(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        String cmd = "";
        while(!cmd.equals("q")){
            System.out.print(">");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            cmd = br.readLine();
            Scanner sc = new Scanner(cmd);
            sc.useDelimiter(" ");
            String action = sc.next();
            Integer i = sc.nextInt();
            if(action.equals("i")) tree.insert(i);
            if(action.equals("d")) tree.delete(i);
            tree.getRootNode().printInMidOrder();
        }
    }

}

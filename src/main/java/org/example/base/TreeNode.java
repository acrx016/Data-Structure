package org.example.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 *  Created By Jwj@04668 on 2020/9/7
 */
public class TreeNode {
    private static Logger logger = LoggerFactory.getLogger(TreeNode.class);
    int data;
    TreeNode leftChild;
    TreeNode rightChild;

    TreeNode(int data) {
        this.data = data;
    }

    private static TreeNode createBinaryTree(LinkedList<Integer> inputList) {
        TreeNode node = null;
        if (inputList == null || inputList.isEmpty()) {
            return null;
        }
        Integer data = inputList.removeFirst();
        if (data != null) {
            node = new TreeNode(data);
            node.leftChild = createBinaryTree(inputList);
            node.rightChild = createBinaryTree(inputList);
        }
        return node;
    }

    public static void main(String[] args) {
        LinkedList<Integer> inputList = new LinkedList<>(Arrays.asList(3, 2, 9, null, null, 10, null, null, 8, null, 4));
        TreeNode treeNode = createBinaryTree(inputList);
        levelOrderTraversal(treeNode);

    }


    /**
     * 前序遍历打印
     */
    public static void preOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        logger.info("前序遍历打印{}", node.data);
        preOrderTraversal(node.leftChild);
        preOrderTraversal(node.rightChild);
    }

    /**
     * 中序遍历打印
     */
    public static void inOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.leftChild);
        logger.info("中序遍历打印{}", node.data);
        inOrderTraversal(node.rightChild);
    }

    /**
     * 后续遍历打印
     */
    public static void postOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrderTraversal(node.leftChild);
        postOrderTraversal(node.rightChild);
        logger.info("后续遍历打印{}", node.data);
    }

    /**
     * 栈  前序遍历打印
     */
    public static void preOrderTraversalWithStack(TreeNode root){
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        TreeNode treeNode = root;
        while(treeNode!=null || !stack.isEmpty()){
            while (treeNode!=null){
                logger.info("栈前序访问{}",treeNode.data);
                stack.push(treeNode);
                treeNode=treeNode.leftChild;
            }
            if(!stack.isEmpty()){
                treeNode=stack.pop();
                treeNode=treeNode.rightChild;
            }
        }
    }
    /**
     * 栈    中序遍历打印
     */
    public static void inOrderTraversalWithStack(TreeNode root){
        ArrayDeque<TreeNode> stack=new ArrayDeque<>();
        TreeNode treeNode= root;
        while(treeNode!=null|| !stack.isEmpty()){
            while(treeNode!=null){
                stack.push(treeNode);
                treeNode=treeNode.leftChild;
            }
            if(!stack.isEmpty()){
                treeNode=stack.pop();
                logger.info("栈中序访问{}",treeNode.data);
                treeNode=treeNode.rightChild;
            }
        }
    }

    /**
     * 栈    后续遍历打印
     */
    public static void postOrderTraversalWithStack(TreeNode root){
        ArrayDeque<TreeNode> stack=new ArrayDeque<>();
        ArrayDeque<TreeNode> printStack=new ArrayDeque<>();
        TreeNode treeNode=root;
        while(treeNode!=null||!stack.isEmpty()){
            while(treeNode!=null){
                stack.push(treeNode);
                printStack.push(treeNode);
                treeNode=treeNode.rightChild;
            }
            if(!stack.isEmpty()){
                treeNode=stack.pop().leftChild;
            }
        }
        while (!printStack.isEmpty()){
            logger.info("栈后序访问{}",printStack.pop().data);
        }
    }

    /**
     *  层序遍历
     */
    public static void levelOrderTraversal(TreeNode root){
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            logger.info("层序遍历{}",node.data);
            if(node.leftChild!=null){
                queue.offer(node.leftChild);
            }
            if(node.rightChild!=null){
                queue.offer(node.rightChild);
            }
        }
    }

}

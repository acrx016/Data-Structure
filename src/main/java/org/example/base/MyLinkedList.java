package org.example.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Created By Jwj@04668 on 2020/9/7
 */
public class MyLinkedList {
    public static final String INDEX_OUT_OF_LINKED_LIST_BOUNDS = "Index Out Of LinkedList Bounds";
    private Logger logger = LoggerFactory.getLogger(MyLinkedList.class);
    // 头指针
    private Node head;
    // 尾指针
    private Node last;
    private int size;

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public Node get(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(INDEX_OUT_OF_LINKED_LIST_BOUNDS);
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public void insert(int data, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(INDEX_OUT_OF_LINKED_LIST_BOUNDS);
        }
        Node insertedNode = new Node(data);
        if (size == 0) {
            head = insertedNode;
            last = insertedNode;
        } else if (index == 0) {
            // 头插
            insertedNode.next = head;
            head = insertedNode;
        } else if (index == size) {
            // 尾插
            last.next = insertedNode;
            last = insertedNode;
        } else {

            // 获取前一个节点，然后插入新节点
            Node preNode = get(index - 1);
            insertedNode.next = preNode.next;
            preNode.next = insertedNode;
        }
        size++;
    }

    public Node remove(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(INDEX_OUT_OF_LINKED_LIST_BOUNDS);
        }
        Node removeNode;
        if (index == 0) {
            // 头部删除
            removeNode = head;
            head = head.next;
        } else if (index == size - 1) {
            // 尾部删除
            Node preNode = get(index - 1);
            // 返回被删除的节点
            removeNode = preNode.next;
            preNode.next = null;
            last = preNode;
        } else {
            // 删除中间节点
            Node preNode = get(index - 1);
            removeNode = preNode.next;
            preNode.next = removeNode.next;
        }
        size--;
        return removeNode;
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.insert(71, 0);
        myLinkedList.insert(72, 1);
        myLinkedList.insert(73, 2);
        myLinkedList.insert(74, 3);
        myLinkedList.remove(2);
        myLinkedList.output();
    }

    public void output() {
        Node temp = head;
        while (temp != null) {
            logger.info("节点{}", temp.data);
            temp = temp.next;
        }
    }
}

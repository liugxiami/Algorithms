package com.ccsi.util;

/**
 * Created by gxliu on 2016/11/2.
 */
public class MyQueue {
    Node head = null;
    Node tail = null;
    int size = 0;

    public void offer(int v) {
        if (size == 0) {
            head = new Node(v);
            tail = head;
        } else {
            tail.next = new Node(v);
            tail = tail.next;
        }
        size++;
    }

    public Integer poll() {
        if (size == 0) return null;
        Integer res = head.val;
        head = head.next;
        size--;
        return res;
    }

    public Integer peek() {
        if (size == 0) return null;
        return head.val;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private class Node {
        public Integer val;
        Node next;

        public Node(Integer val) {
            this.val = val;
        }
    }
}

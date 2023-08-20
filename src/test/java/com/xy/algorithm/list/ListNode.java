package com.xy.algorithm.list;

public class ListNode<T> {

    T value;

    public ListNode<T> next;

    public ListNode(T value) {
        this.value = value;
    }

    public void print() {
        if (next == null) {
            System.out.println(value);
        } else {
            System.out.print(value + ", ");
            next.print();
        }
    }
}

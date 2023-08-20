package com.xy.algorithm.list;

import org.junit.Test;

/**
 * 链表
 */
public class List {

    /**
     * 测试合并两个有序链表
     */
    @Test
    public void testMergeOrderedList() {
        ListNode<Integer> listNode1 = new ListNode<>(1);
        ListNode<Integer> listNode3 = new ListNode<>(3);
        ListNode<Integer> listNode5 = new ListNode<>(5);
        listNode1.next = listNode3;
        listNode3.next = listNode5;
        listNode1.print();

        ListNode<Integer> listNode2 = new ListNode<>(2);
        ListNode<Integer> listNode4 = new ListNode<>(4);
        ListNode<Integer> listNode6 = new ListNode<>(6);
        listNode2.next = listNode4;
        listNode4.next = listNode6;
        listNode2.print();

        ListNode<Integer> node = mergeOrderedList(listNode1, listNode2);
        node.print();
    }

    /**
     * 测试合并两个有序链表
     */
    public ListNode<Integer> mergeOrderedList(ListNode<Integer> listNode1, ListNode<Integer> listNode2) {
        if (listNode1 == null) {
            return listNode2;
        }
        if (listNode2 == null) {
            return listNode1;
        }

        ListNode<Integer> node = new ListNode<>(0);
        ListNode<Integer> result = node;

        while (listNode1 != null && listNode2 != null) {
            if (listNode1.value < listNode2.value) {
                node.next = listNode1;
                listNode1 = listNode1.next;
            } else {
                node.next = listNode2;
                listNode2 = listNode2.next;
            }
            node = node.next;
        }
        if (listNode1 != null) {
            node.next = listNode1;
        } else {
            node.next = listNode2;
        }
        return result.next;
    }
}

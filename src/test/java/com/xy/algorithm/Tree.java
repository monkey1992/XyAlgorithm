package com.xy.algorithm;

import org.junit.Test;

import java.util.ArrayList;

public class Tree {

    @Test
    public void main() {
        System.out.println("123");
    }

    /**
     * 二叉树示例：
     * *******1******
     * ***2******3***
     * *4***5**6***7*
     * ***8***9******
     */

    @Test
    public void test() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node5.left = node8;
        node5.right = node9;
        ArrayList<ArrayList<TreeNode>> treeNodes = new ArrayList<>();
        levelOrder2(node1, treeNodes, 0);
        for (int i = 0; i < treeNodes.size(); i++) {
            ArrayList<TreeNode> treeNodesList = treeNodes.get(i);
            if (treeNodesList == null) {
                return;
            }
            int size = treeNodesList.size();
            if (size < 1) {
                return;
            }
            System.out.println(treeNodesList.get(size - 1).root);
        }
    }

    public void levelOrder2(TreeNode node, ArrayList<ArrayList<TreeNode>> lists, int level) {
        if (node == null || lists == null || level < 0) {
            return;
        }
        ArrayList<TreeNode> list;
        if (lists.size() == level) {
            list = new ArrayList<>();
            lists.add(list);
        } else {
            list = lists.get(level);
        }
        list.add(node);
        level++;
        levelOrder(node.left, lists, level);
        levelOrder(node.right, lists, level);
    }

    public void levelOrder(TreeNode node, ArrayList<ArrayList<TreeNode>> lists, int level) {
        if (node == null || lists == null || level < 0) {
            return;
        }
        // 0: 1
        // 1: 2、3
        // 2: 4、5、6、7
        // 3: 8、9

        ArrayList<TreeNode> treeNodes;
        if (level == lists.size()) {
            treeNodes = new ArrayList<>();
            lists.add(treeNodes);
        }
        lists.get(level).add(node);
        level += 1;
        levelOrder(node.left, lists, level);
        levelOrder(node.right, lists, level);

//        if (level > 0) {
//            ArrayList<TreeNode> treeNodes;
//            if (lists.size() > level) {
//                treeNodes = lists.get(level);
//                treeNodes.add(node);
//            } else {
//                treeNodes = new ArrayList<>();
//                treeNodes.add(node);
//                lists.add(treeNodes);
//            }
//            levelOrder(node.left, lists, level + 1);
//            levelOrder(node.right, lists, level + 1);
//        } else {
//            ArrayList<TreeNode> treeNodes = new ArrayList<>();
//            treeNodes.add(node);
//            lists.add(treeNodes);
//            levelOrder(node.left, lists, 1);
//            levelOrder(node.right, lists, 1);
//        }
    }
}

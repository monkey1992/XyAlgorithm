package com.xy.algorithm.tree;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class Tree {

    private TreeNode<Integer> node1;

    @Before
    public void before() {
        createTreeNode();
    }

    /**
     * 创建二叉树：
     * *******1******
     * ***2******3***
     * *4***5**6***7*
     * ***8***9******
     * <p>
     * 先序遍历（根、左、右）：1, 2, 4, 5, 8, 9, 3, 6, 7
     * 中序遍历（左、根、右）：4, 2, 8, 5, 9, 1, 6, 3, 7
     * 后序遍历（左、右、根）：4, 8, 9, 5, 2, 6, 7, 3, 1
     */
    private void createTreeNode() {
        node1 = new TreeNode<>(1);
        TreeNode<Integer> node2 = new TreeNode<>(2);
        TreeNode<Integer> node3 = new TreeNode<>(3);
        TreeNode<Integer> node4 = new TreeNode<>(4);
        TreeNode<Integer> node5 = new TreeNode<>(5);
        TreeNode<Integer> node6 = new TreeNode<>(6);
        TreeNode<Integer> node7 = new TreeNode<>(7);
        TreeNode<Integer> node8 = new TreeNode<>(8);
        TreeNode<Integer> node9 = new TreeNode<>(9);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node5.left = node8;
        node5.right = node9;
    }

    /**
     * 测试先序遍历
     */
    @Test
    public void testPreorderTraverse() {
        preorderTraverse(node1);
    }

    /**
     * 先序遍历
     */
    private void preorderTraverse(TreeNode<Integer> treeNode) {
        if (treeNode == null) {
            return;
        }
        System.out.print(treeNode.value + ", ");
        preorderTraverse(treeNode.left);
        preorderTraverse(treeNode.right);
    }

    /**
     * 测试中序遍历
     */
    @Test
    public void testInorderTraverse() {
        inorderTraverse(node1);
    }

    /**
     * 中序遍历
     */
    private void inorderTraverse(TreeNode<Integer> treeNode) {
        if (treeNode == null) {
            return;
        }
        inorderTraverse(treeNode.left);
        System.out.print(treeNode.value + ", ");
        inorderTraverse(treeNode.right);
    }

    /**
     * 测试后序遍历
     */
    @Test
    public void testPostorderTraverse() {
        postorderTraverse(node1);
    }

    /**
     * 后序遍历
     */
    private void postorderTraverse(TreeNode<Integer> treeNode) {
        if (treeNode == null) {
            return;
        }
        postorderTraverse(treeNode.left);
        postorderTraverse(treeNode.right);
        System.out.print(treeNode.value + ", ");
    }

    @Test
    public void testDFS() {
        dfs(node1);
    }

    private void dfs(TreeNode<Integer> treeNode) {

    }

    @Test
    public void testBFS() {
        ArrayList<ArrayList<TreeNode<Integer>>> treeNodesList = new ArrayList<>();
        bfs(node1, treeNodesList, 0);
        int size = treeNodesList.size();
        if (size < 1) {
            return;
        }
        for (int i = 0; i < size; i++) {
            ArrayList<TreeNode<Integer>> treeNodes = treeNodesList.get(i);
            int treeNodesSize = treeNodes.size();
            if (treeNodesSize < 1) {
                continue;
            }
            TreeNode<Integer> node = treeNodes.get(treeNodesSize - 1);
            if (node == null) {
                continue;
            }
            System.out.println(node.value);
        }
    }

    private void bfs(TreeNode<Integer> treeNode, ArrayList<ArrayList<TreeNode<Integer>>> treeNodesList, int level) {
        if (treeNode == null) {
            return;
        }
        ArrayList<TreeNode<Integer>> treeNodes;
        int size = treeNodesList.size();
        if (level < size) {
            treeNodes = treeNodesList.get(level);
        } else {
            treeNodes = new ArrayList<>();
            treeNodesList.add(treeNodes);
        }
        treeNodes.add(treeNode);
        level++;
        bfs(treeNode.left, treeNodesList, level);
        bfs(treeNode.right, treeNodesList, level);
    }

    @Test
    public void test() {
        TreeNode<Integer> node1 = new TreeNode<>(1);
        TreeNode<Integer> node2 = new TreeNode<>(2);
        TreeNode<Integer> node3 = new TreeNode<>(3);
        TreeNode<Integer> node4 = new TreeNode<>(4);
        TreeNode<Integer> node5 = new TreeNode<>(5);
        TreeNode<Integer> node6 = new TreeNode<>(6);
        TreeNode<Integer> node7 = new TreeNode<>(7);
        TreeNode<Integer> node8 = new TreeNode<>(8);
        TreeNode<Integer> node9 = new TreeNode<>(9);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node5.left = node8;
        node5.right = node9;
        ArrayList<ArrayList<TreeNode<Integer>>> treeNodes = new ArrayList<>();
        levelOrder2(node1, treeNodes, 0);
        for (int i = 0; i < treeNodes.size(); i++) {
            ArrayList<TreeNode<Integer>> treeNodesList = treeNodes.get(i);
            if (treeNodesList == null) {
                return;
            }
            int size = treeNodesList.size();
            if (size < 1) {
                return;
            }
            System.out.println(treeNodesList.get(size - 1).value);
        }
    }

    public void levelOrder2(TreeNode<Integer> node, ArrayList<ArrayList<TreeNode<Integer>>> lists, int level) {
        if (node == null || lists == null || level < 0) {
            return;
        }
        ArrayList<TreeNode<Integer>> list;
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

    public void levelOrder(TreeNode<Integer> node, ArrayList<ArrayList<TreeNode<Integer>>> lists, int level) {
        if (node == null || lists == null || level < 0) {
            return;
        }
        // 0: 1
        // 1: 2、3
        // 2: 4、5、6、7
        // 3: 8、9

        ArrayList<TreeNode<Integer>> treeNodes;
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

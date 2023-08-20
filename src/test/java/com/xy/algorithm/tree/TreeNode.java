package com.xy.algorithm.tree;

public class TreeNode<T> {

    TreeNode<T> left;

    TreeNode<T> right;

    T value;

    TreeNode(T value) {
        this.value = value;
    }
}
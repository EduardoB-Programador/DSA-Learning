package com.eduardo.dataStructures;

public class TreeNode<T extends Comparable<T>> {

    T value;
    TreeNode<T> left;
    TreeNode<T> right;

    public TreeNode() {}

    public TreeNode(T value) {
        this.value = value;
    }

}

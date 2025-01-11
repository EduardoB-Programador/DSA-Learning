package com.eduardo.dataStructures;

//I'm so proud of this generic inheritance
public class BinaryTree<T extends Comparable<T>> {

    private TreeNode<T> root;

    public BinaryTree() {}

    public void insert(T data) {
        root = insertRec(root, data);
    }

    private TreeNode<T> insertRec(TreeNode<T> newRoot, T data) {

        if (newRoot == null)
            newRoot = new TreeNode<>(data);

        else if (data.compareTo(newRoot.value) < 0)
            newRoot.left = insertRec(newRoot.left, data);

        else
            newRoot.right = insertRec(newRoot.right, data);

        return newRoot;
    }

    public void inOrder() {
        inOrderRec(root);
        System.out.println();
    }

    private void inOrderRec(TreeNode<T> node) {

        if (node != null) {
            inOrderRec(node.left);
            System.out.print(node.value + " ");
            inOrderRec(node.right);
        }
    }

    public void preOrder() {
        preOrderRec(root);
        System.out.println();
    }

    private void preOrderRec(TreeNode<T> node) {

        if (node != null) {
            System.out.print(node.value + " ");
            preOrderRec(node.left);
            preOrderRec(node.right);
        }
    }
}

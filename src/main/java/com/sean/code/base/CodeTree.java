package com.sean.code.base;

/**
 * @author sean
 * 重建二叉树
 * 前序遍历和种序遍历
 */
public class CodeTree {
    public static class TreeNode {
        private int value;
        private TreeNode leftChild;
        private TreeNode rightChild;

        public TreeNode(int rootValue) {
            this.value = rootValue;
        }

        public void setLeftChild(TreeNode leftChild) {
            this.leftChild = leftChild;
        }

        public void setRightChild(TreeNode rightChild) {
            this.rightChild = rightChild;
        }
    }

    public int findIndexMid(int[] mid, int rootValue, int midStart, int midEnd) {
        for (int i=midStart; i<=midEnd; i++) {
            if (mid[i] == rootValue) {
                return i;
            }
        }

        throw new IllegalArgumentException("err");
    }

    public TreeNode rebuild(int[] pre, int preStart, int preEnd, int[] mid, int midStart,
                            int midEnd) {
        int rootValue = pre[preStart];
        int midIndex = findIndexMid(mid, rootValue, midStart, midEnd);
        TreeNode root = new TreeNode(rootValue);

        if (midIndex == midStart) {
            root.leftChild = null;
        } else {
            int leftSize = midIndex - midStart;
            root.leftChild = rebuild(pre, preStart + 1, preStart + leftSize,
                    mid, midStart, midIndex - 1);
        }

        if (midIndex == midEnd) {
            root.rightChild = null;
        } else {
            int rightSize = midEnd - midIndex;
            root.rightChild = rebuild(pre, preEnd - rightSize + 1, preEnd, mid,
                    midIndex + 1, midEnd);
        }

        return root;
    }

    public void show(TreeNode root) {
        showTree(root, root, "", false);

    }

    public void showTree(TreeNode root, TreeNode node, String prefix, boolean left) {
        if (root == node) {
            prefix = "|---";
        } else if (root.leftChild == node || root.rightChild == node) {
            prefix = "    " + prefix;

        } else {
            String tail = prefix.substring(prefix.length() - 4, prefix.length());
            if (left) {
                prefix = prefix.replace(tail, "|   ") + tail;
            } else {
                prefix = prefix.replace(tail, "    ") + tail;
            }

        }

        if (null == node) {
            System.out.println(prefix + "nil");
            return;
        } else {
            System.out.println(prefix + node.value);
        }

        showTree(root, node.leftChild, prefix, true);
        showTree(root, node.rightChild, prefix, false);
    }
}

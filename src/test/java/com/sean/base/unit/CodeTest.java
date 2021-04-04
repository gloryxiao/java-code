package com.sean.base.unit;

import com.sean.code.base.CodeTree;
import org.junit.Test;

public class CodeTest {
    @Test
    public void test1() {
        CodeTree codeTree = new CodeTree();
        int[] preorder = { 1, 2, 4, 7, 3, 5, 6, 8 };
        int[] inorder = { 4, 7, 2, 1, 5, 3, 8, 6 };

        CodeTree.TreeNode root = codeTree.rebuild(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);

        codeTree.show(root);
    }
}

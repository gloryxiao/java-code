package com.sean.base.unit;

import com.sean.code.base.CodeTree;
import org.junit.Assert;
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

    @Test
    public void testString1() {
        String s = "iot.com";
        replaceSrt(s);
        Assert.assertEquals("iot.com", s);
        StringBuffer s2 = new StringBuffer(s);
        replaceStr(s2);
        Assert.assertEquals("aa.com", s2.toString());

    }


    private void replaceSrt(String source) {
        String result = source.replaceFirst("iot", "aa");
        System.out.println(result);
    }

    private void replaceStr(StringBuffer source) {
        source.replace(0, 3 ,"aa");
    }
}

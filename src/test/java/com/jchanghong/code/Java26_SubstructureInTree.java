/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * <p>
 * // 面试题26：树的子结构
 * // 题目：输入两棵二叉树A和B，判断B是不是A的子结构。
 */
package com.jchanghong.code;

import com.jchanghong.code.util.TreeNode;
import org.junit.Assert;
import org.junit.Test;

public class Java26_SubstructureInTree {
    public boolean issubTree(TreeNode head1, TreeNode head2) {
        boolean result = false;

        if (head1!=null&&head2!=null) {
            if (equals1(head1.values,head2.values)) {
                result = doesTree1HaveTree2(head1, head2);
            }
            if (!result){
                result = issubTree(head1.left, head2);
            }
            if (!result) {
                result = issubTree(head1.right, head2);
            }
        }
        return result;
    }

    private boolean doesTree1HaveTree2(TreeNode head1, TreeNode head2) {
        return head2 == null || head1 != null && equals1(head1.values, head2.values) && doesTree1HaveTree2(head1.left, head2.left) && doesTree1HaveTree2(head1.right, head2.right);

    }

    private boolean equals1(double a, double b) {
        return (a - b > -0.0000001) && (a - b < 0.0000001);
    }

    @Test
    public void test() throws Exception {
        TreeNode head = new TreeNode(2, null, null);
        head.left = new TreeNode(1, null, null);
        head.right = new TreeNode(3, null, null);
        Assert.assertTrue(issubTree(head, head.left));
        Assert.assertTrue(issubTree(head, head.right));
    }
}

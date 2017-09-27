/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * <p>
 * // 面试题23：链表中环的入口结点
 * // 题目：一个链表中包含环，如何找出环的入口结点？例如，在图3.8的链表中，
 * // 环的入口结点是结点3。
 */
package com.jchanghong.code;

import com.jchanghong.code.util.LinkListUtil;
import com.jchanghong.code.util.LinkNode;
import org.junit.Assert;
import org.junit.Test;

public class Java23_EntryNodeInListLoop {
    private LinkNode entryNode(LinkNode head) {
        LinkNode meeting = haveEntryNode(head);
        if (meeting == null) {
            return null;
        }
        int nodeInLoop = 1;
        LinkNode mNode = meeting;
        while (mNode.next!=meeting) {
            mNode = mNode.next;
            nodeInLoop++;
        }
        mNode = head;
        for (int i = 0; i < nodeInLoop; i++) {
            mNode = mNode.next;
        }
        LinkNode mNode2 = head;
        while (mNode!=mNode2) {
            mNode = mNode.next;
            mNode2 = mNode2.next;
        }

        return mNode;
    }

    private LinkNode haveEntryNode(LinkNode head){
        if (head==null){
            return null;
        }
        if (head.next==null){
            return null;
        }
        LinkNode slow = head.next;
        LinkNode fast = slow.next;
        while (slow!=null&&fast!=null) {
            if (slow==fast) {
                return slow;
            }
            slow = slow.next;
            fast = fast.next;
            if (fast!=null) {
                fast = fast.next;
            }
        }
        return null;
    }

    @Test
    public void test() throws Exception {
        LinkNode head = LinkListUtil.construct(1, 2, 3, 4);
        LinkNode node = head;
        while (node.next != null) {
            node = node.next;
        }
        node.next = head.next;
        Assert.assertEquals(entryNode(head), head.next);
    }
}

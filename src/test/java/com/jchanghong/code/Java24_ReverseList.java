/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * <p>
 * // 面试题24：反转链表
 * // 题目：定义一个函数，输入一个链表的头结点，反转该链表并输出反转后链表的
 * // 头结点。
 */
package com.jchanghong.code;

import com.jchanghong.code.util.LinkListUtil;
import com.jchanghong.code.util.LinkNode;
import org.junit.Assert;
import org.junit.Test;

public class Java24_ReverseList {
    public LinkNode reverseList(LinkNode head) {
        if(head==null){
            return null;
        }
        if (head.next==null) {
            return head;
        }
        LinkNode pre = head;
        LinkNode now = pre.next;
        LinkNode next = now.next;
        now.next=pre;
        pre.next=null;
        while (next!=null) {

            pre=now;
            now=next;
            next=next.next;

            now.next = pre;
        }
        return now;


    }

    @Test
    public void test() throws Exception {
        LinkNode head = LinkListUtil.construct(1, 2, 3, 4, 5, 6);
        LinkNode h2 = LinkListUtil.construct(6, 5, 4, 3, 2, 1);
        Assert.assertTrue(LinkListUtil.equels(reverseList(head), h2));
    }
}

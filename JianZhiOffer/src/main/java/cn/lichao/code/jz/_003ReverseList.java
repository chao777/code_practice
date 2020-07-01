package cn.lichao.code.jz;

import java.util.ArrayList;


public class _003ReverseList {

    private ArrayList<Integer> result = new ArrayList<>();

    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        if(listNode == null) {
            return result;
        } else {
            if (listNode.next != null) {
                printListFromTailToHead1(listNode.next);
            }
            result.add(listNode.val);
        }
        return result;
    }


}
class ListNode {
    int val;
    ListNode next = null;
    ListNode(int val) {
        this.val = val;
    }
}




package reetCodeAlgorithms.Reverse_Linked_List;

import reetCodeAlgorithms.ListNode;

class Solution {
    public static ListNode reverseList(ListNode head) {
        //재귀적으로 파고 들어가서 연결하면?
        
        ListNode res = new ListNode(0);
        reverseNode(head, res);
        return res;
    }
    
    public static void reverseNode(ListNode head, ListNode res) {
        if(head == null) return;
        reverseNode(head.next, res);
        ListNode temp = new ListNode(head.val);
        res.next = temp;
        res = res.next;
        System.out.println(res.val);
    }
    
    public static void main(String[] args) {
		ListNode node = ListNode.buildNode(new int[] {1,2,3,4,5});
		reverseList(node);
		System.out.println(node.val);
	}
}

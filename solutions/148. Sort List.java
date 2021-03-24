/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    private ListNode midOfLL(ListNode node){
        if(node == null || node.next == null)return node;
        ListNode fast = node;
        ListNode slow = node;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    private ListNode reverse(ListNode node){
        if(node == null || node.next == null) return node;
        ListNode prev = null;
        ListNode curr = node;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    private ListNode mergeTwoList(ListNode l1,ListNode l2){
        if(l1 == null || l2 == null) return l1 != null ? l1 :l2;
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        ListNode c1 = l1;
        ListNode c2 =l2;
        while(c1 != null && c2 != null){
            if(c1.val <c2.val){
                prev.next =c1;
                c1 = c1.next;
            }else{
                prev.next = c2;
                c2 = c2.next;
            }
            prev = prev.next;
        }
        prev.next = c1 != null ? c1 : c2;
        return dummy.next;
    }
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode mid = midOfLL(head);
        ListNode newHead = mid.next;
        mid.next =null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(newHead);
        return mergeTwoList(l1,l2);
        
    }
}

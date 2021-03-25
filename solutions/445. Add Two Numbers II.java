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
    public ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode curr = head;
        ListNode prev = null;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr =next;
        }
        return prev;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l2 == null){
            return l1;
        }
        l1 = reverse(l1);
        l2 = reverse(l2);
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        ListNode c1 =l1;
        ListNode c2 =l2;
        int carry =0;
        while(c1 != null || c2 != null || carry != 0){
            int sum = carry + (c1!= null ? c1.val: 0) +(c2 != null ? c2.val : 0);
            int lastDigit = sum % 10;
            carry = sum /10;
            
            prev.next = new ListNode(lastDigit);
            prev = prev.next;
            if(c1!= null){
                c1 = c1.next;
            }
            
            if(c2 != null){
                c2 = c2.next;
            }
        }
        return reverse(dummy.next);
    }
}

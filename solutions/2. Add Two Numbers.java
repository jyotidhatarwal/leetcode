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
    private ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode forward = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forward;
        }
        return prev;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       if(l1 == null || l2 == null){
           return l1 != null ? l1 : l2;
       }
        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        int carry =0;
        while(c1 != null || c2 != null || carry != 0){
            int sum = (c1 != null ? c1.val : 0) + (c2 != null ? c2.val : 0) + carry;
            int digit = sum % 10;
            carry = sum / 10;
             ListNode temp = new ListNode(digit);
            prev.next = temp;
            prev = prev.next;
            if(c1 != null){
                c1 = c1.next;
            }
            if(c2 != null){
                c2 = c2.next;
            }
            
        }
        return dummy.next;
    }
}

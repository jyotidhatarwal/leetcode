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
    private ListNode midOfLL(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    private ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode prev = null;
        ListNode curr =head;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next ==null){
            return true;
        }
        ListNode mid = midOfLL(head);
        ListNode newHead = mid.next;
        mid.next = null;
        newHead = reverse(newHead);
        ListNode current1 = head;
        ListNode current2 = newHead;
        boolean result = true;
        while(current2 != null){
            if(current1.val != current2.val){
                result = false;
                break;
            }
            current1 = current1.next;
            current2 = current2.next;
        }
        newHead = reverse(newHead);
        mid.next = newHead;
        return result;
        
    }
}

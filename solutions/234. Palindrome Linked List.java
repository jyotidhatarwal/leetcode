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
        if(head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    private ListNode reverse(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode mid = midOfLL(head);
        ListNode newHead = mid.next;
        mid.next = null;
        newHead = reverse(newHead);
        ListNode c1 = head;
        ListNode c2 = newHead;
        boolean result = true;
        while(c2 != null){
            if(c1.val != c2.val){
                result = false;
                break;
            }
            c1 = c1.next;
            c2 = c2.next;
        }
        newHead = reverse(newHead);
        mid.next = newHead;
        return result;
    }
}

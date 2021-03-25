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
    ListNode tempHead = null;
    ListNode tempTail = null;
    public void addFirstNode(ListNode node){
        if(tempHead == null){
            tempHead = node;
            tempTail = node;
        }else{
            node.next = tempHead;
            tempHead = node;
        }
    }
    public int length(ListNode node){
        ListNode curr = node;
        int len =0;
        while(curr != null){
            curr = curr.next;
            len++;
        }
        return len;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k==0) return head;
        ListNode curr = head;
        ListNode originalHead = null;

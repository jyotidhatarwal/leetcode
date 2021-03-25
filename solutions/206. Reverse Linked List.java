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
    public void addFirst(ListNode node){
        if(node == null){
            tempHead = node;
            tempTail = node;
        }else{
            node.next = tempHead;
            tempHead = node;
        }
    }
    public ListNode reverseList(ListNode head) {
​
        ListNode curr = head;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = null;
            addFirst(curr);
            curr = next;
        }
        return tempHead;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        ListNode t1 = headA;
        ListNode t2 = headB;
        while(t1 != t2){
            if(t1 != null){
                t1 = t1.next;
            }else{
                t1 = headB;
            }
            if(t2 != null){
                t2 = t2.next;
            }else{
                t2 = headA;
            }
        }
        return t1;
        
    }
}

/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */

/**
 * @param {ListNode} headA
 * @param {ListNode} headB
 * @return {ListNode}
 */
var getIntersectionNode = function(headA, headB) {
    /* 
    Steps:
    1) Calculate the length of 1 and 2 nd list
    2) find the difference of lengths
    3) move the pointer of big list the difference ahead
    4) check for the intersection
    T- O(m+n)
    S- O(1)
     */

     let lengthA = 0;
     let pA = headA;
     while(pA !== null){
        lengthA++;
        pA = pA.next
     }

     let lengthB = 0;
     let pB = headB;
     while(pB !== null){
        lengthB++;
        pB = pB.next
     }
     let diff = Math.abs(lengthA - lengthB);

    // I want - 1st list is small and 2nd list is large
     if(lengthA > lengthB){
        // 1st list is longer
        // swap the list for the above behaviour
        let temp = headA;
        headA = headB;
        headB = temp;
     }

     // 1st list is small and 2nd list is large
     for(let i=0;i<diff;i++){
        headB = headB.next;
     }
     pA = headA;
     pB = headB;
     while(pA != pB){
        pA = pA.next;
        pB = pB.next;
     }
     return pA;

};
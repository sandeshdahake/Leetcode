package linkedList;
/**
 * https://leetcode.com/explore/learn/card/linked-list/214/two-pointer-technique/1296/
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 * Example 2:
 *
 * Input: head = [1], n = 1
 * Output: []
 * Example 3:
 *
 * Input: head = [1,2], n = 1
 * Output: [1]
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is sz.
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 *
 *
 * Follow up: Could you do this in one pass?

 */
public class Remove_Nth_Node_From_End_of_List {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null){
            return null;
        }

        if(head.next == null && n==1){
            return null;
        }
        int size = 1;
        ListNode curr = head;
        ListNode nthNode = head;
        ListNode preNode = null;
        while(curr.next != null){
            if(size >= n){
                preNode = nthNode;
                nthNode = nthNode.next;
            }
            curr = curr.next;
            size++;
        }
        if(preNode == null){
            return head.next;
        }
        preNode.next = nthNode.next;

        return head;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}

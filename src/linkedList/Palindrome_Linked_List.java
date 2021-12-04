    package linkedList;

    /**
     * https://leetcode.com/problems/palindrome-linked-list/
     * Given the head of a singly linked list, return true if it is a palindrome.
     *
     *
     *
     * Example 1:
     *
     *
     * Input: head = [1,2,2,1]
     * Output: true
     * Example 2:
     *
     *
     * Input: head = [1,2]
     * Output: false
     *
     *
     * Constraints:
     *
     * The number of nodes in the list is in the range [1, 105].
     * 0 <= Node.val <= 9
     *
     *
     * Follow up: Could you do it in O(n) time and O(1) space?
     */
    public class Palindrome_Linked_List {
        public boolean isPalindrome(ListNode head) {
            if(head.next == null) {
                return true;
            }
            ListNode fast = head;
            ListNode slow = head;
            ListNode prev = null;

            while(fast != null && fast.next != null) {
                fast = fast.next.next;
                ListNode temp = slow.next;
                slow.next = prev;
                prev = slow;
                slow = temp;
            }
            if(fast != null) {
                slow = slow.next;
            }
            while(slow != null) {
                if(slow.val != prev.val) {
                    return false;
                }
                slow = slow.next;
                prev = prev.next;
            }
            return true;
        }

    }

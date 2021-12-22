package ds.linkedList;

/**
 * https://leetcode.com/explore/learn/card/linked-list/213/conclusion/1295/
 * Given the head of a linked list, rotate the list to the right by k places.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [4,5,1,2,3]
 * Example 2:
 *
 *
 * Input: head = [0,1,2], k = 4
 * Output: [2,0,1]
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [0, 500].
 * -100 <= Node.val <= 100
 * 0 <= k <= 2 * 109
 */
public class Rotate_List {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode fake = new ListNode(-1), slow = fake, fast = fake;
        fake.next = head;

        int len = 0;
        while(fast.next != null){   // fast REACH tail && Count len
            fast = fast.next; len++;
        }
        if(len == 0) return null;   // CHECK null

        k %= len;
        for(int i=0; i<len-k; i++)  // slow REACH before the rotated point
            slow = slow.next;

        fast.next = fake.next;      // CONNECT
        fake.next = slow.next;
        slow.next = null;

        return fake.next;
    }
}

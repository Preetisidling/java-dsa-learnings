/**
 * Problem: Detect if a linked list has a cycle.
 *
 * Approach: Floyd's Cycle Detection (slow and fast pointers).
 *   - Slow moves 1 step, fast moves 2 steps.
 *   - If they meet, there's a cycle.
 *
 * Time: O(n) | Space: O(1)
 */
public class DetectCycle {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = head.next; // cycle: 4 -> 2

        System.out.println("Has cycle: " + hasCycle(head));
        // Output: true

        ListNode noCycle = new ListNode(1);
        noCycle.next = new ListNode(2);
        System.out.println("Has cycle: " + hasCycle(noCycle));
        // Output: false
    }
}

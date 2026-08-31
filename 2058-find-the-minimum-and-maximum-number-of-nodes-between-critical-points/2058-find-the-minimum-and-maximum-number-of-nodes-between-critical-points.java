/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int first = -1;
        int prevCritical = -1;
        int minDist = Integer.MAX_VALUE;
        int index = 1;
        ListNode prev = head;
        ListNode curr = head.next;
        while (curr != null && curr.next != null) {
            int a = prev.val;
            int b = curr.val
            int c = curr.next.val;
            if ((b > a && b > c) || (b < a && b < c)) {
                if (first == -1) {
                    first = index;
                }
                if (prevCritical != -1) {
                    minDist = Math.min(minDist, index - prevCritical);
                }
                prevCritical = index;
            }
            prev = curr;
            curr = curr.next;
            index++;
        }
        if (first == -1 || first == prevCritical) {
            return new int[]{-1, -1};
        }
        int maxDist = prevCritical - first;
        return new int[]{minDist, maxDist};
    }
}
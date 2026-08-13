// 24. Swap Nodes in Pairs
// Solved
// Medium
// Topics
// premium lock icon
// Companies
// Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)


class Solution {
    private void reverse(ListNode head, int size) {
        ListNode prev = null;
        ListNode curr = head;
        while (size-- > 0) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
    }
    public ListNode swapPairs(ListNode head) {
        if (head == null)
            return head;

        int size = 2;
        ListNode left = head;
        ListNode right;
        ListNode res = null;
        ListNode prevLeft = null;

        while (true) {
            right = left;
            for (int i = 0; i < size - 1; i++) {
                if (right == null)
                    break;

                right = right.next;
            }

            if (right != null) {

                ListNode nextLeft = right.next;

                reverse(left, size);

                if (prevLeft != null)
                    prevLeft.next = right;

                if (res == null)
                    res = right;

                left.next = nextLeft;

                prevLeft = left;
                left = nextLeft;

            } else {

                if (prevLeft != null)
                    prevLeft.next = left;

                if (res == null)
                    res = left;

                break;
            }
        }

        return res;
    }
}
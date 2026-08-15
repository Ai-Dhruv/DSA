// 25. Reverse Nodes in k-Group
// Solved
// Hard
// Topics
// premium lock icon
// Companies
// Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.

// k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

// You may not alter the values in the list's nodes, only nodes themselves may be changed.

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
    public ListNode reverseKGroup(ListNode head, int k){
        if (head == null)
            return head;

        int size = k;
        ListNode left = head;
        ListNode right;
        ListNode res = null;
        ListNode prevLeft = null;

        while (true) {
            right = left;
            for (int i = 0; i < size - 1; i++){
                if (right == null)
                    break;

                right = right.next;
            }
            if (right != null){
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
// 92. Reverse Linked List II
// Solved
// Medium
// Topics
// premium lock icon
// Companies
// Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.


class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }
        ListNode temp = head;
        ListNode before = null;
        int pos = 1;

        while (temp != null) {
            if (pos < left) {
                before = temp;
                temp = temp.next;
                pos++;
                continue;
            }
            // pos == left
            ListNode curr = temp;
            ListNode prev = null;
            int times = right - left + 1;

            while (times-- > 0) {
                ListNode nex = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nex;
            }
            temp.next = curr;
            if (before != null) {
                before.next = prev;
                return head;
            } else {
                head = prev;
                return head;
            }
        }
        return head;
        
    }
}
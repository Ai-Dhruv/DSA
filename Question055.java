// 61. Rotate List
// Solved
// Medium
// Topics
// premium lock icon
// Companies
// Given the head of a linked list, rotate the list to the right by k places.

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null){
            return null;
        }
        ListNode last = head;
        int n = 1;
        while(last.next != null){
            n++;
            last = last.next;
        }
        k = k % n;
        if(k==0){
            return head;
        }

        int count = 1;
        ListNode temp = head;

        while(temp != null){
            if(count == (n-k)){
                break;
            }
            count++;
            temp = temp.next;
        }

        last.next = head;
        ListNode res = temp.next;

        temp.next = null;

        return res;
    }
}
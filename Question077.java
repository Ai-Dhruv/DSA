// 23. Merge k Sorted Lists
// Solved
// Hard
// Topics
// premium lock icon
// Companies
// You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

// Merge all the linked-lists into one sorted linked-list and return it.

class Solution {

    class Comp implements Comparator<ListNode> {
        public int compare(ListNode a, ListNode b) {
            return a.val - b.val;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode>pq = new PriorityQueue<>(new Comp());

        for(int i=0; i<lists.length ; i++){
            if(lists[i] != null){
                pq.add(lists[i]);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while(!pq.isEmpty()){
            ListNode node = pq.poll();

            tail.next=node;
            tail = tail.next;

            if(node.next != null){
                pq.add(node.next);
            }
        }
        return dummy.next;
    }
}
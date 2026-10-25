
// Code
// Code
// Accepted
// Testcase
// Testcase
// Test Result
// 621. Task Scheduler
// Solved
// Medium
// Topics
// premium lock icon
// Companies
// Hint
// You are given an array of CPU tasks, each labeled with a letter from A to Z, and a number n. Each CPU interval can be idle or allow the completion of one task. Tasks can be completed in any order, but there's a constraint: there has to be a gap of at least n intervals between two tasks with the same label.

// Return the minimum number of CPU intervals required to complete all tasks.


class Solution {
    class Pair{
            int first;
            char second;
            Pair(int first,char second){
                this.first = first;
                this.second = second;
            }
        } 
    public int leastInterval(char[] tasks, int gap) {
        int n= tasks.length;

        HashMap<Character,Integer>freq = new HashMap<>();
        HashMap<Character,Integer>free = new HashMap<>();

        //freq count + initial task 
        for(int i=0; i<n; i++){
            freq.put(tasks[i], freq.getOrDefault(tasks[i], 0) + 1);
            free.put(tasks[i],1);
        }
        //Max heap

        PriorityQueue<Pair>pq = new PriorityQueue<>(
            (a,b) -> b.first - a.first
        );

        //put all task into max heap
        for(char ch : freq.keySet()){
            pq.add(new Pair(freq.get(ch),ch));
        }
        // current seat
        int seat = 1;

        //check that tasks are available 
        while(!pq.isEmpty()){
            // temporary store
            ArrayList<Pair>pulled = new ArrayList<>();

            while(!pq.isEmpty()){
                //highest freq wala task nikalo
                Pair p = pq.poll();

                int frequency = p.first;
                char child = p.second;

                // check= ye k tk execute hoga
                if(free.get(child) <= seat){
                    if(p.first > 1){
                        pq.add(new Pair(p.first - 1, p.second));
                    }
                    free.put(child,seat+gap+1);
                    break;
                }

                pulled.add(p);
            }
            for(int i=0; i<pulled.size(); i++){
                pq.add(pulled.get(i));
            }
            seat++;
        }
        return seat -1;
    }
}
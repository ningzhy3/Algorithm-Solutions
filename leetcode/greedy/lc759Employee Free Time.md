```java
/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/

class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        Queue<Interval> q = new PriorityQueue<>((a,b)->(a.start-b.start));
        schedule.forEach(e->q.addAll(e));
        List<Interval> res = new ArrayList<>();
        
        Interval temp = q.poll();
        while (!q.isEmpty()) {
            if (temp.end < q.peek().start) {
                Interval inter = new Interval(temp.end, q.peek().start);
                res.add(inter);
                temp = q.peek();
            } else {
                if (temp.end < q.peek().end) temp = q.peek();
            }
            q.poll();
        }
        return res;
    }
}
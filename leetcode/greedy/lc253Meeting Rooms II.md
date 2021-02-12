```java
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int res = 0;
        Arrays.sort(intervals, (a, b)->(a[0]-b[0]));
        Queue<Integer> q = new PriorityQueue<>();
        for (int[] interval : intervals) {
            if (q.isEmpty() || q.peek() > interval[0]) res++;
            else q.poll();
            q.add(interval[1]);   
        }
        return res;
    }
}
// 使用start时间排序，使用结束时间作为放在heap中的数值，每次查看heap中的最小值，用来判断是否增加room

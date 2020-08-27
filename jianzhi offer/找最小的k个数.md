# 找最小的k个数

```java
import java.util.*;

public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if (k > input.length) return res;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int a : input) {
            minHeap.add(a);
        }
       
        
        while (k-->0) {
            res.add(minHeap.poll());
        }
        return res;
    }
}
```

使用最小堆保存数组，取k次最小堆顶部的元素


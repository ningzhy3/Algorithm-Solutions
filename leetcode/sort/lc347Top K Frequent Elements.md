```java

// 将频率作为元素，对于每个频率相同的数字，放到相同的buckets里面
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap();
        for (int num : nums) map.put(num, map.getOrDefault(num, 0)+1);

        List<Integer>[] buckets = new List[nums.length+1];
        for (int key : map.keySet()) {
            int fre = map.get(key);
            if (buckets[fre] == null) buckets[fre] = new ArrayList<>();
            buckets[fre].add(key);
        }
        List<Integer> res = new LinkedList<>();
        for (int i = buckets.length-1; i>=0; i--) {
            if (res.size() < k && buckets[i] != null) res.addAll(buckets[i]);
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) ans[i] = res.get(i);
        return ans;
    }

}
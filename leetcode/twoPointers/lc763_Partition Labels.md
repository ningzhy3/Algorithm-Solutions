```java
class Solution {
    public List<Integer> partitionLabels(String S) {
        int[] map = new int[26];
        for (int i = 0; i < S.length(); i++) {
            map[S.charAt(i)-'a'] = i;
        }
        List<Integer> res = new ArrayList<>();
        
        int left = 0;
        int right = 0;
        while (right < S.length()) {
            int start = left;
            right = map[S.charAt(right)-'a'];
            while (left < right) {
                if (map[S.charAt(left)-'a']>right) right = map[S.charAt(left)-'a'];
                left++;
            }
            left++;
            right++;
            res.add(right-start);
        }
        return res;
    }
}

// 保持当前right为最大的可能索引，移动left，当left == right时进行分割
// 滑动窗口算法
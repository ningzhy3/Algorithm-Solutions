```java
public class Solution {
    public String minWindow(String s, String t) {
        // corner cases
        if (s == null || s.length() < t.length() || s.length() == 0) return "";
        // map stores all the characters in t
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        // two pointers left and right, the result tuple
        int left = 0;
        int minLeft = 0;
        int minLen = s.length()+1;
        int count = 0;
        
        for (int right = 0; right <s.length(); right++) {
            if (map.containsKey(s.charAt(right))) {
                map.put(s.charAt(right), map.get(s.charAt(right))-1);
                // expand the window
                if (map.get(s.charAt(right))>=0) count++;
            }
                // while the window contains all the characters in t
                // shrink the window
            while (count == t.length()) {
                // update the res tuple
                if (right-left+1<minLen) {
                    minLeft = left;
                    minLen = right-left+1;
                }
                if (map.containsKey(s.charAt(left))) {
                    map.put(s.charAt(left), map.get(s.charAt(left))+1);
                    // update the characters in the map
                    if (map.get(s.charAt(left))>0) count--;
                }
                left++;
            }
        }
        if (minLen>s.length()) return "";
        return s.substring(minLeft, minLeft+minLen);
    }
}
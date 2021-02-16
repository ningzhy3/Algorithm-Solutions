```java
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        // set.add(endWord);
        set.remove(beginWord);
        int level = 1;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String str = queue.poll();
                if (str.equals(endWord)) return level;
                for (String neb : neighbors(str, set)) queue.offer(neb);
            }
            level++;
        }
        return 0;
    }
    public List<String> neighbors(String s, Set<String> set) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char[] chars = s.toCharArray();
            for (char ch = 'a'; ch <= 'z'; ch++) {
                chars[i] = ch;
                String word = new String(chars);
                if (set.remove(word)) res.add(word);
            }
        }
        return res;
    }
}

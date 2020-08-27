 # Longest Word in Dictionary through Deleting

```java
class Solution {
    public String findLongestWord(String s, List<String> d) {
      //find all the strings in the list that statisfy the constraints
        List<String> list = new ArrayList<>();
        for (String word : d) {
            if (findSame(s, word)) list.add(word);
        }
      //sort the list and find the longest string with the smallest lexicographical order
        list.sort(Comparator.comparing((String str)->(-1*str.length())).thenComparing(String::toString));
        if (list.size() == 0) return "";
        return list.get(0);
    }
  // check if word can be replaced by deleting some characters
    public boolean findSame(String s, String word){
        int l1 = s.length();
        int l2 = word.length();
        if (l1 < l2) return false;
        int i = 0;
        int j = 0;
        while (i < l1 && j < l2) {
            char a = s.charAt(i);
            char b = word.charAt(j);
            if (a == b) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        if (j == l2) return true;
        else return false;
    }
}
```


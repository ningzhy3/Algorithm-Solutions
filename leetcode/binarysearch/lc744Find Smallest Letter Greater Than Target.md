```java
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length-1;
        int pivot = 0;
        while (left <= right) {
            pivot = (right - left)/2+left;
            if (letters[pivot] <= target) left = pivot + 1;
            else if (letters[pivot] > target) right = pivot - 1;
        }
        return left > letters.length-1? letters[0] : letters[left];
    }
}
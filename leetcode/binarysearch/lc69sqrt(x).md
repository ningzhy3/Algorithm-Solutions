```java
class Solution {
    public int mySqrt(int x) {
        if (x < 2) return x;
        long num;
        int pivot = 2;
        int left  = 2;
        int right = x/2;
        while (left <= right) {
            pivot = (right-left)/2+left;
            num = (long)pivot*pivot;
            if (num > x) right = pivot-1;
            else if (num < x) left = pivot+1;
            else return pivot;
        }
        return right;
    }
}


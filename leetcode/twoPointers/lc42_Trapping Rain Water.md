```java
class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length-1;
        int left_max = 0;
        int right_max = 0;
        int res = 0;
        
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] < left_max) res += left_max - height[left];
                else left_max = height[left];
                left++;
            } else {
                if (height[right]  < right_max) res += right_max - height[right];
                else right_max = height[right];
                right--;
            }
        }
        return res;
    }
}
// 左右各一个指针，向中间移动
// while中的if相当于固定一端，移动另一端

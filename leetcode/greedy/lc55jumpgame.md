```java
class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int pos = n-1;
        for (int i = n-1; i >= 0; i--) {
            if ((nums[i] + i) >= pos) pos = i;
        }
        return pos == 0;
    }
}

// 从后往前，检查是否能跳过去
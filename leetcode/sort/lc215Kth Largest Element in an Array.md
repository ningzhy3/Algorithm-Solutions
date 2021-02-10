```java
class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, nums.length-k, 0, nums.length-1);
    }

    public int quickSelect(int[] nums, int k, int start, int end) {
        if (start > end) return 0;
        // 随机选择一个index作为pivot，与end交换
        Random random_num = new Random();
        
        if (end != start) {
            int pivot_index = start + random_num.nextInt(end - start); 
            swap(pivot_index, end, nums);
        }
        int pivot = nums[end];
        
        int left = start;
        for (int i = start; i < end; i++) {
            if (nums[i] <= pivot) swap(i, left++, nums);
        }
        swap(end, left, nums);

        if (left == k) return nums[left];
        else if (left < k) {
            return quickSelect(nums, k, left+1, end);
        } else {
            return quickSelect(nums, k, start, left-1);
        }
    }

    public void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

// 类似于快速排序，每次选择pivot，左边为小于pivot的值，右边为大于pivot的值

// 快速选择也可以求解 TopK Elements 问题，因为找到 Kth Element 之后，再遍历一次数组，所有小于等于 Kth Element 的元素都是 TopK Elements。
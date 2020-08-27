# 寻找数字k在数组中出现的次数

```java
public int binarySearch(int[] nums, int k) {
    int l = 0;
    int h = nums.length;
    while (l < h) {
        int m = l + (h-l)/2;
        if (nums[m] >= k) h = m;
        else l = m + 1;
    }
    return l;
}

public int GetNumberOfK(int[] nums, int k) {
    int first = binarySearch(nums, k);
    int last = binarySearch(nums, k+1);

    return (first == nums.length || nums[first] != k)? 0 : last - first;
}
```

使用二分搜索

1. 先搜索k：得到k的最左边的索引，在中间数大于等于k时，继续搜索左边部分数组
2. 搜索k+1得到第一个不为k的数字的索引
3. 判断k是否大于所有的数字和判断k存在数组中
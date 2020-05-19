package leetcode.array;

import java.util.Arrays;

/**
 * <p>给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。</p>
 * <p>要求使用空间复杂度为 O(1) 的 原地 算法</p>
 * */
public class Rotate {

  public static void rotate(int[] nums, int k) {
    if (nums.length < 2) {
      return;
    }
    int t = k % nums.length;
    for (int i = 0; i < t; i++) {
      int temp = nums[nums.length - 1];
      for (int j = nums.length - 2; j >= 0; j--) {
        nums[j + 1] = nums[j];
      }
      nums[0] = temp;
    }
  }

    public static void rotate2(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }

  public static void main(String[] args) {
    int[] nums = new int[] {1,2,3,4,5,6,7};
//    rotate(nums, 3);
    rotate2(nums, 3);
    System.out.println(Arrays.toString(nums));
  }
}

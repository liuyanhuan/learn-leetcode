package leetcode.array;

import java.util.HashSet;

/**
 * <p>给定一个整数数组，判断是否存在重复元素。</p>
 * <p>如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。</p>
 */
public class ContainsDuplicate {

  public static boolean containsDuplicate(int[] nums) {
    HashSet<Integer> set = new HashSet<>();
    for (int num : nums) {
      if (set.contains(num)) {
        return true;
      }
      set.add(num);
    }
    return false;
  }

  public static void main(String[] args) {
    int[] nums = new int[] {1,2,3,1};
    System.out.println(containsDuplicate(nums));
  }
}

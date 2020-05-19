package leetcode.array;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 给定一个整数数组，判断是否存在重复元素。
 *
 * <p>如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 */
public class PlusOne {

  public static int[] plusOne(int[] digits) {
    StringBuilder sb = new StringBuilder();
    for (int num : digits) {
      sb.append(num);
    }
    BigInteger big = new BigInteger(sb.toString());
    BigInteger add = big.add(BigInteger.ONE);
    String s = String.valueOf(add);
    int[] result = new int[s.length()];
    for (int i = 0; i < s.length(); i++) {
      result[i] = Integer.parseInt(String.valueOf(s.charAt(i)));
    }
    return result;
  }

  public static int[] plusOne2(int[] digits) {
    for (int i = digits.length - 1; i >= 0; i--) {
      digits[i]++;
      digits[i] = digits[i] % 10;
      if (digits[i] != 0) return digits;
    }
    digits = new int[digits.length + 1];
    digits[0] = 1;
    return digits;
  }

  public static void main(String[] args) {
    int[] nums = new int[] {1, 2, 2, 4};
    System.out.println(Arrays.toString(plusOne(nums)));
  }
}

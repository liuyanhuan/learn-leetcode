package leetcode.string;

/**
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 *
 * <p>1. 1
 *
 * <p>2. 11
 *
 * <p>3. 21
 *
 * <p>4. 1211
 *
 * <p>5. 111221
 *
 * <p>1 被读作 "one 1" ("一个一") , 即 11
 *
 * <p>11 被读作 "two 1s" ("两个一"）, 即 21。
 *
 * <p>21 被读作 "one 2", "one 1" （"一个二" , "一个一") , 即 1211。
 *
 * <p>给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
 */
public class CountAndSay {
  public static String countAndSay(int n) {
    if (n == 1) {
      return "1";
    }
    String s1 = countAndSay(n - 1);
    StringBuilder s2 = new StringBuilder();
    int count = 1;
    for (int i = 0; i < s1.length() - 1; i++) {
      if (s1.charAt(i) == s1.charAt(i + 1)) {
        count++;
      } else {
        s2 = s2.append(count).append(s1.charAt(i));
        count = 1;
      }
    }
    s2 = s2.append(count).append(s1.charAt(s1.length() - 1));
    return s2.toString();
  }

  public static void main(String[] args) {
    String s = countAndSay(5);
    System.out.println(s);
  }
}

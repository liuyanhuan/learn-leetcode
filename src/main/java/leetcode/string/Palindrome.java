package leetcode.string;

/** 回文字符串 */
public class Palindrome {

  public static boolean isPalindrome(String s) {
    String s1 = s.replaceAll("[^a-z|A-Z|0-9]", "");
    for (int i = 0; i < s1.length() / 2; i++) {
      if (!String.valueOf(s1.charAt(i))
          .equalsIgnoreCase(String.valueOf(s1.charAt(s1.length() - 1 - i)))) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    System.out.println(isPalindrome("race a car"));
  }
}

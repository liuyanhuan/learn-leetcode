package leetcode.string;

public class LongestCommonPrefix {

  public static String longestCommonPrefix(String[] strs) {
    /** 方法一：水平扫描法 */
//    if (strs.length == 0) return "";
//    String prefix = strs[0];
//    for (int i = 1; i < strs.length; i++) {
//      while (strs[i].indexOf(prefix) != 0) {
//        prefix = prefix.substring(0, prefix.length() - 1);
//        if (prefix.isEmpty()) return "";
//      }
//    }
//    return prefix;

      /**
       * 方法二：优化的水平扫描
       */
      if (strs == null || strs.length == 0) return "";
      for (int i = 0; i < strs[0].length() ; i++){
          char c = strs[0].charAt(i);
          for (int j = 1; j < strs.length; j ++) {
              if (i == strs[j].length() || strs[j].charAt(i) != c)
                  return strs[0].substring(0, i);
          }
      }
      return strs[0];
  }

  public static void main(String[] args) {
    String s = longestCommonPrefix(new String[] {"abc", "abd", "abcd"});
    System.out.println(s);
  }
}

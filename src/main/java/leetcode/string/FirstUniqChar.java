package leetcode.string;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * <p>设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *
 * <p>注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 */
public class FirstUniqChar {

  public static int firstUniqChar(String s) {
    Map<Character, List<Integer>> map = new LinkedHashMap<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (map.containsKey(c)) {
        map.get(c).add(i);
      } else {
        List<Integer> list = new ArrayList<>();
        list.add(i);
        map.put(c, list);
      }
    }
    // 判断map中所有的元素，是否有多个
    for (List<Integer> value : map.values()) {
      if (value.size() == 1) {
        return value.get(0);
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    String s = "loveleetcode";
    int i = firstUniqChar(s);
    System.out.println(i);
  }
}

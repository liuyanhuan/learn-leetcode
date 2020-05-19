package leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>字母异位词</p>
 * <p>给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。</p>
 * <p>示例：</p>
 * <p>输入: s = "anagram", t = "nagaram" 输出: true </p>
 * <p>输入: s = "rat", t = "car" 输出: false </p>
 */
public class Anagram {

    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for(int i=0; i < s.length(); i++) {
            char c = s.charAt(i);
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }
        for(int i=0; i < t.length(); i++) {
            char c = t.charAt(i);
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }
        if(map1.size() != map2.size()) {
            return false;
        }
        for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
            Character key1 = entry.getKey();
            if (!map2.containsKey(key1)) {
                return false;
            }
            if (!entry.getValue().equals(map2.get(key1))) {
                return false;
            }
        }
        return true;
    }
}

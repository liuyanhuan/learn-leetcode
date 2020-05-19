package leetcode.string;

/**
 * 实现 strStr() 函数。
 *
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 */
public class StrStr {
    public static int strStr(String haystack, String needle) {
        int targetCount = needle.length();
        int sourceCount = haystack.length();
        if (targetCount == 0) {
            return 0;
        }

        char first = needle.charAt(0);
        int max = sourceCount - targetCount;

        for (int i = 0; i <= max; i++) {
            /* Look for first character. */
            if (haystack.charAt(i) != first) {
                while (++i <= max && haystack.charAt(i) != first);
            }
            /* Found first character, now look at the rest of v2 */
            if (i <= max) {
                int j = i + 1;
                int end = j + targetCount - 1;
                for (int k = 0 + 1; j < end && haystack.charAt(j)
                        == needle.charAt(k); j++, k++);

                if (j == end) {
                    /* Found whole string. */
                    return i;
                }
            }
        }
        return -1;
    }
}

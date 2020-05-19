package leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * <P>暴力解法不用写了，看官方解法，学习 确定有限自动机(DFA)</P>
 *
 * <p>请你来实现一个 atoi 函数，使其能将字符串转换成整数。</P>
 *
 * <p>首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。接下来的转化规则如下：</P>
 *
 * <p>如果第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字字符组合起来，形成一个有符号整数。 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成一个整数。
 * 该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，它们对函数不应该造成影响。
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换，即无法进行有效转换。</P>
 *
 * <p>在任何情况下，若函数不能进行有效的转换时，请返回 0 。</P>
 *
 * <p>提示：</P>
 *
 * <p>本题中的空白字符只包括空格字符 ' ' 。 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231, 231 − 1]。如果数值超过这个范围，请返回 INT_MAX
 * (231 − 1) 或 INT_MIN (−231) 。</P>
 */
public class Atoi {
    public static int myAtoi(String str) {
        Automaton automaton = new Automaton();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            automaton.get(c);
        }
        return (int) (automaton.sign * automaton.ans);
    }

  public static void main(String[] args) {
      int i = myAtoi(" -43");
    System.out.println(i);
  }
}

class Automaton {
    private String state = START;
    public long ans = 0;
    public int sign = 1;
    private static final String START = "start";
    private static final String SIGNED = "signed";
    private static final String IN_NUMBER = "in_number";
    private static final String END = "end";
    private static final Map<String, String[]> table = new HashMap<>(8);
    static {
        table.put(START, new String[]{START, SIGNED, IN_NUMBER, END});
        table.put(SIGNED, new String[]{END, END, IN_NUMBER, END});
        table.put(IN_NUMBER, new String[]{END, END, IN_NUMBER, END});
        table.put(END, new String[]{END, END, END, END});
    }

    private int getCol(char c) {
        if (c == ' ') return 0;
        if (c == '+' || c == '-') return 1;
        if (c >= '0' && c <= '9') return 2;
        return 3;
    }

    public void get(char c) {
        state = table.get(state)[getCol(c)];
        if (IN_NUMBER.equals(state)) {
            ans = ans * 10 + c - '0';
            ans = sign == 1 ? Math.min(ans, Integer.MAX_VALUE) : Math.min(ans, -(long)Integer.MIN_VALUE);
        }
        if (SIGNED.equals(state)) {
            sign = c == '+' ? 1 : -1;
        }
    }
}

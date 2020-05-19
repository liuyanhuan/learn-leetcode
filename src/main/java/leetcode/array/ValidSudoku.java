package leetcode.array;

import java.util.HashMap;

/**
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 *
 * <p>数字 1-9 在每一行只能出现一次。 数字 1-9 在每一列只能出现一次。 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。 数独部分空格内已填入了数字，空白格用 '.'
 * 表示。
 *
 * <p>一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 给定数独序列只包含数字 1-9 和字符 '.' 。
 * 给定数独永远是 9x9 形式的。
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Character, Integer>[] rows = new HashMap[9];
        HashMap<Character, Integer>[] columns = new HashMap[9];
        HashMap<Character, Integer>[] boxes = new HashMap[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<Character, Integer>();
            columns[i] = new HashMap<Character, Integer>();
            boxes[i] = new HashMap<Character, Integer>();
        }

        for(int i = 0; i < 9; i ++){
            for(int j = 0; j < 9; j ++){
                char n = board[i][j];
                if(n != '.') {
                    int k = (i/3)*3 + j/3;
                    rows[i].put(n, rows[i].getOrDefault(n, 0) + 1);
                    columns[j].put(n, columns[j].getOrDefault(n, 0) + 1);
                    boxes[k].put(n, boxes[k].getOrDefault(n, 0) + 1);
                    if(rows[i].get(n) > 1 || columns[j].get(n) > 1 || boxes[k].get(n) > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}

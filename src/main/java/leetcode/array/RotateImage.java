package leetcode.array;

/**
 * 给定一个 n × n 的二维矩阵表示一个图像。
 *
 * <p>将图像顺时针旋转 90 度。
 */
public class RotateImage {
  public void rotate(int[][] matrix) {
    int n = matrix.length;
    // transpose matrix
    for (int i = 0; i < n; i++) {
      for (int j = i; j < n; j++) {
        int tmp = matrix[j][i];
        matrix[j][i] = matrix[i][j];
        matrix[i][j] = tmp;
      }
    }
    // reverse each row
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n / 2; j++) {
        int tmp = matrix[i][j];
        matrix[i][j] = matrix[i][n - j - 1];
        matrix[i][n - j - 1] = tmp;
      }
    }
  }
}

import java.util.*;

public class ch01q06 {
    public static void main(String[] args){
      System.out.printf("Question: int[][] matrix rotate by 90 degrees\n");

      int[][] test1 = {{0,1,2,3}, {11,1,0,4}, {10,0,1,5}, {9,8,7,6}};
      rotate(test1);
      printMatrix(test1);
    }

    public static void printMatrix(int[][] input) {
      for(int i = 0; i < input.length ; i++){
        for(int j = 0; j < input[i].length; j++) {
          System.out.print("  " + input[i][j] + "  ");
        }
        System.out.println("  ");
      }
      System.out.printf("\n\n");
    }

    public static void rotate(int[][] matrix) {
      int len = matrix.length;
      for (int layer = 0; layer < len / 2; ++layer) {
        int first = layer;
        int last = len - 1 - layer;
        for(int i = first; i < last; ++i) {
          int offset = i - first;
          int top = matrix[first][i]; // save top
          // left -> top
          matrix[first][i] = matrix[last-offset][layer];
          // bottom -> left
          matrix[last-offset][layer] = matrix[last][last - offset];
          // right -> bottom
          matrix[last][last - offset] = matrix[i][last];
          // top -> right
          matrix[i][last] = top; // right <- saved top }
        }
      }
    }
}

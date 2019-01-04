import java.util.*;

public class ch01q07 {
    public static void main(String[] args){
      System.out.printf("Question: int[][] matrix set zero containing columns to all zeroes\n");

      int[][] test1 = {{1,1,2,3}, {11,1,2,4}, {10,0,1,5}, {9,8,7,6}};
      setZeroes(test1);
      printMatrix(test1);

      int[][] test2 = {{1,1,2,3}, {11,1,0,4}, {10,0,1,5}, {9,8,7,6}};
      setZeroes(test2);
      printMatrix(test2);

      int[][] test3 = {{1,1,2,3}, {11,1,0,4}, {10,5,1,5}, {9,8,7,6}};
      setZeroes(test3);
      printMatrix(test3);
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

    public static void setZeroes(int[][] matrix) {
      int[][] temp = deepCopyIntMatrix(matrix);
      for(int i = 0; i < temp.length; i++) {
        for(int j = 0; j < temp[i].length; j++) {
          if(temp[i][j] == 0) {
            setRowZeros(matrix, i);
            setColumnZeros(matrix, j);
            break;
          }
        }
      }
      printMatrix(temp);
    }

    public static void setRowZeros(int[][] matrix, int row) {
      for(int i = 0; i < matrix.length ; i++) {
        matrix[row][i] = 0;
      }
    }

    public static void setColumnZeros(int[][] matrix, int column) {
      for(int i = 0; i < matrix.length ; i++) {
        matrix[i][column] = 0;
      }
    }

    public static int[][] deepCopyIntMatrix(int[][] input) {
      if (input == null)
          return null;
      int[][] result = new int[input.length][];
      for (int r = 0; r < input.length; r++) {
          result[r] = input[r].clone();
      }
      return result;
    }
}

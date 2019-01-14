import java.util.*;

public class ch05q01 {
  public static void main(String args[]) {
    System.out.printf("Question: Set bits between i an j to m in n\n");

    System.out.println(updateBits(1024, 21, 2,6));
  }

  public static int updateBits(int n, int m, int i, int j) {
    int max = ~0;
    int left = max - ((1 << j) - 1);
    int right = ((1 << i) - 1);
    int mask = left | right;
    return (n & mask) | (m << i);
  }
}

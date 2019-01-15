import java.util.*;

public class ch05q05 {
  public static void main(String args[]) {
    System.out.printf("Question: Bits required to convert A to B\n");

    System.out.println(bitsRequired(31,14));
  }

  public static int bitsRequired(int a, int b) {
    int count = 0;

    for(int i = a^b; i != 0; i = i >> 1) {
      count += i & 1;
    }

    return count;
  }
}

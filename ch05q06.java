import java.util.*;

public class ch05q06 {
  public static void main(String args[]) {
    System.out.printf("Question: Swap odd and even bits\n");

    System.out.println(swapBits(6));
  }

  public static int swapBits(int num) {
    return ((num & 0xaaaaaaaa) >> 1) | ((num & 0x55555555) << 1);
  }
}

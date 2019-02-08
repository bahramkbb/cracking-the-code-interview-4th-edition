import java.util.*;

public class ch08q01 {
  public static void main(String args[]) {
    System.out.printf("Question: nth Fibonacci\n");

    System.out.println(fibo(6));
    System.out.println(fibo(7));
    System.out.println(fiboIterative(6));
    System.out.println(fiboIterative(7));
  }

  public static int fibo(int num) {
    if(num == 0)
      return 0;
    if(num == 1)
      return 1;
    else
      return fibo(num - 1) + fibo(num - 2);
  }

  public static int fiboIterative(int num) {
    if (num <= 0) return 0;
    int a = 1, b = 1;
    for(int i = 3; i <= num; i++) {
      int c = a + b;
      a = b;
      b = c;
    }
    return b;
  }
}

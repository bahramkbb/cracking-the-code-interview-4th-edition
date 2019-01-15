import java.util.*;

public class ch05q03 {
  public static void main(String args[]) {
    System.out.printf("Question: next smallest and biggest numbers with same 1's\n");

    printNextMinAndMax(4);
    printNextMinAndMax(7);
    printNextMinAndMax(9);
  }

  public static void printNextMinAndMax(int num) {
    HashMap<Integer, Integer> oneCount = new HashMap<Integer,Integer>();

    for(int i = num+1; i < num + 1000 ; i++) {
      int countOnes = binaryRepresenationCountOnes(i);

      if(oneCount.containsKey(countOnes)) {
        System.out.printf("Min: %d, Max: %d, Count:%d\n", oneCount.get(countOnes), i, countOnes);
        break;
      } else {
        oneCount.put(countOnes, i);
      }
    }
  }

  private static int binaryRepresenationCountOnes(int num) {
    int res = 0;

    String presentation = "";

    while(num > 0) {
      int r = num % 2;

      if(r == 0) {
        presentation = "0" + presentation;
      } else {
        presentation = "1" + presentation;
        res++;
      }

      num /= 2;
    }

    return res;
  }
}

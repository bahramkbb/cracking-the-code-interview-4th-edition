import java.util.*;

public class ch01q08 {
    public static void main(String[] args){
      System.out.printf("Question: s1 is a rotation of s2 only with one call to isSubstring\n");

      System.out.printf("Test 1: %s is rotation of %s ? %b\n", "good", "gdoo", isRotation("good", "dgoo"));
      System.out.printf("Test 2: %s is rotation of %s ? %b\n", "book", "booki", isRotation("book", "booki"));
      System.out.printf("Test 3: %s is rotation of %s ? %b\n", "", "", isRotation("", ""));
      System.out.printf("Test 4: %s is rotation of %s ? %b\n", "good", "odgo", isRotation("good", "odgo"));
      System.out.printf("Test 4: %s is rotation of %s ? %b\n", "godod", "oddgo", isRotation("godod", "oddgo"));
    }

    public static boolean isRotation(String s1, String s2) {
      // If length are different, they cant be eachothers rotation
      if (s1 == null ||
          s2 == null ||
          s1.length() != s2.length())
          return false;

      // Add s1 twice to itself
      String s1Temp = s1 + s1;

      // Call isSubstring or immitate its action
      return s1Temp.indexOf(s2) >= 0;
    }
}

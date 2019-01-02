import java.util.*;

public class ch01q03 {
  public static void main(String[] args) {
    System.out.printf("Question: Remove the duplicate characters in a string without using any additional buffer\n");

    char[] test1 = "abcd".toCharArray();
    removeDuplicateCharacters(test1);
    System.out.println(test1);

    test1 = null;
    removeDuplicateCharacters(test1);
//    System.out.println(test1);

    test1 = "aaabbb".toCharArray();
    removeDuplicateCharacters(test1);
    System.out.println(test1);

    test1 = "ababab  ".toCharArray();
    removeDuplicateCharacters(test1);
    System.out.println(test1);

    test1 = "aaaaaaaaaaa".toCharArray();
    removeDuplicateCharacters(test1);
    System.out.println(test1);
  }

  public static void removeDuplicateCharacters(char[] input) {
    if(input == null || input.length <= 1)
      return;

    int tail = 1;
    for(int i = 1; i < input.length; i++) {
      int j = 0;
      for(j = 0; j < tail ; j++) {
        if(input[i] == input[j])
          break;
      }

      if(j == tail) {
        input[tail] = input[i];
        tail++;
      }
    }

    if(tail < input.length)
      input[tail] = '*';
  }

}

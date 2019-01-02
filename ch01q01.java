import java.util.*;

public class ch01q01 {
  public static void main(String[] args) {
    System.out.printf("Question: An algorithm to determine if a string has all unique characters\n");
    System.out.printf("Test 1: %b\n", hasUniqueCharactersV1("TEST CHAR"));
    System.out.printf("Test 2: %b\n", hasUniqueCharactersV1("TES CHAR"));
    System.out.printf("Test 3: %b\n", hasUniqueCharactersV1(""));
    System.out.printf("Test 4: %b\n", hasUniqueCharactersV1(null));
    System.out.printf("Test 5: %b\n", hasUniqueCharactersV1("TTTTTTTT"));
    System.out.printf("Test 6: %b\n", hasUniqueCharactersV1("THIS WARNING"));
  }


  public static boolean hasUniqueCharactersV1(String input) {
    if(input == null || input.length() <= 1) {
      return true;
    }

    HashMap<Character, Integer> charCount = new HashMap<>();
    char[] inputChars = input.toCharArray();

    for(char item: inputChars) {
      if(charCount.containsKey(item)) {
        return false;
      } else {
        charCount.put(item, 1);
      }
    }

    return true;
  }

  public static boolean hasUniqueCharactersV2(String input) {
    if(input == null || input.length() <= 1) {
      return true;
    }

    HashMap<Character, Integer> charCount = new HashMap<>();

    for(int i = 0; i < input.length(); i++) {
      if(charCount.containsKey(input.charAt(i))) {
        return false;
      } else {
        charCount.put(input.charAt(i), 1);
      }
    }

    return true;
  }

  public static boolean hasUniqueCharactersV3(String input) {
    if(input == null || input.length() <= 1) {
      return true;
    }

    boolean[] asciChars = new boolean[256];
    Arrays.fill(asciChars, false);

    for(int i = 0; i < input.length(); i++) {
      int val = input.charAt(i);
      if(asciChars[val])
        return false;
      asciChars[val] = true;
    }

    return true;
  }
}

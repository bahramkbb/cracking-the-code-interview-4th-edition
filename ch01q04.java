import java.util.*;

public class ch01q04 {
    public static void main(String[] args){
      System.out.printf("Question: two strings are anagrams or not\n");


      System.out.printf("Test 1: %b\n", areAnagrams(null,null));
      System.out.printf("Test 2: %b\n", areAnagrams("abc",null));
      System.out.printf("Test 3: %b\n", areAnagrams(null,"abc"));
      System.out.printf("Test 4: %b\n", areAnagrams("a","a"));
      System.out.printf("Test 5: %b\n", areAnagrams("mood","doom"));
      System.out.printf("Test 6: %b\n", areAnagrams("mood","doom "));
      System.out.printf("Test 7: %b\n", areAnagrams("ouuuch","chooouuu"));
      System.out.printf("Test 8: %b\n", areAnagrams("Not","Related"));
    }

    public static boolean areAnagrams(String s1, String s2){
      if(s1 == null || s2 == null) {
        if(s1 == null && s2 == null)
          return true;
        else
          return false;
      }

      HashMap<Character, Integer> s1CharacterCount = new HashMap<>();

      for(char item: s1.toCharArray()){
        if(s1CharacterCount.containsKey(item)) {
          s1CharacterCount.put(item, s1CharacterCount.get(item) + 1);
        } else {
          s1CharacterCount.put(item, 1);
        }
      }

      for(char item: s2.toCharArray()) {
        if(s1CharacterCount.containsKey(item) && s1CharacterCount.get(item) > 1) {
          s1CharacterCount.put(item, s1CharacterCount.get(item) - 1);
        } else if (s1CharacterCount.containsKey(item) && s1CharacterCount.get(item) == 1){
          s1CharacterCount.remove(item);
        } else {
          return false;
        }
      }

      return true;
    }
}

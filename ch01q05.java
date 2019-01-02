import java.util.*;

public class ch01q05 {
    public static void main(String[] args){
      System.out.printf("Question: replace all spaces in a string with `%%20`\n");

      char[] test1 = "ab cd".toCharArray();
      char[] test1res = replaceSpaces(test1);
      System.out.println(test1res);

      char[] test2 = " ".toCharArray();
      char[] test2res = replaceSpaces(test2);
      System.out.println(test2res);

      char[] test3 = "    ".toCharArray();
      char[] test3res = replaceSpaces(test3);
      System.out.println(test3res);

      char[] test4 = "  a  ".toCharArray();
      char[] test4res = replaceSpaces(test4);
      System.out.println(test4res);

      char[] test5 = "abc".toCharArray();
      char[] test5res = replaceSpaces(test5);
      System.out.println(test5res);

      char[] test6res = replaceSpaces(null);
      System.out.println(test6res);
    }

    public static char[] replaceSpaces(char[] input){
        if(input == null)
          return new char[0];
        //Count the spaces
        int initialSpaceCount = 0;
        for(int i = 0; i < input.length; i++) {
          if(input[i] == ' ')
            initialSpaceCount++;
        }

        //Create new array with longer width
        int targetLength = input.length + initialSpaceCount * 2;
        char[] targetArray = new char[targetLength];
        int targetArrayPointer = 0;

        for(int i = 0; i < input.length; i++) {
          if(input[i] != ' ') {
            targetArray[targetArrayPointer] = input[i];
            targetArrayPointer++;
          } else {
            targetArray[targetArrayPointer] = '%';
            targetArrayPointer++;
            targetArray[targetArrayPointer] = '2';
            targetArrayPointer++;
            targetArray[targetArrayPointer] = '0';
            targetArrayPointer++;
          }
        }

        return targetArray;
    }
}

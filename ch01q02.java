
public class ch01q01 {
  public static void main(String[] args) {
    System.out.printf("Question: Reverse a C-Style String\n");

    char[] test = {'a', 'b', 'c', 'd', '*'};
    reverseString(test);
    System.out.println(test);

    char[] test2 = {'a', '*'};
    reverseString(test2);
    System.out.println(test2);

    char[] test3 = {'*'};
    reverseString(test3);
    System.out.println(test3);

    char[] test4 = null;
    reverseString(test4);
  }

  public static void reverseString(char[] input) {
    if(input == null || input.length <= 2) {
      return;
    }

    int i = 0;
    int j = input.length - 2;
    char temp;

    while(i < j) {
      temp = input[i];
      input[i] = input[j];
      input[j] = temp;

      i++;
      j--;
    }
  }
}

import java.util.*;

public class ch03q06 {
  public static void main(String args[]) {
    System.out.printf("Question: Sort stack in ascending order\n");

    Stack<Integer> test = new Stack<Integer>();
    test.push(1);
    test.push(7);
    test.push(3);
    test.push(4);
    test.push(7);
    test.push(12);

    Stack<Integer> sorted = sortAsc(test);

    System.out.println(sorted.pop());
    System.out.println(sorted.pop());
    System.out.println(sorted.pop());
    System.out.println(sorted.pop());
    System.out.println(sorted.pop());
    System.out.println(sorted.pop());
  }

  public static Stack<Integer> sortAsc(Stack<Integer> input) {
    Stack<Integer> result = new Stack<Integer>();

    while(!input.isEmpty()) {

      int value = input.pop();

      while(!result.isEmpty() && result.peek() > value) {
        input.push(result.pop());
      }
      result.push(value);

    }

    return result;
  }
}

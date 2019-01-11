import java.util.*;

public class ch03q05 {
  public static void main(String args[]) {
    System.out.printf("Question: Queue using two stacks\n");

    MyQueue<Integer> test = new MyQueue<>();
    test.add(1);
    test.add(2);
    test.add(3);

    System.out.println(test.peek());
    System.out.println(test.pop());
    System.out.println(test.pop());
    System.out.println(test.pop());

  }
}

public class MyQueue<T> {
  Stack<T> s1,s2;

  public MyQueue(){
    s1 = new Stack<T>();
    s2 = new Stack<T>();
  }

  public int size(){
    return s1.size() + s2.size();
  }

  public void add(T value) {
    s1.push(value);
  }

  public T peek() {
    if(!s2.empty())
      return s2.peek();

    while(!s1.empty())
      s2.push(s1.pop());

    return s2.peek();
  }

  public T pop() {
    if(!s2.empty())
      return s2.pop();

    while(!s1.empty())
      s2.push(s1.pop());

    return s2.pop();
  }
}

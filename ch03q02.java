import java.util.*;

public class ch03q02 {
  public static void main(String args[]) {
    System.out.printf("Question: Stack with min element function\n");

    myStack stk = new myStack();

    stk.push(100);
    stk.push(10);
    stk.push(4);
    stk.push(3);
    stk.push(5);

    System.out.println(stk.min());
    System.out.println(stk.pop());
    System.out.println(stk.pop());
    System.out.println(stk.pop());
    System.out.println(stk.min());

    System.out.println(stk.isEmpty());
  }
}

public class myStack {
  StackItem[] stack = new StackItem[300];
  int stackPointer = -1;

  public void push(int value) {
    StackItem item = new StackItem();
    item.value = value;
    item.lastValue = stackPointer;
    item.minBeforeMeIndex = stackPointer + 1;

    if(!isEmpty()) {
      StackItem prev = stack[stackPointer];

      System.out.printf("Min:%d, %d > %d\n",prev.minBeforeMeIndex,  item.value, stack[prev.minBeforeMeIndex].value);

      if(item.value > stack[prev.minBeforeMeIndex].value) {
        item.minBeforeMeIndex = prev.minBeforeMeIndex;
      }
    }

    stack[++stackPointer] = item;
  }

  public int min() {
    if(isEmpty()) {
      return -999;
    }

    StackItem result = stack[stackPointer];
    return stack[result.minBeforeMeIndex].value;
  }

  public int pop() {
    if(isEmpty()) {
      return -999;
    }
    StackItem result = stack[stackPointer];
    stackPointer = result.lastValue;

    return result.value;
  }

  public int peek() {
    if(isEmpty()) {
      return -999;
    }

    StackItem result = stack[stackPointer];
    return result.value;
  }

  public boolean isEmpty() {
    return stackPointer == -1;
  }
}

public class StackItem {
  public int value;
  public int lastValue;
  public int minBeforeMeIndex;
}

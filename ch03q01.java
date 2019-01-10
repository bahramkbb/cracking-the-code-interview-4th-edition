import java.util.*;

public class ch02q03 {
  public static void main(String args[]) {
    System.out.printf("Question: Single array for 3 stacks\n");

    myStack stk = new myStack();

    stk.push(1,0);
    stk.push(2,0);
    stk.push(3,0);
    stk.push(7,1);
    stk.push(8,1);
    stk.push(4,0);
    stk.push(5,0);
    stk.push(9,1);
    stk.push(10,1);

    System.out.println(stk.peek(0));
    System.out.println(stk.pop(0));
    System.out.println(stk.pop(0));
    System.out.println(stk.pop(0));
    System.out.println(stk.pop(0));
    System.out.println(stk.pop(1));
    System.out.println(stk.pop(1));
    System.out.println(stk.isEmpty(2));
  }
}

public class myStack {
  StackItem[] stack = new StackItem[300];
  int[] stackPointers = {-1,-1,-1};

  public void push(int value, int stackNo) {
    StackItem item = new StackItem();
    item.value = value;
    item.lastValue = stackPointers[stackNo];

    stackPointers[stackNo] = nextAvailableIndex();
    stack[stackPointers[stackNo]] = item;
  }

  public int nextAvailableIndex() {
    int result = 0;

    for(int i:stackPointers) {
      if (i >= result) {
        result = i + 1;
      }
    }

    return result;
  }

  public int pop(int stackNo) {
    if(isEmpty(stackNo)) {
      return -999;
    }
    StackItem result = stack[stackPointers[stackNo]];
    stackPointers[stackNo] = result.lastValue;

    return result.value;
  }

  public int peek(int stackNo) {
    if(isEmpty(stackNo)) {
      return -999;
    }

    StackItem result = stack[stackPointers[stackNo]];
    return result.value;
  }

  public boolean isEmpty(int stackNo) {
    return stackPointers[stackNo] == -1;
  }
}

public class StackItem {
  public int value;
  public int lastValue;
}

import java.util.*;

public class ch03q03 {
  public static void main(String args[]) {
    System.out.printf("Question: Set Of Stacks with push and pop\n");

    SetOfStacks stk = new SetOfStacks();

    stk.push(100);
    stk.push(10);
    stk.push(4);
    stk.push(3);
    stk.push(5);

    System.out.println(stk.popAt(2));
    System.out.println(stk.pop());
    System.out.println(stk.pop());

    // System.out.println(stk.isEmpty());
  }
}

public class SetOfStacks {
  ArrayList<singleStack> stacks = new ArrayList<singleStack>();

  public void push(int value) {
    if(stacks.size() == 0 || stacks.get(stacks.size()-1).size() == 2) {
      stacks.add(new singleStack());
    }
    stacks.get(stacks.size()-1).push(value);
  }

  public int pop() {
    if(stacks.size() == 0 || stacks.get(stacks.size()-1).size() == 0) {
      return -999;
    }

    int res = stacks.get(stacks.size()-1).pop();

    if(stacks.get(stacks.size()-1).size() == 0) {
      stacks.remove(stacks.size()-1);
    }

    return res;
  }

  public int popAt(int stackNo) {
    if(stacks.size() < stackNo || stacks.get(stackNo-1).size() == 0) {
      return -999;
    // }

    int res = stacks.get(stackNo-1).pop();

    if(stacks.get(stackNo-1).size() == 0) {
      stacks.remove(stackNo-1);
    }

    return res;
  }
 }

public class singleStack {
  StackItem[] stack = new StackItem[2];
  int stackPointer = -1;

  public void push(int value) {
    StackItem item = new StackItem();
    item.value = value;

    stack[++stackPointer] = item;
  }

  public int size() {
    return stackPointer + 1;
  }
//
  public int pop() {
    if(isEmpty()) {
      return -999;
    }
    StackItem result = stack[stackPointer];
    stackPointer--;

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
}

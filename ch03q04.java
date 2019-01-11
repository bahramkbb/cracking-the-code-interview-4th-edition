import java.util.*;

public class ch03q04 {
  public static void main(String args[]) {
    System.out.printf("Question: Hanoi Tower\n");

    int n = 5;
    Tower[] towers = new Tower[n];
    for (int i = 0; i < 3; i++)
      towers[i] = new Tower(i);

    for (int i = n - 1; i >= 0; i--)
      towers[0].add(i);

    towers[0].moveDisks(n, towers[2], towers[1]);
  }
}

public class Tower {
  private Stack<Integer> disks;
  private int index;

  public Tower(int i) {
    disks = new Stack<Integer>();
    index = i;
  }

  public int index() {
    return index;
  }

  public void add(int disk) {
    if(!disks.isEmpty() && disks.peek() <= disk) {
      System.out.printf("Error placing disk %d\n", disk);
    } else {
      disks.push(disk);
    }
  }

  public void moveTopTo(Tower t) {
    int top = disks.pop();
    t.add(top);
    System.out.printf("Move disk %d from tower %d to tower %d \n", top, index(), t.index());
  }

  public void print() {
    System.out.println("Contents of Tower " + index());
    for(int i = disks.size() -1 ; i >= 0 ; i++) {
      System.out.println(disks.get(i));
    }
  }

  public void moveDisks(int n, Tower destination, Tower buffer) {
    if (n > 0) {
      moveDisks(n - 1, buffer, destination);
      moveTopTo(destination);
      buffer.moveDisks(n - 1, destination, this);
    }
  }
}

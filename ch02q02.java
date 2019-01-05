import java.util.*;

public class ch02q02 {
  public static void main(String args[]) {
    System.out.printf("Question: Nth element to the end\n");

    LinkList myList = new LinkList();

    myList.addItem(1);
    myList.addItem(2);
    myList.addItem(3);
    myList.addItem(17);
    myList.addItem(2);
    myList.addItem(3);
    myList.addItem(2);
    myList.addItem(3);
    myList.addItem(2);
    myList.addItem(3);

    System.out.println(myList.toString());

    LinkListItem nth = myList.getNthElementToTheEnd(3);
    if(nth != null)
      System.out.println(nth.value);
    else
      System.out.println("Not Found!");


    LinkListItem nth1 = myList.getNthElementToTheEnd(4);
    if(nth1 != null)
      System.out.println(nth1.value);
    else
      System.out.println("Not Found!");


    LinkListItem nth2 = myList.getNthElementToTheEnd(1);
    if(nth2 != null)
      System.out.println(nth2.value);
    else
      System.out.println("Not Found!");

  }
}


  public class LinkListItem {
    public int value;
    public LinkListItem next;

    public LinkListItem(int val) {
      this.value = val;
    }
  }

  public class LinkList {
    public LinkListItem head;
    public int count;

    public void addItem(int val) {
      LinkListItem item = new LinkListItem(val);
      if(head != null)
        item.next = head;
      head = item;
      count++;
    }

    public LinkListItem getNthElementToTheEnd(int num) {
      if(count == 0) return null;
      if(count == 1 && num == 0) return head;

      LinkListItem current = head;
      LinkListItem runner = head;
      int pointer = 1;
      while(runner != null) {
        for(int i = 0; i < num ; i++) {
          System.out.printf("Runner: %d, i = %d\n", runner.value, i);
          if(i == num - 1 && runner.next == null) {
            return current;
          } else if (i == num - 1 && runner.next != null) {
            break;
          } else if (runner.next == null) {
            return null;
          } else {
            runner = runner.next;
          }
        }

        current = current.next;
        runner = current;
      }

      return null;
    }

    public String toString() {
      String res = "";

      LinkListItem pointer = head;

      while(pointer != null) {
        res += "'" + pointer.value + "'";
        pointer = pointer.next;
      }

      return res;
    }
  }

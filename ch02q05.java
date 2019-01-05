import java.util.*;

public class ch02q03 {
  public static void main(String args[]) {
    System.out.printf("Question: Find linkedlist loop beginning\n");

    LinkList lst = new LinkList();
    lst.addItem(1);
    lst.addItem(2);
    lst.addItem(3);
    lst.addItem(4);
    lst.addItem(5);
    lst.addItem(6);
    lst.head.next.next.next.next.next = lst.head.next.next.next;

    System.out.println(lst.findLoopBeginning().value);

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

    LinkListItem findLoopBeginning() {
      LinkListItem n1 = head;
      LinkListItem n2 = head;

      while(n2.next != null) {
        n1 = n1.next;
        n2 = n2.next.next;
        if(n1 == n2) {
          break;
        }
      }

      if(n2.next == null)
        return null;

      n1 = head;
      while(n1 != n2) {
        n1 = n1.next;
        n2 = n2.next;
      }

      return n2;
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

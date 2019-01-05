import java.util.*;

public class ch02q03 {
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

    //LinkListItem itemToDelete = myList.head.next.next;
    LinkListItem itemToDelete = null;
    System.out.println(myList.toString());
    System.out.println(myList.count);
    //System.out.printf("Deleting: %d\n", itemToDelete.value);
    myList.removeItemInMiddle(itemToDelete);
    System.out.println(myList.toString());
    System.out.println(myList.count);
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

    public boolean removeItemInMiddle(LinkListItem item) {
      if(item == null || item.next == null)
        return false;

      item.value = item.next.value;
      item.next = item.next.next;
      count--;
      return true;
    }

    public void addItem(int val) {
      LinkListItem item = new LinkListItem(val);
      if(head != null)
        item.next = head;
      head = item;
      count++;
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

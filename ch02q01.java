import java.util.*;

public class ch02q01 {
  public static void main(String args[]) {
    System.out.printf("Question: Remove duplicates from a linked list\n");

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
    System.out.println(myList.count);
    myList.removeDuplicatesNoBuffer();
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

    public void addItem(int val) {
      LinkListItem item = new LinkListItem(val);
      if(head != null)
        item.next = head;
      head = item;
      count++;
    }

    public void removeDuplicates() {
      HashSet<Integer> valuesSeen = new HashSet<>();
      if (count <= 1)
        return;

      valuesSeen.add(head.value);
      LinkListItem item = head.next;
      LinkListItem prevNode = head;
      while(item != null) {
        if(valuesSeen.contains(item.value)) {
          prevNode.next = item.next;
          item = item.next;
          count--;
        } else {
          valuesSeen.add(item.value);
          prevNode = item;
          item = item.next;
        }
      }
    }

    public void removeDuplicatesNoBuffer(){
      if(count <= 1) return;

      LinkListItem previous = head;
      LinkListItem current = previous.next;

      while(current != null) {
        LinkListItem runner = head;
        //System.out.printf("current: %d, previous: %d", current.value,previous.value);
        while(runner != current) {
          if(runner.value == current.value) {
            previous.next = current.next;
            current = current.next;
            count--;
            break;
          }
          runner = runner.next;
        }
        if(runner == current) {
          previous = current;
          current = current.next;
        }
      }
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

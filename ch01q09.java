import java.util.*;

public class ch01q09 {
  public static void main(String args[]) {
    System.out.printf("Question: Remove duplicates from a linked list\n");

    LinkList myList = new LinkList();
    LinkListItem item1 = new LinkListItem(1);
    LinkListItem item1 = new LinkListItem(2);
    LinkListItem item1 = new LinkListItem(3);
    LinkListItem item1 = new LinkListItem(4);
    LinkListItem item1 = new LinkListItem(3);
    LinkListItem item1 = new LinkListItem(2);
    LinkListItem item1 = new LinkListItem(6);


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

  public void removeItem(int val) {
    if(head == null) {
      return;
    } else if(head.value == val) {
      head = null;
      count = 0;
    } else {
      LinkListItem node = head.next;
      LinkListItem prevNode = head;
      while( node != null ) {
        if(node.value == val) {
          prevNode.next = node.next;
          node = null;
        } else {
          prevNode = node;
          node = node.next;
        }
      }
      count--;
    }
  }

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
        item = null;
        count--;
      } else {
        valuesSeen.add(item.value);
        prevNode = item;
        item = item.next;
      }
    }
  }

  //Todo: Write print function
}

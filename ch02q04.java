import java.util.*;

public class ch02q04 {
  public static void main(String args[]) {
    System.out.printf("Question: Nth element to the end\n");

    LinkList num01 = new LinkList();
    num01.addItem(1);
    num01.addItem(2);
    num01.addItem(3);

    System.out.println(num01.toString());

    LinkList num02 = new LinkList();
    num02.addItem(1);
    num02.addItem(2);
    num02.addItem(3);


    System.out.println(num02.toString());

    LinkList sum = LinkList.sum(num01, num02);

    System.out.println(sum.toString());


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

    public static LinkList sum(LinkList num1, LinkList num2) {
      LinkList res = new LinkList();


      if((num2 == null || num2.head == null)&&(num2 == null || num2.head == null)) {
        return res;
      }

      if(num1 == null || num1.head == null) {
        return num2;
      }
      if(num2 == null || num2.head == null) {
        return num1;
      }

      LinkListItem num1Item = num1.head;
      LinkListItem num2Item = num2.head;

      int carry = 0;
      while(num1Item != null && num2Item != null) {
        int sum = num1Item.value + num2Item.value + carry;
        if(sum > 9) {
          carry = sum / 10;
          sum %= 10;
        }
        res.addItem(sum);
        //System.out.printf("Num1: %d + Num2: %d = Res: %d , Carry: %d\n", num1Item.value, num2Item.value, sum , carry);
        num1Item = num1Item.next;
        num2Item = num2Item.next;
      }

      if(num1Item != null) {
        while (num1Item != null) {
          int sum = num1Item.value + carry;
          if(sum > 9) {
            carry = sum / 10;
            sum %= 10;
          }
          res.addItem(sum);
          num1Item = num1Item.next;
        }
      } else if (num2Item != null) {
        while (num2Item != null) {
          int sum = num2Item.value + carry;
          if(sum > 9) {
            carry = sum / 10;
            sum %= 10;
          }
          res.addItem(sum);
          num2Item = num2Item.next;
        }
      } else if ( carry > 0) {
        res.addItem(carry);
        carry = 0;
      }

      return res;
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

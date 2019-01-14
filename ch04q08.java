import java.util.*;

public class ch04q08 {
  public static void main(String args[]) {
    System.out.printf("Question: Paths that sum up to a number\n");

    BinaryTree treeA = new BinaryTree();
    treeA.insertNode(10);
    treeA.insertNode(20);
    treeA.insertNode(2);
    treeA.insertNode(8);
    treeA.insertNode(5);
    treeA.insertNode(5);
    treeA.insertNode(1);
    treeA.insertNode(13);
    treeA.insertNode(25);
    treeA.insertNode(15);

    //BinaryTree.pathsThatSumUp(treeA.root, 30);
    BinaryTree.pathsThatSumUp(treeA.root, 13);
  }
}

public class BinaryTree {
  public TreeNode root;

  public BinaryTree() {
    root = null;
  }

  public TreeNode insertNode(int data) {
    if(root == null)
    {
      TreeNode node = new TreeNode(data);
      node.parent = null;
      root = node;
      return root;
    } else {
      return insertNodeRecursive(root, data);
    }
  }

  private TreeNode insertNodeRecursive(TreeNode node, int data) {
    if (node.data > data) {
      if(node.left == null) {
        TreeNode newNode = new TreeNode(data);
        newNode.parent = node;
        node.left = newNode;
        return newNode;
      } else {
        return insertNodeRecursive(node.left, data);
      }
    } else {
      if(node.right == null) {
        TreeNode newNode = new TreeNode(data);
        newNode.parent = node;
        node.right = newNode;
        return newNode;
      } else {
        return insertNodeRecursive(node.right, data);
      }
    }
  }

  public static void InorderTraverse(TreeNode node) {
    if(node == null)
      return;

    InorderTraverse(node.left);
    System.out.println(node.data);
    InorderTraverse(node.right);
  }

  public static void PreorderTraverse(TreeNode node) {
    if(node == null)
      return;

    System.out.println(node.data);
    PreorderTraverse(node.left);
    PreorderTraverse(node.right);
  }

  public static void PostorderTraverse(TreeNode node) {
    if(node == null)
      return;

    PostorderTraverse(node.left);
    PostorderTraverse(node.right);
    System.out.println(node.data);
  }

  public static void pathsThatSumUp(TreeNode root, int value) {
    if(root == null)
      return;

    checkSum(root, value, 0);

    pathsThatSumUp(root.left, value);
    pathsThatSumUp(root.right, value);
  }

  public static boolean checkSum(TreeNode root, int value, int sum) {
    if(root == null || root.data > value || sum > value)
      return false;

    sum += root.data;

    if(sum == value) {
      // PRINT PARENTS TILL YOU VALUE REACHED!
      System.out.println("Found new Route:");
      printParentsTillValue(root, value, 0);
      System.out.println();
      return true;
    }

    else if(sum > value) {
      return false;
    }

    else {
      return checkSum(root.left, value, sum) || checkSum(root.right, value, sum);
    }
  }

  public static void printParentsTillValue(TreeNode root, int value, int sum) {
    if(root == null || root.data > value || sum > value)
      return;

    sum += root.data;
    System.out.printf(" %d ", root.data);

    if(sum < value) {
      printParentsTillValue(root.parent, value, sum);
    }
  }


  public class TreeNode {
    public int data;
    public TreeNode parent;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int d) {
      data = d;
    }
  }

}

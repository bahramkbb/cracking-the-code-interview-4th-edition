import java.util.*;

public class ch04q03 {
  public static void main(String args[]) {
    System.out.printf("Question: Sorted array into minimal height tree\n");

    int[] arr = {1, 2, 3, 4, 5,8,9,23,67,99,120};

    BinaryTree test = new BinaryTree();
    BinaryTree.PreorderTraverse(BinaryTree.convertToTree(arr, 0, arr.length - 1));
  }
}

public class BinaryTree {
  public TreeNode root;

  public BinaryTree() {
    root = null;
  }

  public void insertNode(int data) {
    if(root == null)
    {
      TreeNode node = new TreeNode(data);
      root = node;
    } else {
      insertNodeRecursive(root, data);
    }
  }

  private void insertNodeRecursive(TreeNode node, int data) {
    if (node.data > data) {
      if(node.left == null) {
        TreeNode newNode = new TreeNode(data);
        node.left = newNode;
      } else {
        insertNodeRecursive(node.left, data);
      }
    } else {
      if(node.right == null) {
        TreeNode newNode = new TreeNode(data);
        node.right = newNode;
      } else {
        insertNodeRecursive(node.right, data);
      }
    }
  }

  public static TreeNode convertToTree(int[] array, int start, int end) {
    if(end < start)
      return null;

    int mid = (start + end) / 2;
    TreeNode node = new TreeNode(array[mid]);
    node.left = convertToTree(array, start, mid-1);
    node.right = convertToTree(array, mid + 1, end);

    return node;
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

  public static class TreeNode {
    public int data;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int d) {
      data = d;
    }
  }
}

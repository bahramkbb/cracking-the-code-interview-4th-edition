import java.util.*;

public class ch04q04 {
  public static void main(String args[]) {
    System.out.printf("Question: LinkedList of all nodes at level x\n");

    BinaryTree tree = new BinaryTree();
    tree.insertNode(10);
    tree.insertNode(20);
    tree.insertNode(3);
    tree.insertNode(8);
    tree.insertNode(1);
    tree.insertNode(25);
    BinaryTree.TreeNode test = tree.insertNode(15);

    System.out.println(BinaryTree.NextNode(test).data);
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

  public static TreeNode NextNode(TreeNode node) {
    if (node == null)
      return null;

    TreeNode result;

    if(node.parent == null || node.right != null) {
      // left most child of the right node
      result = node.right;
      while (result.left != null)
        result = result.left;
    } else {
      while((result = node.parent) != null) {
        if(result.left == node)
          break;

        node = result;
      }
    }

    return result;
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

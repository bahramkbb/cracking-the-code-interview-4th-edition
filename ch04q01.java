import java.util.*;

public class ch04q01 {
  public static void main(String args[]) {
    System.out.printf("Question: Is Balanced Tree\n");

    BinaryTree tree = new BinaryTree();
    tree.insertNode(13);
    tree.insertNode(24);
    tree.insertNode(11);
    tree.insertNode(41);
    tree.insertNode(1);
    tree.insertNode(451);
    tree.insertNode(14);
    tree.insertNode(12);
    tree.insertNode(500);

    System.out.println(BinaryTree.minDepth(tree.root));
    System.out.println(BinaryTree.maxDepth(tree.root));
    System.out.println(BinaryTree.isBalanced(tree.root));
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

  public static int maxDepth(TreeNode node) {
    if (node == null)
      return 0;
    return 1 + Math.max(maxDepth(node.left), maxDepth(node.right));
  }

  public static int minDepth(TreeNode node) {
    if(node == null)
      return 0;
    return 1 + Math.min(minDepth(node.left), minDepth(node.right));
  }

  public static boolean isBalanced(TreeNode node) {
    return (maxDepth(node) - minDepth(node) <= 1);
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

  public class TreeNode {
    public int data;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int d) {
      data = d;
    }
  }
}

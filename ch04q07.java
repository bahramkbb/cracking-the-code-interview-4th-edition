import java.util.*;

public class ch04q07 {
  public static void main(String args[]) {
    System.out.printf("Question: B is Subtree of A\n");

    BinaryTree treeA = new BinaryTree();
    treeA.insertNode(10);
    treeA.insertNode(20);
    treeA.insertNode(3);
    treeA.insertNode(8);
    treeA.insertNode(1);
    treeA.insertNode(25);
    treeA.insertNode(15);

    BinaryTree treeB = new BinaryTree();
    treeB.insertNode(3);
    treeB.insertNode(8);
    treeB.insertNode(1);

    System.out.printf("B is subtree of A subtree: %b\n", BinaryTree.containsTree(treeA.root, treeB.root));

    BinaryTree treeC = new BinaryTree();
    treeC.insertNode(8);
    treeC.insertNode(3);
    treeC.insertNode(1);

    System.out.printf("C is subtree of A subtree: %b\n", BinaryTree.containsTree(treeA.root, treeC.root));
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

  public static boolean containsTree(TreeNode rootA, TreeNode rootB) {
    if(rootB == null) return true;
    return MatchingRoots(rootA, rootB);
  }

  private static boolean MatchingRoots(TreeNode rootA, TreeNode rootB) {
    if(rootA == null)
      return false;
    if(rootA.data == rootB.data) {
      if(MatchSubtree(rootA, rootB))
        return true;
    }
    return MatchingRoots(rootA.left, rootB) || MatchingRoots(rootA.right, rootB);
  }

  private static boolean MatchSubtree(TreeNode rootA, TreeNode rootB) {
    if(rootA == null && rootB == null)
      return true;
    if(rootA == null || rootB == null)
      return false;
    if(rootA.data != rootB.data)
      return false;
    return MatchSubtree(rootA.left, rootB.left) && MatchSubtree(rootA.right, rootB.right);
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

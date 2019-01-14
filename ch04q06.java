import java.util.*;

public class ch04q06 {
  public static void main(String args[]) {
    System.out.printf("Question: First commont ancestor\n");

    BinaryTree tree = new BinaryTree();
    tree.insertNode(10);
    tree.insertNode(20);
    tree.insertNode(3);
    BinaryTree.TreeNode a = tree.insertNode(8);
    tree.insertNode(1);
    BinaryTree.TreeNode b = tree.insertNode(25);
    tree.insertNode(15);

    System.out.printf("Ancestor: %d\n", tree.FirstCommonAncestor(a,b).data);
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

  public TreeNode FirstCommonAncestor(TreeNode a, TreeNode b) {
    TreeNode res = null;
    TreeNode tmp = root;

    while (tmp != null) {
      boolean AInLeft = Covers(tmp.left, a);
      boolean BInLeft = Covers(tmp.left, b);
      if (AInLeft && BInLeft) {
        if (tmp.left == a || tmp.left == b) {
          res = tmp;
          break;
        }
        tmp = tmp.left;
      } else if (!AInLeft && !BInLeft) {
        if (tmp.right == a || tmp.right == b) {
          res = tmp;
          break;
        }
        tmp = tmp.right;
      } else {
        res = tmp;
        break;
      }
    }

    return res;
  }

  public boolean Covers(TreeNode root, TreeNode target) {
    if(root == null) return false;
    if(root == target) return true;
    return Covers(root.left, target) || Covers(root.right, target);
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

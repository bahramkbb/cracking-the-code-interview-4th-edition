import java.util.*;

public class ch04q01 {
  public static void main(String args[]) {
    System.out.printf("Question: Balanced Tree\n");

    BinaryTree tree = new BinaryTree();
    tree.insertNode(10);
    tree.insertNode(20);
    tree.insertNode(3);
    tree.insertNode(8);
    tree.insertNode(1);
    tree.insertNode(25);
    tree.insertNode(15);

    ArrayList<LinkedList<BinaryTree.TreeNode>> test = new ArrayList<LinkedList<BinaryTree.TreeNode>>();
    test = BinaryTree.getLevelNodes(tree.root);

    for(LinkedList<BinaryTree.TreeNode> list : test)
    {
      System.out.println("LEVEL START");
      for(BinaryTree.TreeNode node: list) {
        System.out.printf(" %d ", node.data);
      }
      System.out.printf("\nLEVEL END\n");
    }
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

  public static ArrayList<LinkedList<TreeNode>> getLevelNodes(TreeNode root) {
    if (root == null) return null;

    ArrayList<LinkedList<TreeNode>> res = new ArrayList<LinkedList<TreeNode>>();

    int level = 0;
    LinkedList<TreeNode> list = new LinkedList<TreeNode>();
    list.add(root);
    res.add(0,list);

    while(true) {
      list = new LinkedList<TreeNode>();
      for(TreeNode nextToVisit: res.get(level)) {
        if(nextToVisit.left != null)
          list.add(nextToVisit.left);
        if(nextToVisit.right != null)
          list.add(nextToVisit.right);
      }

      if(list.size() == 0)
        break;

      res.add(++level, list);
    }

    return res;
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

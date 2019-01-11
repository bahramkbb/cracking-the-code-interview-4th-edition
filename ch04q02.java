import java.util.*;

public class ch04q02 {
  public static void main(String args[]) {
    System.out.printf("Question: Do two nodes have path\n");

    Graph test = new Graph();

    test.addNode(1);
    test.addNode(2);
    test.addNode(3);
    test.addNode(4);
    test.addNode(5);
    test.addNode(6);
    test.addNode(7);
    System.out.println(test.hasPathDFS(1,2));
    test.addEdge(1,2);
    System.out.println(test.hasPathDFS(1,2));
    System.out.println(test.hasPathDFS(1,7));
  }
}

public class Graph {
  private HashMap<Integer, GraphNode> nodeLookup = new HashMap<Integer,GraphNode>();

  public static class GraphNode {
    public int id;
    LinkedList<GraphNode> adjacent = new LinkedList<GraphNode>();
    public GraphNode(int id) {
      this.id = id;
    }
  }

  private GraphNode getNode(int id) {
    return nodeLookup.get(id);
  }

  public void addNode(int id) {
    GraphNode node = new GraphNode(id);
    nodeLookup.put(node.id, node);
  }

  public void addEdge(int source, int destination) {
    GraphNode s = nodeLookup.get(source);
    GraphNode d = nodeLookup.get(destination);

    s.adjacent.add(d);
  }

  public boolean hasPathDFS(int source, int destination) {
    GraphNode s = nodeLookup.get(source);
    GraphNode d = nodeLookup.get(destination);
    HashSet<GraphNode> visited = new HashSet<GraphNode>();

    return hasPathDFS(s,d, visited);
  }

  private boolean hasPathDFS(GraphNode source, GraphNode destination, HashSet<GraphNode> memo) {
    if(memo.contains(source))
      return false;

    memo.add(source);

    if(source == destination)
      return true;


    for(GraphNode node: source.adjacent) {
      if (hasPathDFS(node, destination, memo))
        return true;
    }

    return false;
  }

  public boolean hasPathBFS(int source, int destination) {
    HashSet<GraphNode> memo = new HashSet<GraphNode>();
    LinkedList<GraphNode> next = new LinkedList<GraphNode>();

    GraphNode s = nodeLookup.get(source);
    GraphNode d = nodeLookup.get(destination);

    next.add(s);

    while(!next.isEmpty()) {
      GraphNode node = next.remove();

      if (node == d)
        return true;

      if(memo.contains(node))
        continue;

      memo.add(node);

      for(GraphNode child: node.adjacent) {
        next.add(child);
      }
    }
    return false;
  }

}

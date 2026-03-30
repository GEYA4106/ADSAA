import java.util.*;
class DFSAdjList {
    private int v;
    private List<List<Integer>> adj;
    private boolean[] visited;
    public DFSAdjList(int v) {
        this.v = v;
        visited = new boolean[v];
        adj = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
    }
    public void addEdge(int src, int dest) {
        adj.get(src).add(dest);
        adj.get(dest).add(src);
    }
    public void dfs(int start) {
        visited[start] = true;
        System.out.print(start + " ");
        for (int node : adj.get(start)) {
            if (!visited[node]) {
                dfs(node);
            }
        }
    }
    public static void main(String[] args) {
        DFSAdjList d = new DFSAdjList(5);
        d.addEdge(0, 1);
        d.addEdge(0, 2);
        d.addEdge(1, 3);
        d.addEdge(2, 4);
        System.out.println("DFS Traversal:");
        d.dfs(0);
    }
}
import java.util.*;
class DFSAdjList {
    private int n;
    private ArrayList<ArrayList<Integer>> adj;
    private boolean[] visited;
    public DFSAdjList(int n) {
        this.n = n;
        adj = new ArrayList<>();
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
    }
    public void addEdge(int i, int j) {
        adj.get(i).add(j);
        adj.get(j).add(i); 
    }
    public void DFS(int start) {
        visited[start] = true;
        System.out.print(start + " ");
        for (int neighbor : adj.get(start)) {
            if (!visited[neighbor]) {
                DFS(neighbor);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of vertices:");
        int n = sc.nextInt();
        DFSAdjList graph = new DFSAdjList(n);
        System.out.println("Enter number of edges:");
        int e = sc.nextInt();
        System.out.println("Enter edges (u v):");
        for (int i = 0; i < e; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.addEdge(u, v);
        }
        System.out.println("Enter the starting vertex of DFS:");
        int start = sc.nextInt();
        System.out.println("DFS traversal starting from vertex " + start + ":");
        graph.DFS(start);
        sc.close();
    }
}

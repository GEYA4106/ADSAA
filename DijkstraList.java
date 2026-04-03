import java.util.*;
class Pair {
    int vertex, weight;
    Pair(int v, int w) {
        vertex = v;
        weight = w;
    }
}
public class DijkstraList {
    static void dijkstra(ArrayList<ArrayList<Pair>> adj, int V, int src) {
        int dist[] = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> a.weight - b.weight
        );
        dist[src] = 0;
        pq.add(new Pair(src, 0));
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int u = p.vertex;
            for (Pair neighbor : adj.get(u)) {
                int v = neighbor.vertex;
                int weight = neighbor.weight;
                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.add(new Pair(v, dist[v]));
                }
            }
        }
        System.out.println("Vertex \t Distance from Source");
        for (int i = 0; i < V; i++) {
            System.out.println(i + "\t" + dist[i]);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        System.out.print("Enter number of edges: ");
        int E = sc.nextInt();
        System.out.println("Enter edges (u v weight):");
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w)); // remove if directed
        }
        System.out.print("Enter source vertex: ");
        int src = sc.nextInt();
        dijkstra(adj, V, src);
    }
}

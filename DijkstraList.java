//Java program to implement Single Source Shortest path using greedy method when the graph is represented using adjacency list
import java.util.*;

class Node implements Comparable<Node> {
    int vertex, weight;

    Node(int v, int w) {
        vertex = v;
        weight = w;
    }

    public int compareTo(Node other) {
        return this.weight - other.weight;
    }
}

public class DijkstraList {

    static int V = 5;

    void dijkstra(List<List<Node>> adj, int src) {
        int dist[] = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();

        dist[src] = 0;
        pq.add(new Node(src, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int u = current.vertex;

            for (Node neighbor : adj.get(u)) {
                int v = neighbor.vertex;
                int weight = neighbor.weight;

                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.add(new Node(v, dist[v]));
                }
            }
        }

        System.out.println("Vertex \t Distance from Source");
        for (int i = 0; i < V; i++)
            System.out.println(i + " \t\t " + dist[i]);
    }

    public static void main(String[] args) {
        List<List<Node>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        // Adding edges
        adj.get(0).add(new Node(1, 10));
        adj.get(0).add(new Node(3, 30));
        adj.get(0).add(new Node(4, 100));

        adj.get(1).add(new Node(0, 10));
        adj.get(1).add(new Node(2, 50));

        adj.get(2).add(new Node(1, 50));
        adj.get(2).add(new Node(3, 20));
        adj.get(2).add(new Node(4, 10));

        adj.get(3).add(new Node(0, 30));
        adj.get(3).add(new Node(2, 20));
        adj.get(3).add(new Node(4, 60));

        adj.get(4).add(new Node(0, 100));
        adj.get(4).add(new Node(2, 10));
        adj.get(4).add(new Node(3, 60));

        DijkstraList obj = new DijkstraList();
        obj.dijkstra(adj, 0);
    }
}
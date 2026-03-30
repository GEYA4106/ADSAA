import java.util.*;
class DFSAdjMatrix{
    private int n;
    private int [][]adj;
    private boolean[] visited;
    public DFSAdjMatrix(int n){
        this.n=n;
        adj=new int[n][n];
        visited=new boolean[n];
    }
    public void addEdge(int i,int j){
        adj[i][j]=1;
        adj[j][i]=1;
    }
    public void DFS(int start){
        visited[start]=true;
        System.out.print(start+" ");
        for (int i=0;i<n;i++){
            if(adj[start][i]==1 && !visited[i])
                DFS(i);
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of vertices:");
        int n = sc.nextInt();
        DFSAdjMatrix graph = new DFSAdjMatrix(n);
        System.out.println("Enter adjacency matrix:");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(sc.nextInt()==1)
                    graph.addEdge(i, j);
            }
        }
        System.out.println("Enter the starting vertex of DFS:");
        int start = sc.nextInt();
        System.out.println("DFS traversal starting from vertex " + start + ":");
        graph.DFS(start);
        sc.close();
    }

}


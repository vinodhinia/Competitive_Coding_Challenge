import java.util.*;

public class Graph {
	
	int Vertex;
	LinkedList<Integer> adj[];
	
	Graph(int v){
		Vertex = v;
		adj = new LinkedList[v];
		
		for(int i=0;i<v;i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}
	
	public void addEdge(int v, int w) {
		adj[v].add(w);
	}
	
	public void DFS(int v) {
		boolean visited[] = new boolean[Vertex];
		DFSUtil(v,visited);
	}

	public void DFSUtil(int v, boolean visited[]) {
		visited[v] = true;
		System.out.println(v +" ");
		
		Iterator<Integer> it = adj[v].iterator();
		while(it.hasNext()) {
			int n = it.next();
			if(!visited[n]) {
				DFSUtil(n,visited);
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph g = new Graph(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
		
		g.DFS(2);
	}

}

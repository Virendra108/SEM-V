import java.util.ArrayList;
import java.util.List;

public class Graph_Path {
    private int totalVertices;
    private List<Integer>[] adjacencyList;

    @SuppressWarnings("unchecked")
    public Graph_Path(int numVertices) {
        totalVertices = numVertices;
        adjacencyList = new ArrayList[numVertices];
        for (int i = 0; i < numVertices; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
    }

    public void addEdge(int fromVertex, int toVertex) {
        adjacencyList[fromVertex].add(toVertex);
    }

    public int countAllPaths(int startVertex, int endVertex) {
        int pathCount = 0;
        boolean[] visitedNodes = new boolean[totalVertices];
        pathCount = pathCountingHelper(startVertex, endVertex, visitedNodes);
        return pathCount;
    }

    private int pathCountingHelper(int startVertex, int endVertex, boolean[] visitedNodes) {
        visitedNodes[startVertex] = true;
        int pathCount = 0;

        if (startVertex == endVertex) {
            pathCount++;
        } else {
            for (int neighbor : adjacencyList[startVertex]) {
                if (!visitedNodes[neighbor]) {
                    pathCount += pathCountingHelper(neighbor, endVertex, visitedNodes);
                }
            }
        }

        visitedNodes[startVertex] = false;
        return pathCount;
    }

    public static void main(String[] args) {
        Graph_Path g = new Graph_Path(5);
        /* 
         0-->A
         1-->B
         2-->C
         3-->D
         4-->E
         */
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 4);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 4);
        g.addEdge(3, 2);

        System.out.println(g.countAllPaths(0, 4));
    }
}
// Time Complexity: O(V * E)
// Space Complexity: O(V + E)
//V--> Vertex 
//E--> Edges
/* Time & Space Complexity explanation by ChatGPT
Time Complexity
Initialization:

The constructor initializes the adjacency list with numVertices empty lists. This takes O(V) time, where V is the number of vertices.
addEdge Method:

Adding an edge to the adjacency list takes O(1) time for each call.
countAllPaths Method:

This method initializes a boolean array visitedNodes of size V, which takes O(V) time.
It then calls the pathCountingHelper method.
pathCountingHelper Method:

This method uses recursion to explore all paths from startVertex to endVertex.
In the worst case, it explores all possible paths in the graph.
The number of possible paths can be exponential in the number of vertices and edges, especially in a dense graph.
For each vertex, it iterates over its neighbors, leading to a time complexity of O(E) for each recursive call, where E is the number of edges.
The total time complexity is O(V * E) in the worst case, where the graph is dense and the recursion explores all possible paths.
##########################################################################################################################################################
Space Complexity
Adjacency List:

The adjacency list requires O(V + E) space to store the vertices and edges.
Visited Nodes Array:

The visitedNodes array requires O(V) space.
Recursive Call Stack:

The maximum depth of the recursion is V in the worst case, which requires O(V) space for the call stack.
Overall Complexity
Time Complexity: O(V * E) in the worst case, where the graph is dense and the recursion explores all possible paths.
Space Complexity: O(V + E) for the adjacency list and O(V) for the visited nodes array and call stack, resulting in a total space complexity of O(V + E).
*/

package biz.hahamo.algorithm.bellmanford;

/**
 *
 * @author Hajba, G�bor L�szl� (GHajba)
 */
public class Edge {

    int source; // source node
    int destination; // destination node
    int weight; // weight of the edge

    public Edge() {
    }

    public Edge(int s, int d, int w) {
        source = s;
        destination = d;
        weight = w;
    }
}

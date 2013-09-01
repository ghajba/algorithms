package biz.hahamo.algorithm.bellmanford;

/**
 *
 * @author Hajba, G�bor L�szl� (GHajba)
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        BellmanFord bellmanFord = new BellmanFord();

        bellmanFord.readInput("input.txt");
        bellmanFord.bellmanFord();
        bellmanFord.writeOutput("output.txt");
    }

}

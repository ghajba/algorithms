package biz.hahamo.algorithm.bellmanford;

import java.io.FileNotFoundException;

/**
 *
 * @author Hajba, Gábor László (GHajba)
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        BellmanFord bellmanFord = new BellmanFord();

        try
        {
            bellmanFord.readInput("input.txt");
        }
        catch(FileNotFoundException e)
        {
            System.out.println("The file 'input.txt' could not be found. Please provide an input for the application.");
            System.exit(-1);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            System.exit(-2);
        }
        bellmanFord.bellmanFord();
        bellmanFord.writeOutput("output.txt");
    }

}

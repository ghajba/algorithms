package biz.hahamo.algorithm.bellmanford;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Hajba, Gábor László (GHajba)
 */
public class BellmanFord {

    private int numberOfNodes = 0;
    private int numberOfEdges = 0;
    private ArrayList<Edge> edges = new ArrayList<Edge>();
    private int[] values;

    public void readInput(String fileName) throws Exception {

        // Open the file that is the first
        // command line parameter
        FileInputStream fstream = new FileInputStream(fileName);
        // Get the object of DataInputStream
        DataInputStream in = new DataInputStream(fstream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        String strLine;

        //Read file and get the data
        if ((strLine = br.readLine()) == null) {
            throw new Exception("Not valid input file!");
        }
        this.numberOfNodes = new Integer(strLine); // convert the string to a number

        if ((strLine = br.readLine()) == null) {
            throw new Exception("Not valid input file!");
        }
        this.numberOfEdges = new Integer(strLine);

        for (int i = 0; i < numberOfEdges; i++) {
            if ((strLine = br.readLine()) == null) {
                throw new Exception("Not valid input file!");
            }
            String[] line = strLine.split(" ");
            if (line.length != 3) {
                throw new Exception("Not valid input file!");
            }

            edges.add(new Edge(new Integer(line[1]), new Integer(line[0]), new Integer(line[2])));
        }

        for (int i = 0; i < numberOfNodes; i++) {
            edges.add(new Edge(0, i + 1, 0)); // add the virtual node
        }


        in.close();
    }

    public void bellmanFord() {

        int[] distance = new int[numberOfNodes + 1];

        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[0] = 0;

        for (int i = 0; i < numberOfNodes + 1; ++i) {
            for (int j = 0; j < edges.size(); ++j) {

                if (distance[edges.get(j).source] == Integer.MAX_VALUE) {
                    continue;
                }

                int newDistance = distance[edges.get(j).source] + edges.get(j).weight;

                if (newDistance < distance[edges.get(j).destination]) {
                    distance[edges.get(j).destination] = newDistance;
                }
            }
        }

        for (int i = 0; i < edges.size(); ++i) {
            if (distance[edges.get(i).source] != Integer.MAX_VALUE && distance[edges.get(i).destination] > distance[edges.get(i).source] + edges.get(i).weight) {
                throw new RuntimeException("Negative edge weight cycles detected!");
            }
        }

        values = new int[numberOfNodes];
        for (int i = 1; i < distance.length; ++i) {
            if (distance[i] == Integer.MAX_VALUE) {
                System.err.println("There's no path between the source vertex and X" + i);
            } else {

                values[i - 1] = distance[i];
            }
        }
    }

    void writeOutput(String fileName) throws IOException {
        // Create file
        FileWriter fstream = new FileWriter(fileName);
        BufferedWriter out = new BufferedWriter(fstream);

        for (int i = 0; i < numberOfNodes; i++) {
            out.write((i + 1) + ": " + values[i]);
            out.newLine();
        }

        out.flush();
        out.close();
    }
}

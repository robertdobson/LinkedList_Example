import java.io.*;
import java.util.LinkedList;

/**
 * StateFileReader scans contents of a CSV file, creates State objects that are added to a LinkedList,
 * and returns the LinkedList of State objects.
 * @author Robert Dobson
 */
public class StateFileReader {

    /**
     * Read the CSV file.
     * @param path to input file
     * @return stateArrayList a LinkedList of State objects
     */
    public LinkedList<State> readFile(String path) {

        // Create a linked list of type State
        LinkedList<State> stateLinkedList = new LinkedList<State>();

        // Read the data from a file and add to the LinkedList
        FileInputStream fileInputReader;

        try {
            fileInputReader = new FileInputStream(path);
            BufferedReader in = new BufferedReader(new InputStreamReader(fileInputReader));
            String fact;
            while ((fact = in.readLine()) != null) {
                String delimiter = "/";
                String[] tokens = fact.split(delimiter);

                State state = new State(tokens[0], tokens[1], tokens[2]);
                stateLinkedList.add(state);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return stateLinkedList;
    }
}

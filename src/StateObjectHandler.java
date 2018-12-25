import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * The StateObjectHandler class contains the main() method, and demonstrates the State class,
 * and StateFileReader class.
 * @author Robert Dobson
 */
public class StateObjectHandler {

    private LinkedList<State> factsOfStates;

    /**
     * Constructor for an object of class StateObjectHandler.
     * Reads in a file by calling StateFileReader and assigns the generated LinkedList of State objects
     * into the LinkedList factsOfStates.
     * @param filePath	The input file to parse.
     */
    public StateObjectHandler (String filePath)
    {
        // Create StateFileReader object
        StateFileReader reader = new StateFileReader();

        // Read the file passed in as a parameter and assign the returned LinkedList to factsOfState
        factsOfStates = reader.readFile(filePath);

        // Check the size of the resulting LinkedList object.
        if (factsOfStates.size() < 1)
        {
            System.out.println("WARNING: The list of state facts is empty.");
            return;
        }

        System.out.printf("\n *** The LinkedList of type State contains %d State objects. ***\n\n", factsOfStates.size());

    }

    /**
     * Accessor method returns the LinkedList of State objects generated from reading the input file.
     * @return	factsOfStates a LinkedList of State objects.
     */
    public LinkedList<State> getFactsOfStates()
    {
        return factsOfStates;
    }

    /**
     * Reads a scrambled input file that contains the facts of the different states, stores the facts in objects
     * of class State, adds State objects to a LinkedList, sorts the State objects in the LinkedList based on the year
     * they entered the Union, and outputs the attributes of the State objects in the sorted order. Then creates a
     * second LinkedList for State objects, sorts the State objects in order of the year the States were settled, adds
     * them to the second LinkedList in the new order, and asks user the desired sort order to display the State objects
     * or if the user wants to exit the application. Once user chooses selection, the application responds by displaying
     * the appropriate LinkedList corresponding to the desired sort order, or exits the application.
     * @param args	Not used.
     */
    public static void main(String[] args) {

        final String FILEPATH = "resources/Scrambled_States.txt";

        // Create new StateObjectHandler passing in the parameter of the filepath of the scrambled file, and assigns to list
        StateObjectHandler scrambledListOne = new StateObjectHandler(FILEPATH);

        // Assign factsOfStates LinkedList to statesOrderedByEntryToUnion LinkedList
        LinkedList<State> statesOrderedByEntryToUnion = scrambledListOne.getFactsOfStates();

        // Provide format to parse date from String
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy");

        // Order the scrambled list of States by date of entry to the Union in code.
        Collections.sort(statesOrderedByEntryToUnion, Comparator.comparing(s -> LocalDate.parse(s.getDateEnteredUnion(),
                formatter)));
        // Write code to loop through the linked list and print the state and the date it entered the union.
        for (State state : statesOrderedByEntryToUnion) {
            state.printState();
        }
        System.err.flush();
        System.out.println("Done with sorting scrambled file by date of entry to Union, and printing the ordered list.\n");

        System.out.println("*** Beginning create second LinkedList, sort based on year settled, " +
                "and ask user for desired sort order output ***\n");

        // Create new StateObjectHandler passing in the parameter of the filepath of the scrambled file, and assigns to list
        StateObjectHandler scrambledListTwo = new StateObjectHandler(FILEPATH);
        // Create a 2nd linked list for the year settled
        LinkedList<State> statesOrderedByYearSettled = scrambledListTwo.getFactsOfStates();

        // Order the list in code according to the year the state was first settled
        Collections.sort(statesOrderedByYearSettled, Comparator.comparing(s -> s.getYearFirstSettled()));

        // Ask the user for desired sort order for printing States or choose exit option.
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Please enter the desired state order " +
                "(1 - Date of entry to Union, 2 - Year settled, or any other key - Exit application): ");

        char input = keyboard.next().charAt(0);
        System.out.println();

        if (input == '1') {
            // Output the State objects of the LinkedList ordered by date of entry to the Union.
            for (State state : statesOrderedByEntryToUnion) {
                state.printState();
            }
        } else if (input == '2') {
            // Output the State objects of the LinkedList ordered by the year first settled.
            for (State state : statesOrderedByYearSettled) {
                state.printState();
            }
        } else {
            // Exit the application.
            System.out.println("\nApplication terminated");
        }
    }
}

project folder:
LinkedList_Example/

PROJECT SUMMARY:
The LinkedList_Example project is an example of working with LinkedLists. The application reads a text file
containing a scrambled list of the 50 US states along with information on the date they were first settled, and
their date of entry to the Union. Objects of type State are created from the text file information and added to
a LinkedList. The LinkedList of State objects is then ordered based on date of entry to the Union and printed
to the console. The application then prompts the user for a selection to sort and print the list based on date settled,
date of entry to the Union, or to exit the application, and executes the user's choice.

Brief description of submitted files:

src/State.java
    - The State class is a blueprint for objects with attributes representing facts about the state.

src/StateFileReader.java
    - StateFileReader scans contents of a CSV file, creates State objects that are added to a LinkedList,
      and returns the LinkedList of State objects.

src/StateObjectHandler.java
    - The StateObjectHandler class contains the main() method, and demonstrates the State class,
      and StateFileReader class.

resources/Scrambled_States.txt
    - This is a text file containing a scrambled list of the 50 US states.

README.txt
    - description of submitted files
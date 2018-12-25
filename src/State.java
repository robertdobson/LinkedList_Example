import java.io.Serializable;

/**
 * The State class is a blueprint for objects with attributes representing facts about the state.
 * @author Robert Dobson
 */
public class State implements Serializable {

    private String stateName;
    private String stateAbbreviation;
    private String stateCapital;
    private String statePopulation;

    private String dateEnteredUnion;
    private String yearFirstSettled;

    State(String name, String abbreviation, String capital, String population) {

        this.stateName = name;
        this.stateAbbreviation = abbreviation;
        this.stateCapital = capital;
        this.statePopulation = population;
    }

    State(String name, String dateEnteredUnion, String yearFirstSettled) {

        this.stateName = name;
        this.dateEnteredUnion = dateEnteredUnion;
        this.yearFirstSettled = yearFirstSettled;
    }

    /**
     * The printState() method outputs a list of the State object's attributes.
     */
    public void printState() {

        System.out.println("State: " + this.stateName);
        System.out.println("Date entered Union: " + this.dateEnteredUnion);
        System.out.println("Year settled: " + this.yearFirstSettled + "\n\n");
    }

    /**
     * Accessor method returns name attribute of the State object
     * @return stateName
     */
    public String getStateName() {
        return stateName;
    }

    /**
     * Accessor method returns date entered Union attribute of the State object
     * @return dateEnteredUnion
     */
    public String getDateEnteredUnion() {
        return dateEnteredUnion;
    }

    /**
     * Accessor method returns year first settled attribute of the State object
     * @return yearFirstSettled
     */
    public String getYearFirstSettled() {
        return yearFirstSettled;
    }
}

package coe318.lab7;

import org.junit.Test; // Importing the Test annotation from the JUnit framework
import static org.junit.Assert.*; // Importing static members from the org.junit.Assert class

public class ResistorTest {

    @Test
    public void testToSpiceString() {
        System.out.println("toSpiceString");

        // Create a Resistor instance with specific values
        Resistor resistor = new Resistor(1, 2, 0.25, 1);

        // Expected result based on the specific values
        String expResult = "R1 1 2 0.25";

        // Get the actual result from the toSpiceString method
        String result = resistor.toSpiceString();

        // Check if the actual result matches the expected result
        assertEquals(expResult, result);
    }
}

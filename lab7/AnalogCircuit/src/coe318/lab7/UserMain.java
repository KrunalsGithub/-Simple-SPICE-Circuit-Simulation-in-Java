package coe318.lab7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserMain {
    public static void main(String[] args) {
        // Input scanner and lists are initialized to store circuit components
        Scanner scanner = new Scanner(System.in);
        List<Component> components = new ArrayList<>();
         
        // Initializes counters for voltage sources and resistors
        int voltageSourceCounter = 1;  // A Counter for voltage sources
        int resistorCounter = 1;  // A Counter for resistors

        // Asks user to input their circuit compoennts and other instructions
        System.out.println("Enter circuit components (e.g., 'r 1 2 0.25' or 'v 1 0 2.0').");
        System.out.println("Type 'spice' to display Spice representation or 'end' to exit.");

        while (true) {
            String input = scanner.nextLine().trim();
            if (input.equals("end")) {
                // Terminates the program when the 'end' command is entered by the user
                System.out.println("All Done");
                break;
            } else if (input.equals("spice")) {
                // Displays the Spice representation of the circuit components
                displaySpiceRepresentation(components);
            } else {
                // Interprets and then creates components based on user input
                Component component = interpretComponent(input, voltageSourceCounter, resistorCounter);
                if (component != null) {
                    components.add(component);
                    if (component instanceof VoltageSource) {
                        voltageSourceCounter++;  // Increments the voltage source counter
                    } else if (component instanceof Resistor) {
                        resistorCounter++;  // Increments the resistor counter
                    }
                }
            }
        }
        scanner.close(); 
    }

    public static Component interpretComponent(String input, int voltageSourceCounter, int resistorCounter) {
        // Splits the user's input and creates components based on type (resistor or voltage source)
        String[] tokens = input.split(" ");
        if (tokens.length < 4) {
            System.err.println("Invalid input: " + input);
            return null;
        }

        String type = tokens[0];
        int node1 = Integer.parseInt(tokens[1]);
        int node2 = Integer.parseInt(tokens[2]);
        double value = Double.parseDouble(tokens[3]);

        if (type.equals("r")) {
            // Creates and then returns a resistor component
            return new Resistor(node1, node2, value, resistorCounter);
        } else if (type.equals("v")) {
            // Creates and returns a voltage source component
            return new VoltageSource(node1, node2, value, voltageSourceCounter);
        } else {
            // Display an error message for invalid component type input by the user
            System.err.println("Invalid component type: " + type);
            return null;
        }
    }

    public static void displaySpiceRepresentation(List<Component> components) {
        // Displays the Spice representation for all circuit components
        for (Component component : components) {
            System.out.println(component.toSpiceString());
        }
    }
}

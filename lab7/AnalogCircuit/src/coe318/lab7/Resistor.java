package coe318.lab7;

public class Resistor extends Component {
    private double resistance;

    public Resistor(int node1, int node2, double resistance, int componentNumber) {
        // Initializes a resistor with specified attributes/properties
        super(node1, node2, componentNumber);
        this.resistance = resistance;
    }

    @Override
    public String toSpiceString() {
        // Generates a Spice representation for a resistor
        return String.format("R%d %d %d %.2f", componentNumber, node1, node2, resistance);
    }
}

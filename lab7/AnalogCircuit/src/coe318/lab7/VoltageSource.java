package coe318.lab7;

public class VoltageSource extends Component {
    private double voltage;

    public VoltageSource(int node1, int node2, double voltage, int componentNumber) {
        // Initializes a voltage source with specified attributes/properties
        super(node1, node2, componentNumber);
        this.voltage = voltage;
    }

    @Override
    public String toSpiceString() {
        // Generate a Spice representation for a voltage source and its format
        return String.format("V%d %d %d DC %.1f", componentNumber, node1, node2, voltage);
    }
}

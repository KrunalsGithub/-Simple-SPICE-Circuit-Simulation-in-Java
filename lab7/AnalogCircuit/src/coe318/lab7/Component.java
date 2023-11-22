package coe318.lab7;

public abstract class Component {
    protected int node1;
    protected int node2;
    protected int componentNumber;  // This is a unique identifier for the component

    public Component(int node1, int node2, int componentNumber) {
        // Initialize the component's attributes
        this.node1 = node1;
        this.node2 = node2;
        this.componentNumber = componentNumber;
    }

    public abstract String toSpiceString();  // Generates a Spice representation of the component

    public int getNode1() {
        // Get the first node to which the component is connected
        return node1;
    }

    public int getNode2() {
        // Get the second node to which the component is connected
        return node2;
    }

    public int getComponentNumber() {
        // Get the unique identifier for the component
        return componentNumber;
    }
}

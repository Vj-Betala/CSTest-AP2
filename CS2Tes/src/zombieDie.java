public class zombieDie {

    int colour;
    int value;

    public zombieDie(int zombieColour) {
        colour = zombieColour;
        value = -1;
    }

    public int getColour() {
        return this.colour;
    }

    public int getValue() {
        return this.value;
    }

    public void setColour(int zombieColour) {
        this.colour = zombieColour;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String toString() {
        return "Values not available";
    }

    public void roll() {
        this.value = -1;
    }
}

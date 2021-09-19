public class yellowZombieDie extends zombieDie{

    public yellowZombieDie(int zombieColour) {
        super(zombieColour);
    }

    int[] choices = new int[] {1,1,2,2,3,3};

    @Override
    public void roll() {
        int randomChoice = (int) (Math.random() * 6);

        this.setValue(choices[randomChoice]);

    }

    @Override
    public String toString() {
        if(this.value != -1) {
            switch (this.value) {
                case 1:
                    return "Yellow - Runner";
                case 2:
                    return "Yellow - Brain";
                case 3:
                    return "Yellow - Shot";
            }
        }

        return "Yellow";
    }
}

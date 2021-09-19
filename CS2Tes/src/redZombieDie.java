public class redZombieDie extends zombieDie{
    public redZombieDie(int zombieColour) {
        super(zombieColour);
    }

    int[] choices = new int[] {1,1,2,3,3,3};

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
                    return "Red - Runner";
                case 2:
                    return "Red - Brain";
                case 3:
                    return "Red - Shot";
            }
        }

        return "Red";
    }
}

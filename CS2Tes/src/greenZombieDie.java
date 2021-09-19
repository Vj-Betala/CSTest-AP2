public class greenZombieDie extends zombieDie{

    public greenZombieDie(int zombieColour) {
        super(zombieColour);
    }

    int[] choices = new int[] {1,1,2,2,2,3};

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
                    return "Green - Runner";
                case 2:
                    return "Green - Brain";
                case 3:
                    return "Green - Shot";
            }
        }

        return "Green";
    }
}

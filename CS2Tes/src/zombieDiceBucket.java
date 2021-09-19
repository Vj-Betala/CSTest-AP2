import java.util.ArrayList;

public class zombieDiceBucket {


    ArrayList<zombieDie> bucket;

    public zombieDiceBucket() {
        bucket = new ArrayList<>();
    }

    public void load () {
        this.bucket.clear();
        for(int i = 0; i < 6; i++) {
            greenZombieDie greenDie = new greenZombieDie(1);
            this.bucket.add(greenDie);
        }
        for(int i = 0; i < 4; i++) {
            yellowZombieDie yellowDie = new yellowZombieDie(2);
            this.bucket.add(yellowDie);
        }
        for(int i = 0; i < 3; i++) {
            redZombieDie redDie = new redZombieDie(3);
            this.bucket.add(redDie);
        }
    }

    public zombieDie draw() {
        boolean run = true;
        while(run) {
            int randIndex = (int) (Math.random() * 13);
            zombieDie a = bucket.get(randIndex);
            if(a.value == -1) {
                a.roll();
                return a;
            }
        }

        return bucket.get(0);
    }
}

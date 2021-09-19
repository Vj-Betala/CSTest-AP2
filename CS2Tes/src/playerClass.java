public class playerClass {
    String name;
    int score;

    public playerClass(String playerName) {
        name = playerName;
        score = 0;
    }

    @Override
    public String toString() {
        return "Name: " + name + " Score: " + score;
    }
}

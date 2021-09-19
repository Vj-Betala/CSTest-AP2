import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class zombieDiceGame {
    public static void main(String[] args) {
        zombieDiceBucket bucket = new zombieDiceBucket();
        bucket.load();

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Welcome to Zombie Dice, for a tutorial visit: https://youtu.be/dQw4w9WgXcQ");
        System.out.print("How many players will be playing (2 - 5): ");
        int numPlayers = keyboard.nextInt();

        ArrayList<playerClass> playerNames = new ArrayList<>();

        for(int i = 0; i < numPlayers; i++) {
            System.out.print("Enter the name of player " + (i + 1) + " : ");
            String name = keyboard.next();
            playerClass playerI = new playerClass(name);

            playerNames.add(playerI);
        }

        playerNames = shuffleNames(playerNames);

        ArrayList<zombieDie> hand = new ArrayList<>();
        ArrayList<zombieDie> brains = new ArrayList<>();
        ArrayList<zombieDie> shots = new ArrayList<>();
        ArrayList<zombieDie> runners = new ArrayList<>();

        boolean fullRun = true;

        while(fullRun) {
            for(playerClass i : playerNames) {
                boolean run = true;
                String winnerName = findWinner(playerNames);

                if(! (winnerName.equals("No Winner Yet"))) {

                    System.out.println(winnerName + " has crossed 13 brains. Sudden death match starts now. Any Player after " + winnerName + " who earns more brains, wins.");
                    fullRun = false;
                    break;
                }

                System.out.println( "\n\n" +i.name + " it is your turn.\n" +
                        "You have " + i.score + " brain(s) in your bank.");

                while(run) {
                    System.out.print("Turn Summary: \n" +
                            "\tBrains:" + brains + "\n" +
                            "\tShots: " + shots + "\n" +
                            "\tRunners: " + runners + "\n");

                    System.out.print("1. Keep Going\n" +
                            "2. Stop and add to bank\n" +
                            "Enter Selection (1 or 2): ");
                    int playerSelection = keyboard.nextInt();

                    if(playerSelection == 1) {

                        System.out.print("After drawing you have the following dice: ");

                        int draws = 3 - runners.size();

                        ArrayList<zombieDie> tempBrains = new ArrayList<>();
                        ArrayList<zombieDie> tempShots = new ArrayList<>();
                        ArrayList<zombieDie> tempRunners = new ArrayList<>();

                        for(int k = 0; k < runners.size(); k++) {

                            zombieDie a = runners.get(k);

                            runners.remove(a);

                            a.roll();

                            switch(a.value) {
                                case 1:
                                    tempRunners.add(a);
                                    break;
                                case 2:
                                    tempBrains.add(a);
                                    break;
                                case 3:
                                    tempShots.add(a);
                                    break;
                            }
                            runners.addAll(tempRunners);
                            brains.addAll(tempBrains);
                            shots.addAll(tempShots);

                        }

                        for(int j = 0; j < draws; j++) {

                            zombieDie tempAdd = bucket.draw();

                            hand.add(tempAdd);

                            switch(tempAdd.value) {
                                case 1:
                                    runners.add(tempAdd);
                                    break;
                                case 2:
                                    brains.add(tempAdd);
                                    break;
                                case 3:
                                    shots.add(tempAdd);
                                    break;
                            }


                        }

                        System.out.print(hand + " plus the runners\n");



                        if(shots.size() >= 3) {
                            System.out.println("You have been shot more than 3 times, all your brains for this round are lost.");
                            brains.clear();
                            run = false;
                        }



                        hand.clear();

                    } else if (playerSelection == 2) {
                        winnerName = findWinner(playerNames);
                        run = false;

                        if(! (winnerName.equals("No Winner Yet"))) {

                            System.out.println(winnerName + " has crossed 13 brains. Sudden death match starts now. Any Player after " + winnerName + " who earns more brains, wins.");
                            fullRun = false;
                            break;
                        }
                    }

                }

                i.score += brains.size();

                runners.clear();
                shots.clear();
                brains.clear();

                bucket.load();

            }
        }

        System.out.println("The true winner is: " + findWinner(playerNames));

    }

    public static ArrayList<playerClass> shuffleNames(ArrayList<playerClass> inPut) {
        Collections.shuffle(inPut);

        return inPut;
    }

    public static String findWinner(ArrayList<playerClass> playerNames) {

        ArrayList<playerClass> winnerCount = new ArrayList<>();

        for(playerClass i: playerNames) {
            if (i.score >= 13) {
                winnerCount.add(i);
            }
        }

        if(winnerCount.size() > 1) {
            System.out.println("Multiple People Might win");
            return multiWinners(winnerCount);
        } else if (winnerCount.size() == 1){
            return winnerCount.get(0).name;
        }

        return "No Winner Yet";

    }

    public static String multiWinners (ArrayList<playerClass> winnerCount) {
        playerClass scoreMax = new playerClass("Winner");

        for(playerClass a : winnerCount) {
            if(a.score > scoreMax.score) {
                scoreMax = a;
                System.out.println(a);
            }
        }

        return scoreMax.name;
    }

}

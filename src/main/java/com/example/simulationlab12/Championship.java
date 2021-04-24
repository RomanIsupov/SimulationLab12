package main.java.com.example.simulationlab12;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import static java.lang.Thread.sleep;

public class Championship {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello. This is football championship.");
        System.out.println();
        int teamsAmount = 16;
        int activeTeamsAmount = teamsAmount;

        ArrayList<Team> teams = new ArrayList<>();
        for (int i = 0; i < teamsAmount; i++) {
            teams.add(new Team());
        }

        while (activeTeamsAmount > 1) {
            int home = getActiveTeam(teams, -1);
            int guests = getActiveTeam(teams, home);
            int score1 = teams.get(home).getScore();
            int score2 = score1;
            while (score1 == score2) {
                score2 = teams.get(guests).getScore();
            }

            System.out.println("Team " + (home + 1) + " vs Team " + (guests + 1));
            System.out.println(score1 + " : " + score2);
            if (score1 > score2) {
                System.out.println("Team " + (guests + 1) + " lost.");
                teams.get(guests).setActive(false);
            }
            else {
                System.out.println("Team " + (home + 1) + " lost.");
                teams.get(home).setActive(false);
            }
            System.out.println();
            activeTeamsAmount--;
            sleep(1000);
        }
        System.out.println("Team " + (getActiveTeam(teams, -1) + 1) + " won championship.");
        System.out.println("Hip-hip-hooray!");
    }

    private static int getActiveTeam(ArrayList<Team> teams, int exception) {
        int index;
        do {
            index = ThreadLocalRandom.current().nextInt(0, teams.size());
        } while (index == exception || !teams.get(index).isActive());
        return index;
    }
}

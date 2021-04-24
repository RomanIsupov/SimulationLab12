package main.java.com.example.simulationlab12;

import java.util.concurrent.ThreadLocalRandom;

public class Team {

    private final int lambda = ThreadLocalRandom.current().nextInt(1, 10);
    private boolean isActive = true;

    public int getScore() {
        int m = 0;
        double S = 0.0;
        while (S > -this.lambda) {
            S += Math.log(ThreadLocalRandom.current().nextDouble(0.0, 1.0));
            m++;
        }
        return m;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}

package in.spdev.ss.aop.afterreturningadvice.beans;

import java.util.Random;

public class RandomNumberGenerator {
    public int generateRandomNumber(){
        // Generate random integers in range 0 to 999
        return  new Random().nextInt(1000);
    }
}

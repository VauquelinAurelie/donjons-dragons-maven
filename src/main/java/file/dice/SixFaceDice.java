package file.dice;

import java.util.Random;

public class SixFaceDice implements Dice {
    private Random random;

    public SixFaceDice() {
        random = new Random();
    }

    @Override
    public int roll() {
        // Retourne un nombre aléatoire entre 1 et 6 pour le dé normal à six faces
        return random.nextInt(6) + 1;
    }
}

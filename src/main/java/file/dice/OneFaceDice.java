package file.dice;

public class OneFaceDice implements Dice {

    @Override
    public int roll() {   // Toujours renvoyer 1 pour le dé pipé à une face
        return 1;
    }
}

package file.personnages;

public class Sorcier extends Ennemi {
    // Constructeur avec un argument
    public Sorcier(String nom) {
        super(nom, 2, 9); // Appel du constructeur parent avec un nom
    }

    @Override
    public String toString() {
        return "Sorcier : "; // + getNom();
    }

}

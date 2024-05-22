package file.personnages;

public class Gobelin extends Ennemi {
    // Constructeur avec un argument
    public Gobelin(String nom) {
        super(nom, 1, 6); // Appel du constructeur de la classe parente pour initialiser le nom
    }

    @Override
    public String toString() {
        return "Gobelin : "; //+ getNom(); // Utilisation d'un getter pour accéder au nom
    }
}

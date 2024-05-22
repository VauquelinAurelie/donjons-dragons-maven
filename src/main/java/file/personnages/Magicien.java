package file.personnages;
import file.equipements.Sort;

public class Magicien extends Personnage { // Classe Magicien, héritant de Personnage
    private Sort offensif;

    // constructeur
    public Magicien(String nom) {
        super(nom, "Magicien", 6, 15,"Philtre");
    }

    // Redéfinition de la méthode attaquer
    @Override
    public void attaquer(Ennemi ennemi) {
        System.out.println("Le magicien " + nom + " attaque avec " + offensif + "!");
    }

    @Override
    public String toString() {
        return "Magicien : " + nom ;
    }

    public Sort getOffensif() {
        return offensif;
    }

}

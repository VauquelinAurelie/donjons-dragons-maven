package file.personnages;
import file.equipements.Arme;

public class Guerrier extends Personnage { // Classe Guerrier, héritant de Personnage
    private Arme offensif;

    // constructeur
    public Guerrier(String nom, String offensif) {
        super(nom, "Guerrier",10,10,"Bouclier");
    }

    // Redéfinition de la méthode attaquer
    @Override
    public void attaquer(Ennemi ennemi) { }

    @Override
    public String toString() {
        return "Guerrier : " + nom ;
    }

    public Arme getOffensif() {
        return offensif;
    }

}

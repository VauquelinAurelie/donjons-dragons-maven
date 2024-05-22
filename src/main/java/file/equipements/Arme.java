package file.equipements;
import file.game.Game;
import file.game.Menu;
import file.personnages.Guerrier;
import file.personnages.Personnage;
import file.plateau.ContenuCase;

public class Arme extends EquipementOffensif implements ContenuCase { // Classe Arme, héritant de EquipementOffensif
    private int niveauAttaque;

    // Constructeur prenant en compte le bonus d'attaque
    public Arme(String nom, int niveauAttaque) {
        super(nom, niveauAttaque, 0, "Arme"); // L'attaque de l'arme est initialisée à 0 car elle sera modifiée par le bonus
        this.niveauAttaque = niveauAttaque;
    }

    // Implémentation de la méthode interaction
    @Override
    public void interaction(Personnage personnage, Menu menu, Game game) {
        if (personnage instanceof Guerrier guerrier) {  // Vérifie si le personnage est un Guerrier
            Arme armeActuelle = guerrier.getArme();  // Obtient l'arme actuellement équipée par le Guerrier
            if (armeActuelle == null || armeActuelle.getNiveauAttaque() < niveauAttaque) {  // Vérifie si l'arme actuelle est moins puissante
                System.out.println(guerrier.getNom() + " a pris l'arme " + getNom());
                System.out.println(guerrier.getNom() + "ta force d'attaque augmente de  " + getNiveauAttaque());

                guerrier.setArme(this);
                guerrier.setForceAttaqueActuelle(guerrier.getForceAttaqueActuelle() + guerrier.getArme().getNiveauAttaque());
            } else {
                System.out.println(guerrier.getNom() + " possède déjà une arme plus puissante.");
            }
        } else {
            System.out.println(personnage.getNom() + " n'est pas un guerrier et ne peut pas prendre l'arme.");
        }
    }

    public String getNom() {
        return super.getNom();
    }

    // Méthode pour obtenir le bonus d'attaque
    public int getNiveauAttaque() {
        return niveauAttaque;
    }

    // Redéfinition de la méthode toString
    @Override
    public String toString() {
        return "Arme : " + nom + ", Niveau d'attaque : " + niveauAttaque;
    }
}
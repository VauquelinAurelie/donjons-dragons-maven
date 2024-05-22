package file.personnages;
import file.game.Game;
import file.game.Menu;
import file.plateau.ContenuCase;
import java.util.Scanner;

public class Ennemi implements ContenuCase {
    private String nom;
    protected int niveauVie;
    protected int niveauVieActuel;
    protected int forceAttaque;
    protected int forceAttaqueActuelle;


    public Ennemi(String nom, int forceAttaque, int niveauVie) {
        this.nom = nom;
        this.niveauVie = niveauVie;
        this.forceAttaque = forceAttaque;
        this.forceAttaqueActuelle = forceAttaque;
    }

    public void interaction(Personnage personnage, Menu menu, Game game) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Combat avec l'ennemi " + getNom() + " !");

        while (niveauVie > 0 && personnage.getNiveauVie() > 0) {
            // demander si le personnage souhaite fuire avant le combat
            if (menu.demandeFuite(game,personnage)){
                return;
            }

            // Le personnage attaque l'ennemi
            int degatsInfliges = personnage.getForceAttaqueActuelle();// Force de base du personnage
            subirDegats(degatsInfliges);
            System.out.println("Vous attaquez l'ennemi et infligez " + degatsInfliges + " points de dégâts.");

            // Afficher le niveau de vie de l'ennemi après l'attaque
            System.out.println("Niveau de vie de l'ennemi " + getNom() + " : " + getNiveauVie());

            // demander si le personnage souhaite fuire après avoir attaqué
            if (menu.demandeFuite(game, personnage)) {
                return;
            }

            // Vérifie si l'ennemi est vaincu
            if (getNiveauVie() <= 0) {
                System.out.println("L'ennemi est vaincu !");
            } else {
                // L'ennemi contre-attaque
                int degatsEnnemi = getNiveauAttaque(); // Utilisation de la force d'attaque du personnage
                personnage.subirDegats(degatsEnnemi); // Le personnage subit les dégâts de l'ennemi

                // Afficher le niveau de vie du personnage après la contre-attaque de l'ennemi
                System.out.println("L'ennemi " + this.nom + " a subi " + degatsInfliges + " points de dégâts.");
                System.out.println("Nouveau niveau de vie du personnage : " + personnage.getNiveauVie());

                // Vérifie si le personnage est vaincu
                if (personnage.getNiveauVie() <= 0) {
                    System.out.println("Le personnage est vaincu !");
                    menu.afficherDefaite();
                    game.terminerPartie();
                }
            }
        }
    }

    public void subirDegats(int degats) {
        this.niveauVie -= degats;
    }

    @Override
    public String toString() { return "Ennemi : " + nom; }

    public int getNiveauVie() { return niveauVie; }
    public void setNiveauVie(int niveauVie) { this.niveauVie = niveauVie; }

    public int getNiveauAttaque() { return forceAttaqueActuelle; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
}

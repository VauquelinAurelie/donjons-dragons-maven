package file.game;
import file.dice.SixFaceDice;
import file.plateau.PersonnageHorsPlateauException;
import file.plateau.Plateau;
import file.personnages.Personnage;
import file.dice.Dice;
import file.plateau.ContenuCase;

public class Game {
    private String joueur;
    private int[] plateau;
    private Dice dice;
    private String menu;
    private boolean partieTerminee = false;

    // Méthode pour configurer le dé utilisé dans le jeu
    public void choisirDe(Dice dice) {
        this.dice = dice;
    }

    public void intialisePartie(Menu menu) throws PersonnageHorsPlateauException {
        menu.afficherMenu();  // Afficher le menu
    }

    public void jouer(Plateau plateau, Personnage personnage, Menu menu) throws PersonnageHorsPlateauException {
        int nombreCase = plateau.getNombreCase();

        // choix du dé
//        choisirDe(new OneFaceDice());
        choisirDe(new SixFaceDice());

        // Boucle pour déplacer le personnage jusqu'à la dernière case du plateau
        while (!partieTerminee) {
            int diceRoll = dice.roll(); // lancer du dé choisi
            int positionFinale = deplacement(personnage, diceRoll);
            // Afficher le déplacement
            menu.afficherDeplacement(this, personnage, positionFinale, diceRoll);

            // Obtenir le contenu de la case actuelle
            ContenuCase contenuCase = plateau.getContenuCase(personnage.getPosition() - 1);

            // Si le contenu de la case n'est pas nul, interagir avec la case
            if (contenuCase != null) {
                System.out.print("La case contient : ");
                // Appeler la méthode interaction de la case
                contenuCase.interaction(personnage, menu, this);
            }
            System.out.println("niveau de vie  : " + personnage.getNiveauVie());
            System.out.println("force d'attaque  : " + personnage.getForceAttaqueActuelle());

            // Vérifier la condition de victoire
            if (personnage.getPosition() == nombreCase) {
                menu.afficherVictoire();  // le joueur a gagné !
                break; // Sortir de la boucle
            }

            //Vérifier si la partie est terminée
            if (partieTerminee) {
                break;
            }

            // Vérifier si le personnage est sorti du plateau
            if (personnage.getPosition() > nombreCase) {
                throw new PersonnageHorsPlateauException();
            }
        }
    }

    public void fuir(Personnage personnage) {
        // Utilisation du dé pour déterminer le recul aléatoire
        int diceRoll = dice.roll();
        int newPosition = personnage.getPosition() - diceRoll;
        personnage.setPosition(newPosition);
        System.out.println("Vous avez fui de " + diceRoll + " cases !");
        System.out.println("Vous êtes sur la cases : " + personnage.getPosition());
    }
    public void terminerPartie() {
        partieTerminee = true;
    }
    public void reset() {
        partieTerminee =false;
    }  // Réinitialiser d'autres variables d'état du jeu pour rejouer

    public int deplacement(Personnage personnage, int diceRoll) {
        int currentPosition = personnage.getPosition();
        currentPosition += diceRoll;
        personnage.setPosition(currentPosition);
        return currentPosition;
    }
}

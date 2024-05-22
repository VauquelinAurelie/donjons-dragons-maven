package file.equipements;
import file.game.Game;
import file.personnages.Personnage;
import file.plateau.ContenuCase;
import file.game.Menu;

public class Potion extends EquipementOffensif implements ContenuCase {
    private int niveauVie;
    protected EquipementOffensif offensif;

    // constructeur
    public Potion(String nom, int niveauVie) {
        super(nom, 0, niveauVie, "Potion");
        this.niveauVie = niveauVie;
    }

    // Implémentation de la méthode interaction
    @Override
    public void interaction(Personnage personnage, Menu menu, Game game) {
        if (personnage != null) {
            Potion potionActuelle = personnage.getPotion(); // Utiliser getPotion() au lieu de getOffensif()
            if (potionActuelle == null || potionActuelle.getNiveauVie() < niveauVie) {
                personnage.setPotion(this); // Utiliser setPotion() au lieu de setOffensif()
                personnage.setNiveauVie(personnage.getNiveauVie() + niveauVie);
                System.out.println(personnage.getNom() + " a pris la potion " + getNom());
                System.out.println(personnage.getNom() + " ton niveau de vie augmente de " + getNiveauVie());
            } else {
                System.out.println(personnage.getNom() + " possède déjà une potion plus puissante.");
            }
        }
    }

    // Redéfinition de la méthode toString
    @Override
    public String toString() {
        return "Potion : " + nom + ", Niveau de vie : " + niveauVie;
    }

    public void setOffensif(EquipementOffensif offensif) {
        this.offensif = offensif;
    }

    public int getNiveauAttaque() {
        // Implémentez la logique pour obtenir le niveau d'attaque de la potion
        return niveauAttaque; // Par exemple, retournez le niveau d'attaque de la potion
    }
}

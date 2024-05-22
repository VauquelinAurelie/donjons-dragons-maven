package file.equipements;
import file.game.Game;
import file.personnages.Magicien;
import file.personnages.Personnage;
import file.plateau.ContenuCase;
import file.game.Menu;

public class Sort extends EquipementOffensif implements ContenuCase { // Classe Sort, héritant de EquipementOffensif
    private int niveauAttaque;

    // constructeur
    public Sort(int niveauAttaque, String nom) {
        super(nom, niveauAttaque, 0,"Sort");
        this.niveauAttaque = niveauAttaque;
    }

    // Implémentation de la méthode interaction
    @Override
    public void interaction(Personnage personnage, Menu menu, Game game) {
        if (personnage instanceof Magicien magicien) {
            Sort sortActuel = magicien.getSort();
            if (sortActuel == null || sortActuel.getNiveauAttaque() < niveauAttaque) {
                magicien.setSort(this);
                System.out.println(magicien.getNom() + " a pris le sort " + getNom());
                System.out.println(magicien.getNom() + " ta force d'attaque augmente de " + getNiveauAttaque());

                magicien.setSort(this);
                magicien.setForceAttaqueActuelle(magicien.getForceAttaqueActuelle() + magicien.getSort().getNiveauAttaque());
            } else {
                System.out.println(magicien.getNom() + " possède déjà un sort plus puissant.");
            }
        } else {
            System.out.println(personnage.getNom() + " n'est pas un magicien et ne peut pas prendre le sort.");
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
        return "Sort : " + nom + ", Niveau d'attaque : " + niveauAttaque;
    }

}

package file.equipements;

public class Philtre extends EquipementDefensif{ // Classe Philtre, héritant de EquipementDefensif
    // constructeur
    public Philtre() {
        super("Defensif", 5, "Philtre");
    }

    // Redéfinition de la méthode toString
    @Override
    public String toString() {
        return "Philtre : " + nom + ", Niveau de défense : " + niveauDefense;
    }
}

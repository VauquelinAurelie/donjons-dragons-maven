package file.equipements;

public class Bouclier extends EquipementDefensif{ // Classe Bouclier, héritant de EquipementDefensif
    // construteur
    public Bouclier() {
        super("Defensif", 3, "Bouclier");
    }

    // Redéfinition de la méthode toString
    @Override
    public String toString() {
        return "Bouclier : " + nom + ", Niveau de défense : " + niveauDefense;
    }
}

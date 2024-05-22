package file.equipements;

public abstract class EquipementDefensif { // Equipement défensif par défaut "bouclier" ou "philtre"
    protected String type;
    protected int niveauDefense;
    protected String nom;

    // Constructeur
    public EquipementDefensif(String type, int niveauDefense, String nom) {
        this.type = type;
        this.niveauDefense = niveauDefense;
        this.nom = nom;
    }

    // Redéfinition de la méthode toString
    @Override
    public abstract String toString();
}
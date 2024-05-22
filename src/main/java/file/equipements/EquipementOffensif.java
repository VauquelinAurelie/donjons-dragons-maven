package file.equipements;

public abstract class EquipementOffensif { // Equipement offensif "arme", "sort" ou "potion"
    protected String type;
    protected int niveauVie;
    protected int niveauAttaque;
    protected String nom;
    protected int position;

    // constructeur
    public EquipementOffensif(String nom, int niveauAttaque, int niveauVie, String type) {
        this.type = type;
        this.niveauVie = niveauVie;
        this.niveauAttaque = niveauAttaque;
        this.nom = nom;
    }

    public abstract int getNiveauAttaque();

    // Redéfinition de la méthode toString
    @Override
    public abstract String toString();

    // getters et setters
    public String getNom() { return nom; }

    public int getNiveauVie() { return niveauVie; }

    public int getPosition() { return position; }

    public void setPosition(int position) { this.position = position; }
}

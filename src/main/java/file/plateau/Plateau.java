package file.plateau;

import file.equipements.Arme;
import file.equipements.Potion;
import file.equipements.Sort;
import file.personnages.Ennemi;
import file.plateau.ContenuCase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Plateau {
    private ContenuCase[] cases;

    public Plateau(int nombreCase) {
        cases = new ContenuCase[nombreCase];
        this.initialisationCase();
    }

    // méthode pour initialiser les cases avec leur contenu
    private void initialisationCase() {
        List<ContenuCase> contenus = new ArrayList<>();

        // Ajouter les ennemis
        for (int i = 0; i < 4; i++) {
            contenus.add(new Ennemi("Dragon", 4, 15));
        }
        for (int i = 0; i < 10; i++) {
            contenus.add(new Ennemi("Sorcier", 2, 9));
        }
        for (int i = 0; i < 10; i++) {
            contenus.add(new Ennemi("Gobelin", 1, 6));
        }

        // Ajouter les caisses surprises
        for (int i = 0; i < 5; i++) {
            contenus.add(new Arme("Massue", 3));
        }
        for (int i = 0; i < 4; i++) {
            contenus.add(new Arme("Epee", 5));
        }
        for (int i = 0; i < 5; i++) {
            contenus.add(new Sort(2, "Eclair"));
        }
        for (int i = 0; i < 2; i++) {
            contenus.add(new Sort(7, "Boule de feu"));
        }
        for (int i = 0; i < 6; i++) {
            contenus.add(new Potion("Potion Standard", 2));
        }
        for (int i = 0; i < 2; i++) {
            contenus.add(new Potion("Grande Potion", 5));
        }

        // Mélanger la liste des contenus
        Collections.shuffle(contenus);

        // Placer les contenus mélangés dans les cases du plateau
        for (int i = 0; i < cases.length; i++) {
            if (i < contenus.size()) {
                cases[i] = contenus.get(i);
            } else {
                cases[i] = null; // Les cases vides
            }
        }
    }

    public int getNombreCase() {
        return cases.length;
    }

    public ContenuCase getContenuCase(int index) {
        if (index >= 0 && index < cases.length) {
            return cases[index];
        } else {
            System.out.println("Index de case invalide.");
            return null;
        }
    }
}

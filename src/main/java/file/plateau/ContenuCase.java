package file.plateau;
import file.game.Game;
import file.game.Menu;
import file.personnages.Personnage;

public interface ContenuCase {
    void interaction(Personnage personnage, Menu menu, Game game);
}

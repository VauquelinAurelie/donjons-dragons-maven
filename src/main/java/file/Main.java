package file;
import file.game.Game;
import file.game.Menu;
import file.plateau.PersonnageHorsPlateauException;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws PersonnageHorsPlateauException, SQLException {
        // création des instances des classes Menu et Game
//        Menu menu = new Menu();
//        Game game = new Game();
//
//        game.intialisePartie(menu);

//

        DataBase db = new DataBase();
        db.getHero();
    }
}

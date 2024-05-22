package file.plateau;

public class PersonnageHorsPlateauException extends Exception {
    public PersonnageHorsPlateauException() {
        super("Le personnage est sorti du plateau!");
    }

    public PersonnageHorsPlateauException(String message) {
        super(message);
    }
}

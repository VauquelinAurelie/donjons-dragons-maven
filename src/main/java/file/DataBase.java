package file;

import com.sun.jdi.Value;
import file.personnages.Personnage;

import java.sql.*;


public class DataBase {
    private String HOSTNAME;
    private String DBNAME;
    private String USERNAME;
    private String PWD;

    public DataBase() {
        this.HOSTNAME = "localhost";
        this.DBNAME = "donjon-dragon";
        this.USERNAME = "Aurelie_vauquelin";
        this.PWD = "23Manatea";
    }

    public String getHostname() {
        return this.HOSTNAME;
    }

    public String getDBName() {
        return this.DBNAME;
    }

    public String getUsername() {
        return this.USERNAME;
    }

    public String getPwd() {
        return this.PWD;
    }

    public String getUrl() {
        return "jdbc:mysql://" + this.HOSTNAME + "/" + this.DBNAME;
    }

    public Connection getConnection() throws SQLException {
        try {
            return DriverManager.getConnection(getUrl(), getUsername(), getPwd());
        } catch (SQLException e) {
            System.out.println("Failed connection to database!");
        }

        return null;
    }

    public void getHero() throws SQLException {
        String req = "SELECT * FROM Hero";

        ResultSet res = getConnection().prepareStatement(req).executeQuery();

        while (res.next()) {
            System.out.println(res.getString("Nom"));
        }
    }

    public void createHero(Personnage personnage) throws SQLException {
        String req = "INSERT INTO Hero (Type, Nom, NiveauVie, NiveauForce, Offensif, Défensif) " + "VALUES (?,?,?,?,?,?)";
        PreparedStatement preparedStatement = getConnection().prepareStatement(req);
        preparedStatement.setString(1, personnage.getType());
        preparedStatement.setString(2, personnage.getNom());
        preparedStatement.setInt(3, personnage.getNiveauVie());
        preparedStatement.setInt(4, personnage.getForceAttaque());
//        preparedStatement.setString(5, personnage.getOffensif().toString());
//        preparedStatement.setString(6, personnage.getDefensif().toString());
        if (personnage.getOffensif() != null) {
            preparedStatement.setString(5, personnage.getOffensif().toString());
        } else {
            preparedStatement.setNull(5, Types.VARCHAR); // ou utiliser setString(5, null) selon le type en base de données
        }

        // Vérifier si Défensif n'est pas null avant de l'ajouter à la base de données
        if (personnage.getDefensif() != null) {
            preparedStatement.setString(6, personnage.getDefensif().toString());
        } else {
            preparedStatement.setNull(6, Types.VARCHAR); // ou utiliser setString(6, null) selon le type en base de données
        }
        preparedStatement.executeUpdate();
//        ResultSet res = getConnection().createStatement(preparedStatement).executeQuery();
    }

}



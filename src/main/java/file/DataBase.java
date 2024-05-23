package file;

import java.sql.*;


public class DataBase {
    private String HOSTNAME;
    private String DBNAME;
    private String USERNAME;
    private String PWD;

    public DataBase() {
        this.HOSTNAME = "localhost";
        this.DBNAME = "dongon-dragon";
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

}



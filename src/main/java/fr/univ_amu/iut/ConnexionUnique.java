package fr.univ_amu.iut;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionUnique {
    private Connection connection;
    private static ConnexionUnique instance = null;
    private static final String CONNECT_URL = "jdbc:mysql://mysql-maxdecorde.alwaysdata.net:3306/maxdecorde_jdbc";
    private static final String LOGIN = "144529_maxdecord";
    private static final String PASSWORD = "Maxime.131";

    private ConnexionUnique ()
    {
        try {
            connection =  DriverManager.getConnection(CONNECT_URL,LOGIN,PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection () { return connection; }

    public static ConnexionUnique getInstance () {
        if(instance == null)
            instance = new ConnexionUnique();
        return instance;
    }
}

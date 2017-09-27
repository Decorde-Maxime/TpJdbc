package fr.univ_amu.iut;

import java.sql.*;

/**
 * Created by d16013755 on 27/09/17.
 */
public class TestConnexion {
        static final String CONNECT_URL = "jdbc:mysql://mysql-maxdecorde.alwaysdata.net:3306/maxdecorde_jdbc";
        static final String LOGIN = "144529_maxdecord";
        static final String PASSWORD = "Maxime.131";
        // La requete de test
        static final String req = "SELECT NUM_ET, NOM_ET, PRENOM_ET " +
                "FROM ETUDIANT " +
                "WHERE VILLE_ET = 'AIX-EN-PROVENCE'";

        public static void main(String[] args) throws SQLException {
            // Connexion a la base
            System.out.println("Connexion");
            try (Connection conn = DriverManager.getConnection(CONNECT_URL,LOGIN,PASSWORD)){
                System.out.println("Connecte\n");
                // Creation d'une instruction SQL
                Statement stmt = conn.createStatement();
                // Execution de la requete
                System.out.println("Execution de la requete : " + req );
                ResultSet rset = stmt.executeQuery(req);
                // Affichage du resultat
                while (rset.next()){
                    System.out.print(rset.getInt("NUM_ET") + " ");
                    System.out.print(rset.getString("NOM_ET") + " ");
                    System.out.println(rset.getString("PRENOM_ET"));
                }
                // Fermeture de l'instruction (liberation des ressources)
                stmt.close();
                System.out.println("\nOk.\n");
            } catch (SQLException e) {
                e.printStackTrace();// Arggg!!!
                System.out.println(e.getMessage() + "\n");
            }
        }
    }

package fr.univ_amu.iut.DAO;// Importer les classes jdbc

import fr.univ_amu.iut.ConnexionUnique;
import fr.univ_amu.iut.beans.Etudiant;

import java.sql.*;
import java.util.ArrayList;

public class TestEntite {
    // La requete de test
    static final String req = "SELECT *" +
            "FROM ETUDIANT ";

    public static void main(String[] args) throws SQLException {
        // Connexion a la base
        System.out.println("Connexion");
        try (Connection conn = ConnexionUnique.getInstance().getConnection()){
            System.out.println("Connecte\n");
            // Creation d'une instruction SQL
            Statement stmt = conn.createStatement();
            // Execution de la requete
            System.out.println("Execution de la requete : " + req );
            ResultSet rset = stmt.executeQuery(req);
            // Affichage du resultat
            ArrayList<Etudiant> etudiants = new ArrayList<>();
            while (rset.next()){
                Etudiant etudiant = new Etudiant();
                etudiant.setNumEt(rset.getInt("NUM_ET"));
                etudiant.setNomEt(rset.getString("NOM_ET"));
                etudiant.setPrenomEt(rset.getString("Prenom_ET"));
                etudiant.setCpEt(rset.getString("CP_ET"));
                etudiant.setVilleEt(rset.getString("Ville_ET"));
                etudiant.setAnnee(rset.getInt("Annee"));
                etudiant.setGroupe(rset.getInt("Groupe"));
                etudiants.add(etudiant);
            }
            for (int i = 0; i < etudiants.size(); i++)
            {
                System.out.print(etudiants.get(i).toString()+ "\n");
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

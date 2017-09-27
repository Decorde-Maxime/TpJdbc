package fr.univ_amu.iut;// Ne pas faire un copier/coller du pdf...

// Importer les classes jdbc

import fr.univ_amu.iut.beans.Etudiant;
import fr.univ_amu.iut.beans.Module;
import fr.univ_amu.iut.beans.Prof;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TestAsso1 {
    // La requete de test
    static final String req = "SELECT *" +
            "FROM PROF, MODULE " +
            "WHERE PROF.MAT_SPEC = MODULE.CODE";


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
            List<Prof> Pr = new ArrayList<>();
            List<Module> Mo = new ArrayList<>();
            // Affichage du resultat
            while (rset.next()){
                Prof prof = new Prof();
                prof.setNumProf(rset.getInt("NUM_PROF"));
                prof.setNomProf(rset.getString("NOM_PROF"));
                prof.setPrenomProf(rset.getString("PRENOM_PROF"));
                prof.setCpProf(rset.getString("CP_PROF"));
                prof.setVilleProf(rset.getString("VILLE_PROF"));
                Pr.add(prof);

                Module module = new Module();
                module.setCode(rset.getString("CODE"));
                module.setCoefCc(rset.getInt("COEFF_CC"));
                module.setCoefTest(rset.getInt("COEFF_TEST"));
                module.setDiscipline(rset.getString("DISCIPLINE"));
                module.sethCoursPrev(rset.getInt("H_COURS_PREV"));
                module.sethCoursRea(rset.getInt("H_COURS_REA"));
                module.sethTpPrev(rset.getInt("H_TP_PREV"));
                module.sethTpRea(rset.getInt("H_TP_REA"));

                Mo.add(module);
                prof.setMatSpec(module);

            }
            // Fermeture de l'instruction (liberation des ressources)
            stmt.close();
            System.out.println("\nOk.\n");
            System.out.println(Pr);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage() + "\n");
        }

    }
}

package fr.univ_amu.iut.DAO.JDBC;

import fr.univ_amu.iut.ConnexionUnique;
import fr.univ_amu.iut.DAO.DAOEtudiant;
import fr.univ_amu.iut.beans.Etudiant;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOEtudiantJDBC implements DAOEtudiant {
    private Connection connection = ConnexionUnique.getInstance().getConnection();
    // La requete de test
    static final String reqEtudiants = "SELECT * FROM ETUDIANT";

    static final String reqEtudiantsByNom = "SELECT * FROM ETUDIANT WHERE NOM_ET = ?";

    @Override
    public int computeNbEtudiant() {
        return 0;
    }

    @Override
    public List<Etudiant> findByAnnee(int annee) {
        return null;
    }

    @Override
    public List<Etudiant> findByGroupe(int groupe) {
        return null;
    }

    @Override
    public List<Etudiant> findByNom(String nomEt) {
        try {
            PreparedStatement statement = connection.prepareStatement(reqEtudiantsByNom);
            statement.setString(1, nomEt);
            // Execution de la requete
            System.out.println("Execution de la requete : " + reqEtudiantsByNom);
            ResultSet rset = statement.executeQuery();

            // Affichage du resultat
            List<Etudiant> etudiants = new ArrayList<>();
            while (rset.next()) {
                etudiants.add(creerEtudiant(rset));
            }
            return etudiants;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean delete(Etudiant obj) {
        return false;
    }

    @Override
    public List<Etudiant> FindAll() {
        try {
            // Creation d'une instruction SQL
            Statement stmt = connection.createStatement();

            // Execution de la requete
            System.out.println("Execution de la requete : " + reqEtudiants);
            ResultSet rset = stmt.executeQuery(reqEtudiants);

            // Affichage du resultat
            List<Etudiant> etudiants = new ArrayList<>();
            while (rset.next()) {
                etudiants.add(creerEtudiant(rset));
            }
            return etudiants;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    private static Etudiant creerEtudiant(ResultSet rset) throws SQLException {
        Etudiant etudiant = new Etudiant();
        etudiant.setNumEt(rset.getInt("NUM_ET"));
        etudiant.setNomEt(rset.getString("NOM_ET"));
        etudiant.setPrenomEt(rset.getString("PRENOM_ET"));
        etudiant.setCpEt(rset.getString("CP_ET"));
        etudiant.setVilleEt(rset.getString("VILLE_ET"));
        etudiant.setAnnee(rset.getInt("ANNEE"));
        etudiant.setGroupe(rset.getInt("GROUPE"));
        return etudiant;
    }

    @Override
    public Etudiant getById(int id) {
        return null;
    }

    @Override
    public Etudiant insert(Etudiant obj) {
        return null;
    }

    @Override
    public boolean update(Etudiant obj) {
        return false;
    }
}

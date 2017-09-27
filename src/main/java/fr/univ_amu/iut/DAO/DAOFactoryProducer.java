package fr.univ_amu.iut.DAO;

public class DAOFactoryProducer {
    public static DAOFactory getFactory(String choice) {
        if (choice.equalsIgnoreCase("JDBC")) {
            return null;
        }
        return null;
    }
}
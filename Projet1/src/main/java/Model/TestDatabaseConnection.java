package Model;

import java.sql.Connection;
import java.sql.SQLException;

public class TestDatabaseConnection {
    public static void main(String[] args) {
        // Obtenir une connexion à la base de données
        Connection connection = DbConnection.getConnexion();

        // Vérifier si la connexion est établie
        if (connection != null) {
            System.out.println("La connexion à la base de données est établie avec succès !");
            try {
                // Fermer la connexion
                connection.close();
                System.out.println("La connexion à la base de données est fermée.");
            } catch (SQLException e) {
                System.out.println("Erreur lors de la fermeture de la connexion à la base de données.");
                e.printStackTrace();
            }
        } else {
            System.out.println("Impossible d'établir la connexion à la base de données.");
        }
    }
}

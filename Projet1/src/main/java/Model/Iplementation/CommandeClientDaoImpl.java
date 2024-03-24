package Model.Iplementation;

import Model.CommandeClient;
import Model.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommandeClientDaoImpl {
    private  final Connection connection = DbConnection.getConnexion();

    public List<CommandeClient> getCommandesClient(int idClient) throws SQLException {
        List<CommandeClient> resultats = new ArrayList<>();

        String requete = "SELECT c.id AS commande_id, c.dateCommande, lc.qteCde, a.designation, a.prix " +
                "FROM commandes c " +
                "INNER JOIN lignesCommande lc ON c.id = lc.commande_id " +
                "INNER JOIN articles a ON lc.article_id = a.id " +
                "WHERE c.client_id = ?";

        try (PreparedStatement statement = connection.prepareStatement(requete)) {
            statement.setInt(1, idClient);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    CommandeClient commande = new CommandeClient();
                    commande.setIdCommande(resultSet.getInt("commande_id"));
                    commande.setDateCommande(resultSet.getDate("dateCommande"));
                    commande.setQteCde(resultSet.getInt("qteCde"));
                    commande.setDesignationArticle(resultSet.getString("designation"));
                    commande.setPrixArticle(resultSet.getDouble("prix"));
                    resultats.add(commande);
                }
            }
        }
        return resultats;
    }
}
package Model.Iplementation;

import Model.DbConnection;
import Model.LignesCommande;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LignesCommandeDaoImpl {
    private PreparedStatement stm;
    private static Connection con;
    public void addLigneCommande(LignesCommande ligneCommande) throws SQLException {
        try {
            con = DbConnection.getConnexion();
            String query = "INSERT INTO lignescommande (commande_id, article_id, qteCde) VALUES (?, ?, ?)";
            stm = con.prepareStatement(query);
            stm.setInt(1, ligneCommande.getCommandeId());
            stm.setInt(2, ligneCommande.getArticleId());
            stm.setInt(3, ligneCommande.getQteCde());
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

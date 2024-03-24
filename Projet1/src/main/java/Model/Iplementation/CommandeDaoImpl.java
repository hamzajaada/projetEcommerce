package Model.Iplementation;

import Model.Commande;
import Model.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CommandeDaoImpl {
    private PreparedStatement stm;
    private ResultSet rs;
    private static Connection con;

    public void addCommande(Commande commande) throws SQLException {
        try {
            con = DbConnection.getConnexion();
            String query = "INSERT INTO commandes (client_id, dateCommande) VALUES (?, ?)";
            stm = con.prepareStatement(query);
            stm.setInt(1, commande.getClient().getId());
            stm.setDate(2, new java.sql.Date(commande.getDateCommande().getTime()));
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

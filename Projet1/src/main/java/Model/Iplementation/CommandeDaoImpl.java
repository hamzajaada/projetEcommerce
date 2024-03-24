package Model.Iplementation;

import Model.Commande;
import Model.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CommandeDaoImpl {
    private PreparedStatement stm;
    private ResultSet rs;
    private static Connection con;

    public int addCommande(Commande commande) throws SQLException {
        int commandeId = -1;
        try {
            con = DbConnection.getConnexion();
            String query = "INSERT INTO commandes (client_id, dateCommande) VALUES (?, ?)";
            stm = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stm.setInt(1, commande.getClient().getId());
            stm.setDate(2, new java.sql.Date(commande.getDateCommande().getTime()));
            stm.executeUpdate();

            ResultSet rs = stm.getGeneratedKeys();
            if (rs.next()) {
                commandeId = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return commandeId;
    }
}

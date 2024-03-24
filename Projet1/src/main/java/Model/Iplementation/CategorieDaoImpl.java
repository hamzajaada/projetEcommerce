package Model.Iplementation;

import Model.Categorie;
import Model.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CategorieDaoImpl {

    private PreparedStatement stm;
    private ResultSet rs;
    private static Connection con;
    public Categorie getCategorieById(int id) {
        Categorie categorie = null;
        String request = "SELECT * FROM categories WHERE id = ?";
        try {
            con = DbConnection.getConnexion();
            stm = con.prepareStatement(request);
            stm.setInt(1, id);
            rs = stm.executeQuery();
            if (rs.next()) {
                categorie = new Categorie(rs.getInt(1), rs.getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return categorie;
    }
}
package Model.Iplementation;
import Model.Client;
import Model.Dao.ClientDao;

import Model.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
public class ClientDaoImpl implements ClientDao {
    private  final Connection connection = DbConnection.getConnexion();
    private static final String INSERT_CLIENT_SQL = "insert into clients(nom,prenom,adresse,ville,codePostal,tel,motPasse) values (?,?,?,?,?,?,?)";
    private static final String FIND_CLIENT_SQL = "select * from clients where id = ?";
    private static final String FIND_CLIENT_EXIST_SQL = "select * from clients where nom = ? and motPasse = ?";

    @Override
    public void AddClient(Client c) throws SQLException {
        try (
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CLIENT_SQL)) {
            preparedStatement.setString(1, c.getNom());
            preparedStatement.setString(2, c.getPrenom());
            preparedStatement.setString(3, c.getAdresse());
            preparedStatement.setString(4, c.getVille());
            preparedStatement.setInt(5, c.getCodePostal());
            preparedStatement.setString(6, c.getTel());
            preparedStatement.setString(7, c.getMotPasse());
            preparedStatement.executeUpdate();
        }
    }


    @Override
    public Client findClientById(int id) {
        Client cl = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_CLIENT_SQL)) {
            preparedStatement.setInt(1, id);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                while(rs.next()){
                    cl = new Client(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(4),rs.getInt(6),rs.getString(7),rs.getString(8));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cl;
    }

    @Override
    public Client finClientByUsernameAndPassword(String username, String password) {
        Client c = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_CLIENT_EXIST_SQL)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                while(rs.next()){
                    c = new Client(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(4),rs.getInt(6),rs.getString(7),rs.getString(8));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
    }

    @Override
    public List<Client> getAllClient() {
        return null;
    }}


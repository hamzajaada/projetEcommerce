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
        return null;
    }

    @Override
    public boolean finClientByUsernameAndPassword(String username, String password) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_CLIENT_EXIST_SQL)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Log l'exception pour comprendre la cause du problème
        }
        return false;
    }

    @Override
    public List<Client> getAllClient() {
        return null;
    }}


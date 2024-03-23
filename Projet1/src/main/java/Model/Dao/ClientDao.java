package Model.Dao;
import Model.Client;
import Model.Client;


import java.sql.SQLException;
import java.util.List;

public interface ClientDao {
    public void AddClient(Client c) throws SQLException;

    public Client findClientById(int id);
    public boolean finClientByUsernameAndPassword(String username, String password);
    public List<Client> getAllClient();
}

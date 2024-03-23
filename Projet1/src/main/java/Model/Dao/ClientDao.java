package Model.Dao;
<<<<<<< HEAD



import Model.Client;


=======
>>>>>>> b855993589bb469dca46efc3b0e4fdd3b2a78e80
import Model.Client;

import java.sql.SQLException;
import java.util.List;

public interface ClientDao {
    public void AddClient(Client c) throws SQLException;

    public Client finClientById(int id);
    public Client finClientByUsernameAndPassword(String username, String password);
    public List<Client> getAllClient();
}

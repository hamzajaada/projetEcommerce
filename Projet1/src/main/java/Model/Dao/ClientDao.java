package Model.Dao;

<<<<<<< HEAD

import Model.Client;
=======
>>>>>>> ca167d9b677a30e4c33a9099f939110ace8e91e6

import Model.Client;

import java.sql.SQLException;
import java.util.List;

public interface ClientDao {
    public void AddClient(Client c) throws SQLException;

    public Client finClientById(int id);
    public Client finClientByUsernameAndPassword(String username, String password);
    public List<Client> getAllClient();
}

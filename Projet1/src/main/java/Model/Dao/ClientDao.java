package Model.Dao;

import Classes.Client;

import java.util.List;

public interface ClientDao {
    public void AddClient(Client c);
    public Client finClientById(int id);
    public Client finClientByUsernameAndPassword(String username, String password);
    public List<Client> getAllClient();
}

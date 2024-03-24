package Model;

import java.util.Date;

public class Commande {
    private int id;
    private Client client;
    private Date dateCommande;

    public Commande(int id, Client client, Date dateCommande) {
        this.id = id;
        this.client = client;
        this.dateCommande = dateCommande;
    }

    public Commande(Client client, Date dateCommande) {
        this.client = client;
        this.dateCommande = dateCommande;
    }

    public Commande() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }
}

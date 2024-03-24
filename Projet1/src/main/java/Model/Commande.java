package Model;

import java.util.Date;

public class Commande {
    private int id;
    private int client;
    private Date dateCommande;

    public Commande(int id, int client, Date dateCommande) {
        this.id = id;
        this.client = client;
        this.dateCommande = dateCommande;
    }

    public Commande(int client, Date dateCommande) {
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

    public int getClient() {
        return client;
    }

    public void setClient(int client) {
        this.client = client;
    }

    public Date getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    @Override
    public String toString() {
        return "Commande{" +
                "id=" + id +
                ", client=" + client +
                ", dateCommande=" + dateCommande +
                '}';
    }
}

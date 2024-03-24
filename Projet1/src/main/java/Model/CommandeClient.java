package Model;

import java.util.Date;

public class CommandeClient {
    private int idCommande;
    private Date dateCommande;
    private int qteCde;
    private String designationArticle;
    private double prixArticle;

    public CommandeClient(int idCommande, Date dateCommande, int qteCde, String designationArticle, double prixArticle) {
        this.idCommande = idCommande;
        this.dateCommande = dateCommande;
        this.qteCde = qteCde;
        this.designationArticle = designationArticle;
        this.prixArticle = prixArticle;
    }

    public CommandeClient() {
    }

    public int getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }

    public Date getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    public int getQteCde() {
        return qteCde;
    }

    public void setQteCde(int qteCde) {
        this.qteCde = qteCde;
    }

    public String getDesignationArticle() {
        return designationArticle;
    }

    public void setDesignationArticle(String designationArticle) {
        this.designationArticle = designationArticle;
    }

    public double getPrixArticle() {
        return prixArticle;
    }

    public void setPrixArticle(double prixArticle) {
        this.prixArticle = prixArticle;
    }
}

package Model;

public class LignesCommande {
    private int commandeId;
    private int articleId;
    private int qteCde;

    public LignesCommande() {
    }

    public LignesCommande(int commandeId, int articleId, int qteCde) {
        this.commandeId = commandeId;
        this.articleId = articleId;
        this.qteCde = qteCde;
    }

    public int getCommandeId() {
        return commandeId;
    }

    public void setCommandeId(int commandeId) {
        this.commandeId = commandeId;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public int getQteCde() {
        return qteCde;
    }

    public void setQteCde(int qteCde) {
        this.qteCde = qteCde;
    }


}

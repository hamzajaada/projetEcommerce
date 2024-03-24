package Model;

public class Categorie {
    private int id;
    private String categorie;

    public Categorie() {
    }

    public Categorie(String categorie) {
        this.categorie = categorie;
    }

    public Categorie(int id,String categorie) {
        this.id = id;
        this.categorie = categorie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }
}

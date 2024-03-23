package Model;

public class Article {
    // Attributs
    private int id;
    private String designation;
    private double prix;
    private int stock;
    private int category_id;
    private String photo;

    public Article() {
    }

    // Constructeur
    public Article(int id, String designation, double prix, int stock, int category_id, String photo) {
        this.id = id;
        this.designation = designation;
        this.prix = prix;
        this.stock = stock;
        this.category_id = category_id;
        this.photo = photo;
    }

    // Getters et setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }


}

package Model;

public class Client {
    private int id;
    private String nom;
    private String prenom;
    private String adresse;
    private String ville;
    private int codePostal;
    private String tel;

    private String motPasse;

    public Client(int id, String nom, String prenom, String adresse, String ville, int codePostal, String tel, String motPasse) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.ville = ville;
        this.codePostal = codePostal;
        this.tel = tel;
        this.motPasse = motPasse;
    }

    public Client(String nom, String prenom, String adresse, int codePostal, String ville, String tel, String motPasse) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.ville = ville;
        this.codePostal = codePostal;
        this.tel = tel;
        this.motPasse = motPasse;
    }

    public Client() {
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public int getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getMotPasse() {
        return motPasse;
    }

    public void setMotPasse(String motPasse) {
        this.motPasse = motPasse;
    }
}

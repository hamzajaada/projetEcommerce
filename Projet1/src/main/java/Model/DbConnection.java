package Model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static Connection con = null;
    private static String url = "jdbc:mysql://localhost:3306/ecomercejee";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url,"root","");
            System.out.println("Connected to the database!");
        } catch (SQLException e) {
            System.out.println("Problème de base de données");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Problème avec le pilote");
            e.printStackTrace();
        }
    }

    public static Connection getConnexion() {
        return con;
    }
}

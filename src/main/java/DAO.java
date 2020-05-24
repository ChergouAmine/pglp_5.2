import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class DAO<T> {
  
    private Connection connect;
    public DAO() {
        try {
          System.out.println("ffff");
            connect = DriverManager.getConnection("jdbc:derby:Personnel;create=true");
            java.sql.Statement prepare = connect.createStatement();
            
            String query = "CREATE TABLE IF NOT EXISTS Personnel( "
                          + "id INT NOT NULL AUTO_INCREMENT, "
                          + "nom VARCHAR(255), "
                          + "prenom VARCHAR(255),"
                          + "DateNaissance VARCHAR(255), "
                          + "numero INT,"
                          + "PRIMARY KEY (id))";
               prepare.execute(query);        
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
   
    public abstract T create(T obj);
    public abstract T find(String id);
    public abstract T update(T obj);
    public abstract void delete(T obj);
    
    public Connection getConnection() {
        return connect;
    }
}
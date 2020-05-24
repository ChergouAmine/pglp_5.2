import java.sql.SQLException;

public final class DAOFactory implements java.io.Serializable {
    private static final long serialVersionUID = 25;
    private DAOFactory() {
    }
    
 public static DAO<Personnel> getPersonnelDAO(){
        return new PersonnelDAO();
    }
}
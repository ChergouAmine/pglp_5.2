import java.sql.SQLException;
import java.time.LocalDate;
import org.junit.Test;

public class DAOTest {
  
  @Test
  public void test() throws SQLException {
      
      DAO<Personnel> personnelDAO = new PersonnelDAO();
      LocalDate date=LocalDate.now();
      
      Personnel p1=new Personnel.Builder("CHERGOU","Amine",date).build();
      
      personnelDAO.create(p1);
      personnelDAO.find("CHERGOU");
      personnelDAO.delete(p1);
      
  }

}

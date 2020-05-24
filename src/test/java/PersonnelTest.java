import java.time.LocalDate;
import org.junit.Test;

public class PersonnelTest {
  @Test
  public void test() {
      LocalDate date=LocalDate.now();
      
      Personnel p1=new Personnel.Builder("CHERGOU","Amine",date).build();
      Personnel p2=new Personnel.Builder("ATTOUCHE","Maher",date).build();
      Personnel p3=new Personnel.Builder("ARAR","Maher",date).build();
      Personnel p4=new Personnel.Builder("BENAMAR","Ismail",date).build();
      Personnel p5=new Personnel.Builder("BENMAALEM","Amir",date).build();
      
      CompositePersonnel l1=new CompositePersonnel(1);
      CompositePersonnel l2=new CompositePersonnel(3);
      CompositePersonnel l3=new CompositePersonnel(4);
      
      
      l3.add(p1);
      l3.add(p2);
      
      
      l2.add(p3);
      l2.add(l3);
      
      l1.add(p5);
      l1.add(l2);
      
      
      Groupe affGrp = new Groupe(l1);
      for(Iterator iter = affGrp.getIterator();iter.hasNext();) {
          iter.next().print();
      }
      
  }
}

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CompositePersonnel implements Personnels, Serializable {

    private List<Personnel> listPersonnel = new ArrayList<Personnel>();
    private static final long serialVersionUID = 10;
    private final int id;
    
    public CompositePersonnel(final int i) {
        this.id = i;
    }


    public void add(final Personnel p) {
        listPersonnel.add(p);
    }

    public void add(final CompositePersonnel l) {
        for (Personnel p : l.getListe()) {
          listPersonnel.add(p);
        }
    }

    public List<Personnel> getListe() {
        return listPersonnel;
    }

    public void remove(final Personnel personnel) {
        listPersonnel.remove(personnel);
    }
    
    public void print() {
        System.out.println("ID: " + id);
        for (Personnel personnel : listPersonnel) {
            personnel.print();
        }
    }
}
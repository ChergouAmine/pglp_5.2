import java.io.Serializable;
import java.util.ArrayList;

public class Groupe implements Serializable {
   
    private ArrayList<Personnels> listP = new ArrayList<Personnels>();
    private static final long serialVersionUID = 15;
    
    public Groupe(final Personnels x) {
        listP.add(x);
    }

    private class GroupeIterator implements Iterator {
      
        private int test = 0;

        GroupeIterator() {
            while (test < listP.size()) {//SI c'est un groupe on ajouter tout ses composants
                if (listP.get(test) instanceof CompositePersonnel) {
                    CompositePersonnel composite = (CompositePersonnel) listP.get(test);
                    listP.remove(test);
                    
                    for (Personnel p : composite.getListe()) {
                        listP.add(p);
                    }
                }
                test++;
            }
            test = 0;
        }

        public boolean hasNext() {
            if (test < listP.size()) {
                return true;
            }
            return false;
        }

        public Personnels next() {
            if (this.hasNext()) {
                Personnels perso = listP.get(test++);
                return perso;
            }
            return null;
        }
    }

    public Iterator getIterator() {
        return new GroupeIterator();
    }
}

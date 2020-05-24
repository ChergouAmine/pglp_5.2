
import java.io.Serializable;
import java.time.LocalDate;


public final class Personnel implements Personnels, Serializable {

    private final String nom;
    private final String prenom;
    private final LocalDate dateDeNaissance;
    private final int numero;
    private static final long serialVersionUID = 5;
    
    
    private Personnel(final Builder builder) {
        nom = builder.nom;
        prenom = builder.prenom;
        dateDeNaissance = builder.dateDeNaissance;
        numero = builder.numero;
    }


    public static class Builder {
        private final String nom;
        private final String prenom;
        private final LocalDate dateDeNaissance;
        private int numero = 0;

        public Builder(final String n, final String p, final LocalDate d) {
            this.nom = n;
            this.prenom = p;
            this.dateDeNaissance = d;
        }
        
        public Builder numeroFixPro(final int numero) {
            this.numero = numero;
            return this;
        }

/**
 * Permet de recast en Peronnel.
 * @return {@link Personnel}
 */
        public Personnel build() {
           return new Personnel(this);
        }
    }
      
     public void print() {
        System.out.println(nom + " " + prenom);
    }
     
    public String getNom() {
        return this.nom;
    }
    
    public String getPrenom() {
        return this.prenom;
    }
    
    public LocalDate getDate() {
        return this.dateDeNaissance;
    }
    
    public int getNumero() {
        return this.numero;
    }
}

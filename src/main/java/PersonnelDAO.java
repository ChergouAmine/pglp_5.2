import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class PersonnelDAO extends DAO<Personnel> implements Serializable {
  
    private static final long serialVersionUID = 20;
    
    public Personnel create(final Personnel obj) {
        try {
            Connection connect = super.getConnection();
            
            PreparedStatement prepare = connect.prepareStatement("INSERT INTO Personnel"
                    + "(nom,prenom,DateNaissance,numero) VALUES(?,?,?,?)");
            prepare.setString(1, obj.getNom());
            prepare.setString(2, obj.getPrenom());
            prepare.setString(3, obj.getDate().toString());
            prepare.setInt(4, obj.getNumero());
            
            int result =  prepare.executeUpdate();
            assert result == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return obj;
    }
    
    
    public Personnel find(final String id) {
        Personnel p = null;
        try {
            Connection connect = super.getConnection();
            PreparedStatement prepare = connect.prepareStatement("SELECT *"
                    + " FROM Personnel "
                    + "WHERE nom = ?");
            
            prepare.setString(1, id);
            ResultSet result = prepare.executeQuery();
            
            if (result.next()) {
                p = new Personnel.Builder(result.getString("nom"),result.getString("prenom"), LocalDate.parse(result.getString("DateNaissance"))).build();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }
    
    public Personnel update(final Personnel obj) {
        try {
            Connection connect = super.getConnection();
            PreparedStatement prepare = connect.prepareStatement("UPDATE"
                    + " Personnel "
                    + "SET prenom = ?, DateNaissance = ?, numero = ? "
                    + "WHERE nom = ?");
            prepare.setString(1, obj.getPrenom());
            prepare.setString(2, obj.getDate().toString());
            prepare.setInt(3, obj.getNumero());
            prepare.setString(4, obj.getNom());
            
            int result =  prepare.executeUpdate();
            assert result == 1;
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return obj;
    }
    
    
    public void delete(final Personnel obj) {
        try {
            Connection connect = super.getConnection();
            PreparedStatement prepare = connect.prepareStatement("DELETE"
                    + " FROM Personnel "
                    + "WHERE nom = ?");
            prepare.setString(1, obj.getNom());
            int result =  prepare.executeUpdate();
            if (result == 1) {
                System.out.println("Personnel supprimé de la base");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
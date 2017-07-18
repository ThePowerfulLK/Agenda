package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Contato;
import util.Database;

public class ContatoDAO {

    private Database db;
    
    public ContatoDAO(){
        db = new Database();
    }
    
    public void insert(Contato contato){
        String sql = "INSERT INTO tb_contatos (con_nome, con_fone) VALUES (?, ?)";
        try{
        db.open();
        PreparedStatement ps = db.getConnection().prepareStatement(sql);
        ps.setString(1, contato.getNome());
        ps.setString(2, contato.getFone());
        ps.executeUpdate();
        } catch(SQLException error) {
            System.out.println("ERRO:" + error);
        } finally {
            db.close();
        }       
    }
 
    public List<Contato> selectAll(){
        String sql = "SELECT * FROM tb_contatos";
        try{
            db.open();
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Contato> contatos = new ArrayList<>();
            while(rs.next()){
                Contato contato = new Contato();
                contato.setId(rs.getInt("con_id"));
                contato.setNome(rs.getString("con_nome"));
                contato.setFone(rs.getString("con_fone"));
                contatos.add(contato);
            }
            db.close();
            return contatos;
        } catch(SQLException error){
            System.out.println("ERRO: " + error);
        }
        db.close();
        return null;
        
        
        /*return null;*/
        
    }
    
    public void delete(Contato contato){
        String sql = "DELETE FROM tb_contatos WHERE con_id = ?";
      try{
          db.open();
          PreparedStatement ps = db.getConnection().prepareStatement(sql);
          ps.setInt(1, contato.getId());
          ps.executeUpdate();   
      } catch (SQLException error){
          System.out.println("ERRO: " + error);
      } finally {
          db.close();
      }
    }
    
    public void update(Contato contato){
        String sql = "UPDATE tb_contatos SET con_nome = ?, con_fone = ? WHERE con_id = ?";
      try{
          db.open();
          PreparedStatement ps = db.getConnection().prepareStatement(sql);
          ps.setString(1, contato.getNome());
          ps.setString(2, contato.getFone());
          ps.setInt(3, contato.getId());
          ps.executeUpdate();
      } catch (SQLException error){
          System.out.println("ERRO: " + error);
        } finally{
          db.close();
      }
    
    }
    public Contato selectById(int id){
        Contato contato = new Contato();
        String sql = "SELECT * FROM tb_contatos WHERE con_id = ?";
       try{
           db.open();
           PreparedStatement ps = db.getConnection().prepareStatement(sql);
           ps.setInt(1, id);
           ResultSet rs = ps.executeQuery();
           if(rs.next()){
               contato.setId(rs.getInt("CON_ID"));
               contato.setNome(rs.getString("CON_NOME"));
               contato.setFone(rs.getString("CON_FONE"));
                
           }
       } catch (SQLException error){
           System.out.println("ERRO: " + error);
       } finally {
           db.close();
       }
      return contato;
    }
    
    public List<Contato> selectByLike(String texto){
        String sql = "SELECT * FROM tb_contatos LIKE"
    }
}

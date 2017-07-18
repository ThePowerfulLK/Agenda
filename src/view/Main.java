package view;

import dao.ContatoDAO;
import model.Contato;

public class Main {
    public static void main(String[] args) {
        
       Contato contato = new Contato();
//       contato.setId(2);
//       contato.setNome("Gabriel Sathler");
//       contato.setFone("84996326546");
//       
       
       ContatoDAO dao = new ContatoDAO();
       //dao.insert(contato);
       //dao.delete(contato);
       // dao.update(contato);
      
       
        System.out.println(dao.selectById(4));
//       System.out.println(dao.selectAll());
        
        
        
    }
    
}

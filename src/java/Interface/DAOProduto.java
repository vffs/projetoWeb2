package Interface;

import DAO.exceptions.NonexistentEntityException;
import Model.Produto;
import java.util.List;


public interface DAOProduto{
   
    public void create(Produto produto);
     public void edit(Produto produto)throws NonexistentEntityException, Exception;
    public void destroy(long id)throws NonexistentEntityException;
    public List<Produto> findProdutoEntities();
    
 }

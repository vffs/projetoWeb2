package Interface;

import DAO.exceptions.NonexistentEntityException;
import Model.Telefone;
import java.util.List;


public interface DAOTelefone{
    
    public void create(Telefone telefone);
    public void edit(Telefone telefone)throws NonexistentEntityException, Exception;
    public void destroy(long id)throws NonexistentEntityException;
    public List<Telefone> findTelefoneEntities();
    
 }

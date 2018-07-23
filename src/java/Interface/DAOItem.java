package Interface;

import DAO.exceptions.NonexistentEntityException;
import Model.Item;
import java.util.List;

public interface DAOItem{
    
    public void create(Item item);
    public void edit(Item item)throws NonexistentEntityException, Exception;
    public void destroy(long id)throws NonexistentEntityException;
    public List<Item> findItemEntities();
    
 }

package Interface;

import DAO.exceptions.NonexistentEntityException;
import Model.Compra;
import java.util.List;

public interface DAOCompra{
    
    public void create(Compra compra);
    public void edit(Compra compra)throws NonexistentEntityException, Exception;
    public void destroy(long id)throws NonexistentEntityException;
    public List<Compra> findCompraEntities();
    
 }

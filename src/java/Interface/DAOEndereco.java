package Interface;

import DAO.exceptions.NonexistentEntityException;
import Model.Endereco;
import java.util.List;

public interface DAOEndereco{
    
    public void create(Endereco endereco);
    public void edit(Endereco endereco)throws NonexistentEntityException, Exception;
    public void destroy(long id)throws NonexistentEntityException;
    public List<Endereco> findEnderecoEntities();
    
 }

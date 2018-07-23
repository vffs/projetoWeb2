package Interface;

import DAO.exceptions.NonexistentEntityException;
import Model.Usuario;
import java.util.List;

public interface DAOUsuario{
    
    public void create(Usuario usuario);
    public void edit(Usuario usuario)throws NonexistentEntityException, Exception;
    public void destroy(long id)throws NonexistentEntityException;
    public List<Usuario> findUsuarioEntities();
    
 }

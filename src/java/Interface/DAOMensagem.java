package Interface;

import DAO.exceptions.NonexistentEntityException;
import Model.Mensagem;
import java.util.List;


public interface DAOMensagem{
    
    public void create(Mensagem mensagem);
    public void edit(Mensagem mensagem)throws NonexistentEntityException, Exception;
    public void destroy(long id)throws NonexistentEntityException;
    public List<Mensagem> findMensagemEntities();
    
 }

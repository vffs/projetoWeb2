package Interface;

import DAO.exceptions.NonexistentEntityException;
import Model.PessoaFisica;
import java.util.List;

public interface DAOPessoaFisica{
    
    public void create(PessoaFisica pessoafisica);
    public void edit(PessoaFisica pessoafisica)throws NonexistentEntityException, Exception;
    public void destroy(long id)throws NonexistentEntityException;
    public List<PessoaFisica> findPessoaFisicaEntities();
    
 }

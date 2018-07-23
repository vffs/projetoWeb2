package Interface;

import DAO.exceptions.NonexistentEntityException;
import Model.PessoaJuridica;
import java.util.List;

public interface DAOPessoaJuridica{
    
    public void create(PessoaJuridica pessoajuridica);
    public void edit(PessoaJuridica pessoaJuridica)throws NonexistentEntityException, Exception;
    public void destroy(long id)throws NonexistentEntityException;
    public List<PessoaJuridica> findPessoaJuridicaEntities();
    
 }


package DAO;

import DAO.exceptions.NonexistentEntityException;
import Interface.DAOEndereco;
import Model.Endereco;
import Singleton.EntityManagerFactorySingleton;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class EnderecoDAO implements Serializable,DAOEndereco {

    EntityManagerFactory emf = EntityManagerFactorySingleton.getInstance();
    EntityManager em;

    public EntityManager getEntityManager() {
        
        EntityManager em = emf.createEntityManager();
        return em;
    }

    @Override
    public void create(Endereco endereco) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(endereco);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void edit(Endereco endereco) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            endereco = em.merge(endereco);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                long id = endereco.getIdendereco();
                if (findEndereco(id) == null) {
                    throw new NonexistentEntityException("The endereco with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void destroy(long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Endereco endereco;
            try {
                endereco = em.getReference(Endereco.class, id);
                endereco.getIdendereco();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The endereco with id " + id + " no longer exists.", enfe);
            }
            em.remove(endereco);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public List<Endereco> findEnderecoEntities() {
        return findEnderecoEntities(true, -1, -1);
    }

    public List<Endereco> findEnderecoEntities(int maxResults, int firstResult) {
        return findEnderecoEntities(false, maxResults, firstResult);
    }

    private List<Endereco> findEnderecoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Endereco.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Endereco findEndereco(long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Endereco.class, id);
        } finally {
            em.close();
        }
    }

    public int getEnderecoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Endereco> rt = cq.from(Endereco.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

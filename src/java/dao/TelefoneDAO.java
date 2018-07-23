
package DAO;

import DAO.exceptions.NonexistentEntityException;
import Interface.DAOTelefone;
import Model.Telefone;
import Singleton.EntityManagerFactorySingleton;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


public class TelefoneDAO implements Serializable,DAOTelefone {

    EntityManagerFactory emf = EntityManagerFactorySingleton.getInstance();
    EntityManager em;

    public EntityManager getEntityManager() {
        
        EntityManager em = emf.createEntityManager();
        return em;
    }
    @Override
    public void create(Telefone telefone) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(telefone);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void edit(Telefone telefone) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            telefone = em.merge(telefone);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                long id = telefone.getIdtelefone();
                if (findTelefone(id) == null) {
                    throw new NonexistentEntityException("The telefone with id " + id + " no longer exists.");
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
            Telefone telefone;
            try {
                telefone = em.getReference(Telefone.class, id);
                telefone.getIdtelefone();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The telefone with id " + id + " no longer exists.", enfe);
            }
            em.remove(telefone);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public List<Telefone> findTelefoneEntities() {
        return findTelefoneEntities(true, -1, -1);
    }

    public List<Telefone> findTelefoneEntities(int maxResults, int firstResult) {
        return findTelefoneEntities(false, maxResults, firstResult);
    }

    private List<Telefone> findTelefoneEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Telefone.class));
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

    public Telefone findTelefone(long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Telefone.class, id);
        } finally {
            em.close();
        }
    }

    public int getTelefoneCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Telefone> rt = cq.from(Telefone.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    
}

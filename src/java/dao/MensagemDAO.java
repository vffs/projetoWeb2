
package DAO;

import DAO.exceptions.NonexistentEntityException;
import Interface.DAOMensagem;
import Model.Mensagem;
import Singleton.EntityManagerFactorySingleton;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class MensagemDAO implements Serializable,DAOMensagem {

    EntityManagerFactory emf = EntityManagerFactorySingleton.getInstance();
    EntityManager em;

    public EntityManager getEntityManager() {
        
        EntityManager em = emf.createEntityManager();
        return em;
    }

    @Override
    public void create(Mensagem mensagem) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(mensagem);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void edit(Mensagem mensagem) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            mensagem = em.merge(mensagem);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                long id = mensagem.getIdmensagem();
                if (findMensagem(id) == null) {
                    throw new NonexistentEntityException("The mensagem with id " + id + " no longer exists.");
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
            Mensagem mensagem;
            try {
                mensagem = em.getReference(Mensagem.class, id);
                mensagem.getIdmensagem();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The mensagem with id " + id + " no longer exists.", enfe);
            }
            em.remove(mensagem);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public List<Mensagem> findMensagemEntities() {
        return findMensagemEntities(true, -1, -1);
    }

    public List<Mensagem> findMensagemEntities(int maxResults, int firstResult) {
        return findMensagemEntities(false, maxResults, firstResult);
    }

    private List<Mensagem> findMensagemEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Mensagem.class));
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

    public Mensagem findMensagem(long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Mensagem.class, id);
        } finally {
            em.close();
        }
    }

    public int getMensagemCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Mensagem> rt = cq.from(Mensagem.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

package br.com.bingo.dao;

import br.com.bingo.util.PersistenceUtil;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;


public abstract class DaoGenericAbs<T> implements IDaoGeneric<T> {

  EntityManager manager;
  private Class classe;

  /**
   * Método que cria uma nova classe generica T e inicia a unidade de persistencia.
   * 
   */
  public DaoGenericAbs() {
    manager = PersistenceUtil.getEntityManager();
    classe = (Class<T>) 
        ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
  }
  
  /**
   * Método que salva um novo elemento T generico.
   * 
   */
  public void save(T t) throws DaoException {
    try {
      manager.getTransaction().begin();
      manager.persist(t);
      manager.getTransaction().commit();
    } catch (Exception e) {
      manager.getTransaction().rollback();
      e.printStackTrace();
      throw new DaoException("...");
    }
  }

  /**
   * Método que atualiza determinado elemento T generico.
   * 
   */
  public void update(T t) throws DaoException {
    try {
      manager.getTransaction().begin();
      manager.merge(t);
      manager.getTransaction().commit();
    } catch (Exception e) {
      manager.getTransaction().rollback();
      e.printStackTrace();
      throw new DaoException("...");
    }
  }

  /**
   * Método que busca determinado elemento T generico.
   * 
   */
  public T find(Long id) throws DaoException {
    try {
      return (T) manager.find(this.classe, id);
    } catch (Exception e) {
      manager.getTransaction().rollback();
      e.printStackTrace();
      throw new DaoException("...");
    }
  }
  
  /**
   * Método que exclui determinado elemento T generico.
   * 
   */
  public void remove(T t) throws DaoException {
    try {
      manager.getTransaction().begin();
      manager.remove(t);
      manager.getTransaction().commit();
    } catch (Exception e) {
      manager.getTransaction().rollback();
      e.printStackTrace();
      throw new DaoException("...");
    }
  }
  
  /**
   * Método que lista todos os elementos T genericos.
   * 
   */
  public List<T> all() throws DaoException {
    try {
      Criteria criteria = getCriteria();
      criteria.addOrder(Order.asc("id")); // orderBy id;
      return (List<T>) criteria.list();
    } catch (Exception e) {
      manager.getTransaction().rollback();
      e.printStackTrace();
      throw new DaoException("...");
    }
  }

  public Criteria getCriteria() {
    Session session = ((Session) manager.getDelegate());
    return session.createCriteria(this.classe);
  }
}  


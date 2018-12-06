package br.com.bingo.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Classe que gere a unidade de persistencia.
 *
 * @author Matheus
 */
public class PersistenceUtil {


  private static final String PERSISTENCE_UNIT_NAME = "BingoPU";
  private static EntityManagerFactory entityManagerFactory = null;
  private static EntityManager entityManager = null;

  private PersistenceUtil() {
  }

  static {
    try {
      entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  //SINGLETON
  /**
   * Método que abre a conexão com o banco de dados.
   * 
   */
  public static EntityManager getEntityManager() {
    try {
      if (entityManager == null || !entityManager.isOpen()) {
        entityManager = entityManagerFactory.createEntityManager();
      }
      return entityManager;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  
  /**
   * Método que fecha a conexão com o banco de dados.
   * 
   */
  public static void closeEntityManager() {
    try {
      if (entityManager != null) {
        EntityTransaction transaction = entityManager.getTransaction();
        if (transaction.isActive()) {
          transaction.commit();
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      entityManager.close();
    }
  }

  public static void closeEntityManagerFactory() {
    closeEntityManager();
    entityManagerFactory.close();
  }
}
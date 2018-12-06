package br.com.bingo.dao;

import br.com.bingo.model.Cartela;

import java.util.List;

import org.hibernate.Criteria;


public class DaoCartela extends DaoGenericAbs<Cartela> {
  /**
   * Método que busca os cartelas no banco de dados com o Criteria.
   * 
   */
  public List<Cartela> busca() throws DaoException {
    try {
      Criteria criteria = getCriteria();
      return (List<Cartela>) criteria.list();
    } catch (Exception e) {
      manager.getTransaction().rollback();
      e.printStackTrace();
      throw new DaoException("...");
    }
  }
  
}
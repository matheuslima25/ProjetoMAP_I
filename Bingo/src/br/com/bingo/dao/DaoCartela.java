package br.com.bingo.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.bingo.model.Cartela;

public class DaoCartela extends DaoGenericAbs<Cartela> {
 
  public List<Cartela> busca(String nome) throws DaoException {
    try {
      Criteria criteria = getCriteria();
      criteria.add(Restrictions.like("nome", nome));
      criteria.addOrder(Order.asc("id"));
      return (List<Cartela>) criteria.list();
    } catch (Exception e) {
      manager.getTransaction().rollback();
      e.printStackTrace();
      throw new DaoException("...");
    }
  }
  
}
package br.com.bingo.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.bingo.model.Jogador;

public class DaoJogador extends DaoGenericAbs<Jogador> {
 
  public List<Jogador> busca(String nome) throws DaoException {
    try {
      Criteria criteria = getCriteria();
      criteria.add(Restrictions.like("nome", nome));
      criteria.addOrder(Order.asc("id"));
      return (List<Jogador>) criteria.list();
    } catch (Exception e) {
      manager.getTransaction().rollback();
      e.printStackTrace();
      throw new DaoException("...");
    }
  }
  
}
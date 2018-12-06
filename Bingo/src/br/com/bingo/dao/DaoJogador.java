package br.com.bingo.dao;

import br.com.bingo.model.Jogador;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;


public class DaoJogador extends DaoGenericAbs<Jogador> {
  
  /**
   * Método que busca os jogadores no banco de dados com o Criteria.
   * 
   */
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
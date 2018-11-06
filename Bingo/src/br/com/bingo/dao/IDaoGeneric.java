package br.com.bingo.dao;

import java.util.List;

import org.hibernate.Criteria;

import br.com.bingo.dao.DaoException;

public interface IDaoGeneric<T> {
  
  void save(T t) throws DaoException;
  void update(T t) throws DaoException;
  void remove(T t) throws DaoException;
  T find(Long id) throws DaoException;
  List<T> all() throws DaoException;
  Criteria getCriteria();
  
}

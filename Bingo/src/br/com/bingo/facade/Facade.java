package br.com.bingo.facade;

import br.com.bingo.dao.DaoCartela;
import br.com.bingo.dao.DaoException;
import br.com.bingo.dao.DaoJogador;
import br.com.bingo.model.Cartela;
import br.com.bingo.model.Jogador;

import java.util.List;


public class Facade {

  DaoJogador daoj = new DaoJogador();
  DaoCartela daoc = new DaoCartela();
  
  //Jogador
  public void salvarJogador(Jogador jogador) throws DaoException {
    daoj.save(jogador);
  }
  
  public void updateJogador(Jogador jogador) throws DaoException {
    daoj.update(jogador);
  }
  
  public List<Jogador> listarJogador() throws DaoException {
    return daoj.all();
  }
  
  //Cartela
  public void salvarCartela(Cartela cartela) throws DaoException {
    daoc.save(cartela);
  }
  
  public void updateCartela(Cartela cartela) throws DaoException {
    daoc.update(cartela);
  }
  
  public List<Cartela> listarCartela() throws DaoException {
    return daoc.all();
  }
}

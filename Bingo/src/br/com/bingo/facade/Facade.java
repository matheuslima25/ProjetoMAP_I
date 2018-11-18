package br.com.bingo.facade;

import br.com.bingo.dao.DaoCartela;
import br.com.bingo.dao.DaoException;
import br.com.bingo.dao.DaoJogador;
import br.com.bingo.model.Cartela;
import br.com.bingo.model.Jogador;

public class Facade {

  DaoJogador daoj = new DaoJogador();
  DaoCartela daoc = new DaoCartela();
  
  //Jogador
  public void salvarJogador(Jogador jogador) throws DaoException {
    daoj.save(jogador);
  }
  
  //Cartela
  public void salvarCartela(Cartela cartela) throws DaoException {
    daoc.save(cartela);
  }
}

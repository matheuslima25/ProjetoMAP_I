package br.com.bingo.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.bingo.model.Cartela;
import br.com.bingo.dao.DaoException;

public class Main {
 
  public static void main(String[] args) throws DaoException {
    List<Cartela> sorteio = new ArrayList<>();
    
    for(int i = 0; i < 100; i++) {
      Cartela c = new Cartela();
      c.gerarCartela();
      if(!sorteio.contains(c)) {
        sorteio.add(c);
        System.out.println(c);
      }
    }
    
  }
}

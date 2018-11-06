package br.com.bingo.main;

import br.com.bingo.dao.CartelaDao;
import br.com.bingo.dao.DaoException;

public class Main {
  public static void main(String[] args) throws DaoException {
    int [][] tabela = new int [6][4];
    CartelaDao dao = new CartelaDao();
    
    String numero = dao.gerarNumeracao();
    System.out.println(numero);
    
    tabela = dao.gerarTabela(tabela);
    System.out.println("");
    for(int i = 0; i < tabela.length; i++) {
      for(int j = 0; j < tabela[i].length; j++) {
        System.out.print("\t" +tabela[i][j]);
      }System.out.println("");
    }
  }
}

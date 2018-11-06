package br.com.bingo.dao;

import java.util.ArrayList;
import java.util.Random;

import br.com.bingo.dao.DaoGenericAbs;
import br.com.bingo.model.Cartela;

public class CartelaDao extends DaoGenericAbs<Cartela>{
  
  ArrayList<Integer> generated = new ArrayList<>();
  Random randomizador = new Random();

  public String gerarNumeracao(){ 
    int num = randomizador.nextInt(100); 
    for (int i = 0; i < generated.size(); i++) { 
      if (generated.get(i) == num) { 
        gerarNumeracao(); 
      } 
    } 
    generated.add(num); 
    return (String.valueOf(num)); 
    }
  
  public int [][] gerarTabela(int tabela[][]){
    for (int i=0; i < tabela.length; i++) {
      for (int j=0; j < tabela[i].length; j++) {
          if (j==0) tabela [i][j] = (int)(Math.random()*15+1);
          else if (j==1) tabela [i][j] = (int)(Math.random()*15+15+1);
          else if (j==2) tabela [i][j] = (int)(Math.random()*15+30+1);
          else if (j==3) tabela [i][j] = (int)(Math.random()*15+45+1);
      }
    }
    return tabela;
  }
}

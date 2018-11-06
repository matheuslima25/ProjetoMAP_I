package br.com.bingo.dao;

import java.util.ArrayList;
import java.util.Random;

import br.com.bingo.dao.DaoGenericAbs;
import br.com.bingo.model.Cartela;

public class CartelaDao extends DaoGenericAbs<Cartela>{
  
  ArrayList<Integer> generated = new ArrayList<>();
  Random randomizador = new Random();

  public String getUniqueNumber(){ 
    int num = randomizador.nextInt(100); 
    for (int i = 0; i < generated.size(); i++) { 
      if (generated.get(i) == num) { 
        getUniqueNumber(); 
      } 
    } 
    generated.add(num); 
    return (String.valueOf(num)); 
    }
  
}

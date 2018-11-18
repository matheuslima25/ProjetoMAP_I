package br.com.bingo.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.bingo.model.Cartela;
import br.com.bingo.model.Jogador;
import br.com.bingo.facade.Facade;
import br.com.bingo.dao.DaoException;

public class Main {
 
  public static void main(String[] args) throws DaoException {
    List<Cartela> sorteio = new ArrayList<>();
    Cartela c = new Cartela();
    Jogador j = new Jogador();
    Facade facade = new Facade();
    
    Scanner sc = new Scanner(System.in);
    System.out.println("1. Vender cartela; 0. Sair: ");
    int op = sc.nextInt();
    
    while (op != 0) {
      
      if (op == 1) {
        System.out.println("REALIZAR VENDA:");
        System.out.println("Nome: ");
        String nome = sc.next();
        
        c.gerarCartela();
        if(!sorteio.contains(c)) {
          sorteio.add(c);
        }
        j.setNome(nome);
        j.setCartela(c);
        
        facade.salvarCartela(c);
        facade.salvarJogador(j);
        
        System.out.println("VENDA REALIZADA COM SUCESSO.");
    }
      
      System.out.println("1. Vender cartela; 0. Sair: ");
      op = sc.nextInt();
    }
    System.out.println("SAINDO...");
    sc.close();

    
  }
}

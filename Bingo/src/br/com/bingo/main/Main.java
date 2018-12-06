package br.com.bingo.main;

import br.com.bingo.dao.DaoException;
import br.com.bingo.facade.Facade;
import br.com.bingo.model.Cartela;
import br.com.bingo.model.Jogador;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class Main {
  /**
   * Main.
   * 
   * @param args argumentos
   */
  public static void main(String[] args) throws DaoException {
    List<Cartela> sorteio = new ArrayList<>();
    Cartela c = new Cartela();
    Jogador j = new Jogador();
    Facade facade = new Facade();
    int num = 0;

    Scanner sc = new Scanner(System.in);
    System.out.println("1. Vender cartela; 2.Sortear; 0. Sair: ");
    int op = sc.nextInt();

    while (op != 0) {

      if (op == 1) {
        j = new Jogador();
        c = new Cartela();
        System.out.println("REALIZAR VENDA:");
        System.out.println("Nome: ");
        String nome = sc.next();

        c.gerarCartela();
        if (!sorteio.contains(c)) {
          sorteio.add(c);
        }
        j.setNome(nome);
        j.setCartela(c);

        facade.salvarCartela(c);
        facade.salvarJogador(j);

        System.out.println("VENDA REALIZADA COM SUCESSO.");
      } else if (op == 2) {
        System.out.println("SORTEIO:");
        List<Jogador> resultadoj = facade.listarJogador();
        SortedSet<Integer> board = new TreeSet<>();
        do {
          System.out.println("NUMERO SORTEADO:");
          num = sc.nextInt();
          for (Jogador r: resultadoj) {
            System.out.println("Nome: " + r.getNome());
            System.out.println("Numeracao: " + r.getCartela().getNumeracao());
            List<Cartela> re = facade.listarCartela();
            for (Cartela ca : re) { 
              System.out.println("Numeros: " + ca);
              if (ca.toString().contains(Integer.toString(num))) {
                board.add(num);
                ca.getBoard().removeAll(board);
                r.setCartela(ca);
                facade.updateCartela(ca);
                facade.updateJogador(r);
                if (r.getCartela().getBoard().isEmpty()) {
                  System.out.println("VENCEDOR: " + r.getNome() + ", PARABÉNS.");
                  break;
                }
              }
            }
          }
        } while (num != 0);
      }

      System.out.println("1. Vender cartela; 2.Sortear; 0. Sair: ");
      op = sc.nextInt();
    }
    System.out.println("SAINDO...");
    sc.close();


  }
}

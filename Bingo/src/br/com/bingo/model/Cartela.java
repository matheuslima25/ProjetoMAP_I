package br.com.bingo.model;

import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.UUID;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;


@Entity

public class Cartela {
  
  @GeneratedValue
  @Id
  private long id;
  @ElementCollection(targetClass = Integer.class)
  @javax.persistence.OrderBy("sort")
  @CollectionTable(
      name = "board",
      joinColumns = @JoinColumn(name = "id", referencedColumnName = "id")
  )
  private SortedSet<Integer> board;
  private final int NUM = 24; //Checkstyle não considera nomes de constantes?
  private String numeracao;
  
  public Cartela() {
    board = new TreeSet<Integer>();
  }
  
  /**
   * Método que gera novas cartelas.
   * 
   */
  public void gerarCartela() {
    Random r = new Random();
    numeracao = UUID.randomUUID().toString();
    while (board.size() < NUM) {
      int n = r.nextInt(59) + 1;
      board.add(n);
    }
  }
  
  public void setBoard(SortedSet<Integer> board) {
    this.board = board;
  }
  
  public SortedSet<Integer> getBoard() {
    return board;
  }
  
  @Override
  public String toString() {
    StringBuilder st = new StringBuilder();
    for (Integer i : board) {
      st.append(i + " ");
    }
    return st.toString();
  }
  
  @Override
  public boolean equals(Object obj) {
    Cartela o = (Cartela) obj;
    if (o.board.equals(this.board)) {
      return true;
    }
    return false;
  }

  public String getNumeracao() {
    return numeracao;
  }

  public void setNumeracao(String numeracao) {
    this.numeracao = numeracao;
  }
}
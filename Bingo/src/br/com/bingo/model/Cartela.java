package br.com.bingo.model;

import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;



public class Cartela {
  
  private SortedSet<Integer> board;
  private final int NUM = 24;
  
  public Cartela() {
    board = new TreeSet<Integer>();
  }
  
  public void gerarCartela() {
    Random r = new Random();
    while(board.size() < NUM) {
      int n = r.nextInt(59)+1;
      board.add(n);
    }
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
    if(o.board.equals(this.board)) {
      return true;
    }
    return false;
  }
}
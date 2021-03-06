package br.com.bingo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Jogador {
  
  @GeneratedValue
  @Id
  private long id;
  private String nome;
  @OneToOne
  @JoinColumn(name = "cartela_id")
  private Cartela cartela;
  
  
  public long getId() {
    return id;
  }
  
  public void setId(long id) {
    this.id = id;
  }
  
  public String getNome() {
    return nome;
  }
  
  public void setNome(String nome) {
    this.nome = nome;
  }
  
  public Cartela getCartela() {
    return cartela;
  }
  
  public void setCartela(Cartela cartela) {
    this.cartela = cartela;
  }
  
  public String toString() {
    return " -Nome:" + nome + " -Cartela:" + cartela; 
  }
}

package br.com.bingo.model;

import java.util.ArrayList;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Cartela {
  @Id
  @GeneratedValue
  private int Id;
  @ElementCollection
  private ArrayList <Integer> numeros = new ArrayList<>(); //B - 1-12 / I - 13-24 / N - 25-36 / G - 37-48 / O - 49-60
  private String numeracao;
  
  
  public int getId() {
    return Id;
  }
  public void setId(int id) {
    Id = id;
  }
  public ArrayList<Integer> getNumeros() {
    return numeros;
  }
  public void setNumeros(ArrayList<Integer> numeros) {
    this.numeros = numeros;
  }
  public String getNumeracao() {
    return numeracao;
  }
  public void setNumeracao(String numeracao) {
    this.numeracao = numeracao;
  }
  
}

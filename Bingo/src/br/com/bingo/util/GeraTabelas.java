package br.com.bingo.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GeraTabelas {
  public static void main(String[] args) {
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("BingoPU");
    factory.close();
  }
}

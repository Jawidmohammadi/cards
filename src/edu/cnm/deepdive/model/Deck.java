package edu.cnm.deepdive.model;

import java.lang.reflect.Array;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Deck {

  private List<Card> cards;
  private List<Card> dealt;


  public Deck() {
    cards = new ArrayList<>();
    dealt = new LinkedList<>();
    for (Suit s : Suit.values()) {
      for (Rank r : Rank.values()) {
        cards.add(new Card(s, r));
      }
    }

  }

  public Card deal() {
    Card card = cards.isEmpty() ? null : cards.remove(0);
    if (card != null) {
      dealt.add(card);
    }
    return card;
  }

  public void shuffle(Random rng) {

    gather();
    Collections.shuffle(cards, rng);
  }

  private void gather() {
    cards.addAll(dealt);
    dealt.clear();
  }

  public int remaining() {
    return cards.size();
  }

  public int dealt() {
  return  dealt.size();
  }

  @Override
  public String toString() {
    return cards.toString();
  }

  public static void main(String[] args) {
    Deck deck = new Deck();
    System.out.println(deck);
    deck.shuffle(new SecureRandom());
    System.out.println(deck);
  }

  public void sort(boolean gather){
    if (gather){
      gather();
    }
    cards.sort((card1, card2) ->{
      int result = card1.getSuit().compareTo(card2.getSuit());
      if (result == 0) {
        result = card1.getRank().compareTo(card2.getRank());
      }
      return result;
    });
  }


}

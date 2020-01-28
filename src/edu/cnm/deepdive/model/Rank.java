package edu.cnm.deepdive.model;

/**
 * Returns {@link #rank() }
 * Initialize the value for each set of cards
 */
public enum Rank {
  ACE,
  TWO,
  THREE,
  FOUR,
  FIVE,
  SIX,
  SEVEN,
  EIGHT,
  NINE,
  TEN,
  JACK,
  QUEEN,
  KING;

  /**
   * Returns {@link #symbol()}
   * Initialize the Symbol for each Set of Cards.
   */
  private static final String[] symbols = {
      "A",
      "2",
      "3",
      "4",
      "5",
      "6",
      "7",
      "8",
      "9",
      "10",
      "J",
      "Q",
      "K"

  };

  public String symbol() {
  return symbols[ordinal()];

  }
}
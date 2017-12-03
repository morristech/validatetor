package com.github.nisrulz.validatetor;

/**
 * The type Card information.
 */
public class CardInformation {

  private String cardIssuer;

  private boolean isValid;

  private String error;

  private String cardNumber;

  /**
   * Instantiates a new Card information.
   *
   * @param cardNumber the card number
   */
  public CardInformation(final String cardNumber) {
    this.cardNumber = cardNumber;
  }

  /**
   * Gets card issuer.
   *
   * @return the card issuer
   */
  public String getCardIssuer() {
    return cardIssuer;
  }

  /**
   * Sets card issuer.
   *
   * @param cardIssuer the card issuer
   */
  public void setCardIssuer(final String cardIssuer) {
    this.cardIssuer = cardIssuer;
  }

  /**
   * Is valid boolean.
   *
   * @return the boolean
   */
  public boolean isValid() {
    return isValid;
  }

  /**
   * Sets valid.
   *
   * @param valid the valid
   */
  public void setValid(final boolean valid) {
    isValid = valid;
  }

  /**
   * Gets error.
   *
   * @return the error
   */
  public String getError() {
    return error;
  }

  /**
   * Sets error.
   *
   * @param error the error
   */
  public void setError(final String error) {
    this.error = error;
  }

  /**
   * Gets card number.
   *
   * @return the card number
   */
  public String getCardNumber() {
    return cardNumber;
  }

  /**
   * Sets card number.
   *
   * @param cardNumber the card number
   */
  public void setCardNumber(final String cardNumber) {
    this.cardNumber = cardNumber;
  }


  @Override
  public String toString() {

    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Card Issuer = ").append(cardIssuer).append("\n");
    stringBuilder.append("Card Number = ").append(cardNumber).append("\n");
    stringBuilder.append("Is Valid = ").append(isValid).append("\n");

    if (!isValid) {
      stringBuilder.append("Error Info = ").append(error).append("\n");
    }

    return stringBuilder.toString();
  }
}

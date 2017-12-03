package com.github.nisrulz.validatetor;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static junit.framework.Assert.assertEquals;
import static org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class CardValidatorTest {
  private CardInformation cardInformation;

  private String cardNumber;

  private CardValidator cardValidator;

  private boolean expectedIsValid;

  private String expectedCardIssuer;

  private String expectedErrorInfo;


  public CardValidatorTest(final String cardNumber, final boolean expectedIsValid,
                           final String expectedCardIssuer, String expectedErrorInfo) {
    this.cardNumber = cardNumber;
    this.expectedIsValid = expectedIsValid;
    this.expectedCardIssuer = expectedCardIssuer;
    this.expectedErrorInfo = expectedErrorInfo;
  }

  @Parameters(name = "{index}: testCreditCard({0}) = {1}")
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {"4929804463622139", true, "Visa", "NA"},
        {"4929804463622138", false, "Visa", "Number did not pass the Luhn Algo Test!"},
        {"6762765696545485", true, "Maestro", "NA"},
        {"5212132012291762", false, "Mastercard", "Number did not pass the Luhn Algo Test!"},
        {"6210948000000029", true, "China Union Pay", "NA"},
        {"61294wuriyq98797", false, "Unknown", "Number should be composed of only digits!"},
        {"00007129847197591315", false, "Unknown", "Card number should be of length > 12 and < 19 digits!"},
        {"8971247", false, "Unknown", "Card number should be of length > 12 and < 19 digits!"},
        {"1241241294184701240124", false, "Unknown", "Card number should be of length > 12 and < 19 digits!"},
    });
  }

  @Before
  public void setup() throws Exception {

    cardValidator = new CardValidator();
    cardInformation = cardValidator.getCardInformation(cardNumber);
  }

  @Test
  public void checkIfCardIsValid() {
    assertEquals(cardInformation.isValid(), expectedIsValid);
  }

  @Test
  public void checkIfCardIssuerIsCorrect() {
    assertEquals(cardInformation.getCardIssuer(), expectedCardIssuer);
  }


  @Test
  public void checkIfErrorInfoIsCorrect() {
    assertEquals(cardInformation.getError(), expectedErrorInfo);
  }


  @Test
  public void checkIfNumberIsSetInCardInformationObject() {
    assertEquals(cardInformation.getCardNumber(), cardNumber);
  }

}
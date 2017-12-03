package com.github.nisrulz.validatetor;

/**
 * The type Card validator.
 */
class CardValidator {

  /**
   * Validate credit card number.
   *
   * @param number the number
   * @return the boolean
   */
  public boolean validateCreditCardNumber(String number) {
    return checkIfNumberContainsOnlyDigits(number)
        && validateLengthOfCardNumber(number)
        && (validateAndGetStartingSixDigits(number) > 0)
        && validateCardNumberWithLuhnAlgo(number);
  }

  private String getErrorInfo(String number) {
    if (!checkIfNumberContainsOnlyDigits(number)) {
      return "Number should be composed of only digits!";
    }

    if (!validateLengthOfCardNumber(number)) {
      return "Card number should be of length > 12 and < 19 digits!";
    }

    if (validateAndGetStartingSixDigits(number) == 0) {
      return "Number contains leading zeros!";
    }

    if (!validateCardNumberWithLuhnAlgo(number)) {
      return "Number did not pass the Luhn Algo Test!";
    }

    return "NA";
  }

  private String getCreditCardIssuer(String number) {
    return getTypeOfCard(validateAndGetStartingSixDigits(number));
  }

  private int countDigitsInNumber(long num) {
    int count = 0;
    while (num > 0) {
      num = num / 10;
      count++;
    }
    return count;
  }

  private boolean validateCardNumberWithLuhnAlgo(String num) {
    int sumOfDoubleOfDigits = 0;
    if (checkIfNumberContainsOnlyDigits(num)) {
      boolean alternateValue = false;
      for (int i = num.length() - 1; i >= 0; i--) {
        int digit = Integer.parseInt(String.valueOf(num.charAt(i)));

        if (alternateValue) {
          digit *= 2;
          if (digit > 9) {
            digit -= 9;
          }
        }
        sumOfDoubleOfDigits += digit;
        alternateValue = !alternateValue;
      }
    }

    return (sumOfDoubleOfDigits % 10 == 0);
  }

  private boolean checkIfNumberContainsOnlyDigits(String number) {
    // check if number string contains only digits
    return number.matches("[0-9]+");
  }

  private boolean validateLengthOfCardNumber(String number) {
    // check for number of digits
    return !(number.length() < 12 || number.length() > 19);
  }

  private long validateAndGetStartingSixDigits(String number) {
    String startSixDigitSubstring = number.substring(0, 6);
    if (checkIfNumberContainsOnlyDigits(startSixDigitSubstring)) {
      long startNumber = Long.parseLong(startSixDigitSubstring);
      // Check for leading zeros
      if (startNumber == 0 || countDigitsInNumber(startNumber) < 6) {
        return 0;
      }

      return startNumber;
    } else {
      return 0;
    }
  }

  private String getTypeOfCard(long startingSixDigits) {
    if (startingSixDigits > 400000 && startingSixDigits < 499999) {
      return "Visa";
    } else if ((startingSixDigits > 222100 && startingSixDigits < 272099) || (startingSixDigits > 510000
        && startingSixDigits < 559999)) {
      return "Mastercard";
    } else if (startingSixDigits > 620000 && startingSixDigits < 629999) {
      return "China Union Pay";
    } else if ((startingSixDigits > 500000 && startingSixDigits < 509999) || (startingSixDigits > 560000
        && startingSixDigits < 699999)) {
      return "Maestro";
    } else {
      return "Unknown";
    }
  }


  /**
   * Gets card information.
   *
   * @param num the num
   * @return the card information
   */
  public CardInformation getCardInformation(String num) {
    CardInformation cardInformation = new CardInformation(num);
    cardInformation.setCardIssuer(getCreditCardIssuer(num));
    cardInformation.setValid(validateCreditCardNumber(num));
    cardInformation.setError(getErrorInfo(num));
    return cardInformation;
  }
}

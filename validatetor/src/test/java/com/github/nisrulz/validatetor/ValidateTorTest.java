package com.github.nisrulz.validatetor;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class ValidateTorTest {

  private ValidateTor mValidateTor;


  @Before
  public void setUp() throws Exception {
    mValidateTor = new ValidateTor();
  }

  @After
  public void tearDown() throws Exception {
    mValidateTor = null;
  }

  @Test
  public void containsSubstring_shouldReturnsTrue_whenSeedIsPresentInsideString_ignoreCase() throws
      Exception {
    assertEquals(true, mValidateTor.containsSubstring("abcdEfgHiJK", "def"));
    assertEquals(true, mValidateTor.containsSubstring("abcdEfgHiJK", "DEFG"));
    assertEquals(true, mValidateTor.containsSubstring("abcdEfgHiJK", "f"));
    assertEquals(true, mValidateTor.containsSubstring("abcdEfgHiJK", "F"));
    assertEquals(true, mValidateTor.containsSubstring("abcdEfgHiJK", "E"));
  }

  @Test
  public void containsSubstring_shouldReturnsFalse_whenSeedIsNotPresentInsideString_ignoreCase()
      throws
      Exception {
    assertEquals(false, mValidateTor.containsSubstring("abcdEfgHiJK", "acd"));
  }

  @Test
  public void isAlpha_shouldReturnTrue_whenStringContainsOnlyAlphaCharacters() throws Exception {
    assertEquals(true, mValidateTor.isAlpha("abcdEfgHiJK"));
    assertEquals(true, mValidateTor.isAlpha("abcd"));
    assertEquals(true, mValidateTor.isAlpha("A"));
    assertEquals(true, mValidateTor.isAlpha("Ab"));
    assertEquals(true, mValidateTor.isAlpha("bC"));
  }


  @Test
  public void
  isAlpha_shouldReturnFalse_whenStringContainsAnyOtherCharacterOtherThanAlphaCharacters()
      throws
      Exception {
    assertEquals(false, mValidateTor.isAlpha("1"));
    assertEquals(false, mValidateTor.isAlpha("&"));
    assertEquals(false, mValidateTor.isAlpha("abc123"));
    assertEquals(false, mValidateTor.isAlpha("123abc"));
    assertEquals(false, mValidateTor.isAlpha(" ")); // space character
    assertEquals(false, mValidateTor.isAlpha("  ")); //tab character
  }

  @Test
  public void isAlphanumeric_shouldReturnTrue_whenStringContainsOnlyAlphaAndNumericCharacters()
      throws
      Exception {
    assertEquals(true, mValidateTor.isAlphanumeric("abcd123"));
    assertEquals(true, mValidateTor.isAlphanumeric("12452abcd"));
    assertEquals(true, mValidateTor.isAlphanumeric("abcdEfgHiJK"));
  }

  @Test
  public void
  isAlphanumeric_shouldReturnFalse_whenStringContainsSpecialCharacterOtherThanAlphaNumericCharacters()
      throws Exception {

    assertEquals(false, mValidateTor.isAlphanumeric("#"));
    assertEquals(false, mValidateTor.isAlphanumeric("%"));
    assertEquals(false, mValidateTor.isAlphanumeric("\r"));
    assertEquals(false, mValidateTor.isAlphanumeric("123("));
    assertEquals(false, mValidateTor.isAlphanumeric("123(abc"));
    assertEquals(false, mValidateTor.isAlphanumeric(" ")); // space character
    assertEquals(false, mValidateTor.isAlphanumeric("  ")); //tab character
  }

  @Test
  public void isBoolean_shouldReturnTrue_whenStringIsTrue() throws Exception {
    assertEquals(true, mValidateTor.isBoolean("true"));
    assertEquals(true, mValidateTor.isBoolean("True"));
    assertEquals(true, mValidateTor.isBoolean("TRUE"));
    assertEquals(true, mValidateTor.isBoolean("TrUe"));

    assertEquals(true, mValidateTor.isBoolean("false"));
    assertEquals(true, mValidateTor.isBoolean("False"));
    assertEquals(true, mValidateTor.isBoolean("FALSE"));
    assertEquals(true, mValidateTor.isBoolean("fAlSe"));
  }

  @Test
  public void isBoolean_shouldReturnFalse_whenStringIsFalse() throws Exception {
    assertEquals(false, mValidateTor.isBoolean("fals1"));
    assertEquals(false, mValidateTor.isBoolean("1False"));
    assertEquals(false, mValidateTor.isBoolean("Trye1"));
    assertEquals(false, mValidateTor.isBoolean("True1"));
  }

  @Test
  public void isIPAddress_shouldReturnTrue_whenStringIsValidIP() throws Exception {
    assertEquals(true, mValidateTor.isIPAddress("10.255.255.254"));
    assertEquals(true, mValidateTor.isIPAddress("192.168.0.0"));
    assertEquals(true, mValidateTor.isIPAddress("0:0:0:0:0:0:0:1"));
    assertEquals(true, mValidateTor.isIPAddress("0.0.0.1"));
  }

  @Test
  public void isEmail_shouldReturnTrue_whenStringIsValidEmailAddress() throws Exception {
    assertEquals(true, mValidateTor.isEmail("a&d@somedomain.com"));
    assertEquals(true, mValidateTor.isEmail("a*d@somedomain.com"));
    assertEquals(true, mValidateTor.isEmail("a/d@somedomain.com"));
  }

  @Test
  public void isEmail_shouldReturnTrue_whenStringIsInvalidEmailAddress() throws Exception {
    assertEquals(false, mValidateTor.isEmail(".abc@somedomain.com"));
    assertEquals(false, mValidateTor.isEmail("bc.@somedomain.com"));
    assertEquals(false, mValidateTor.isEmail("a>b@somedomain.com"));
  }

  @Test
  public void isPhoneNumber_shouldReturnTrue_whenStringIsValidPhoneNumber() throws Exception {
    assertEquals(true, mValidateTor.isPhoneNumber("800-555-5555"));
    assertEquals(true, mValidateTor.isPhoneNumber("333-444-5555"));
    assertEquals(true, mValidateTor.isPhoneNumber("212-666-1234"));

  }

  @Test
  public void isPhoneNumber_shouldReturnFalse_whenStringIsInvalidPhoneNumber() throws Exception {
    assertEquals(false, mValidateTor.isPhoneNumber("000-000-0000"));
    assertEquals(false, mValidateTor.isPhoneNumber("123-456-7890"));
    assertEquals(false, mValidateTor.isPhoneNumber("2126661234"));

  }

  @Test
  public void isDecimal_shouldReturnTrue_whenStringIsDecimal() throws Exception {
    assertEquals(true, mValidateTor.isDecimal("1.000"));
    assertEquals(true, mValidateTor.isDecimal("0012.0"));
    assertEquals(true, mValidateTor.isDecimal("123.000"));
    assertEquals(true, mValidateTor.isDecimal(".003"));
  }

  @Test
  public void isAtleastLength_shouldReturnTrue_whenStringIsOfAtleastSpecifiedLength() throws
      Exception {
    assertEquals(true, mValidateTor.isAtleastLength("abc", 2));
    assertEquals(true, mValidateTor.isAtleastLength("abc", 3));
    assertEquals(true, mValidateTor.isAtleastLength("abcdef", 5));
  }


  @Test
  public void isAtleastLength_shouldReturnFalse_whenStringIsNotOfAtleastSpecifiedLength() throws
      Exception {
    assertEquals(false, mValidateTor.isAtleastLength("abc", 4));
    assertEquals(false, mValidateTor.isAtleastLength("abc", 5));
  }

  @Test
  public void isAtMostLength_shouldReturnTrue_whenStringIsOfAtleastSpecifiedLength() throws
      Exception {
    assertEquals(true, mValidateTor.isAtMostLength("abc", 5));
    assertEquals(true, mValidateTor.isAtMostLength("abc", 3));
    assertEquals(true, mValidateTor.isAtMostLength("abcdef", 10));
  }


  @Test
  public void isAtMostLength_shouldReturnFalse_whenStringIsNotOfAtleastSpecifiedLength() throws
      Exception {
    assertEquals(false, mValidateTor.isAtMostLength("abc", 2));
    assertEquals(false, mValidateTor.isAtMostLength("abc", 1));
  }


  @Test
  public void isLowercase_shouldReturnTrue_whenStringIsLowercase() throws Exception {
    assertEquals(true, mValidateTor.isLowercase("abc"));
  }

  @Test
  public void isLowercase_shouldReturnFalse_whenStringIsNotLowercase() throws Exception {
    assertEquals(false, mValidateTor.isLowercase("aBC"));
    assertEquals(false, mValidateTor.isLowercase("ABC"));
    assertEquals(false, mValidateTor.isLowercase("AbC"));
  }


  @Test
  public void isUppercase_shouldReturnTrue_whenStringIsUppercase() throws Exception {
    assertEquals(true, mValidateTor.isUppercase("ABC"));
  }

  @Test
  public void isUppercase_shouldReturnFalse_whenStringIsNotUppercase() throws Exception {
    assertEquals(false, mValidateTor.isUppercase("aBC"));
    assertEquals(false, mValidateTor.isUppercase("abc"));
    assertEquals(false, mValidateTor.isUppercase("AbC"));
  }

  @Test
  public void isValidMD5_shouldReturnTrue_whenStringIsValidMD5() throws Exception {
    assertEquals(true, mValidateTor.isValidMD5("5d41402abc4b2a76b9719d911017c592"));
  }

  @Test
  public void isValidMD5_shouldReturnFalse_whenStringIsInvalidMD5() throws Exception {
    assertEquals(false, mValidateTor.isValidMD5("5d41402abc4b2a76b9719d911017"));
  }

  @Test
  public void isNumeric_shouldReturnTrue_whenStringIsNumeric() throws Exception {
    assertEquals(true, mValidateTor.isNumeric("1234"));
  }

  @Test
  public void isNumeric_shouldReturnFalse_whenStringIsNotNumeric() throws Exception {
    assertEquals(false, mValidateTor.isUppercase("123a"));
    assertEquals(false, mValidateTor.isUppercase("abc123"));
  }

  @Test
  public void isInt_shouldReturnTrue_whenStringIsInteger() throws Exception {
    assertEquals(true, mValidateTor.isInteger("123"));
  }


  @Test
  public void isInt_shouldReturnFalse_whenStringIsNotInteger() throws Exception {
    assertEquals(false, mValidateTor.isInteger("a12"));
    assertEquals(false, mValidateTor.isInteger("abc"));
  }

  @Test
  public void isIn_shouldReturnTrue_whenStringIsInTheArray() throws Exception {
    assertEquals(true, mValidateTor.isIn("a1", new String[]{"a1", "a2", "a3", "a4"}));
  }

  @Test
  public void isIn_shouldReturnFalse_whenStringIsNotInTheArray() throws Exception {
    assertEquals(false, mValidateTor.isIn("a1", new String[]{"a2", "a3", "a4"}));
  }

  @Test
  public void isHexadecimal_shouldReturnTrue_whenStringIsHexadecimal() throws Exception {
    assertEquals(true, mValidateTor.isHexadecimal("3FA7"));
  }

  @Test
  public void isHexadecimal_shouldReturnFalse_whenStringIsNotHexadecimal() throws Exception {
    assertEquals(false, mValidateTor.isHexadecimal("GFA7"));
  }

  @Test
  public void isPinCode_shouldReturnTrue_whenStringIsValidPinCode() throws Exception {
    assertEquals(true, mValidateTor.isPinCode("282001"));
  }

  @Test
  public void isPinCode_shouldReturnFalse_whenStringIsInvalidPinCode() throws Exception {
    assertEquals(false, mValidateTor.isPinCode("28200"));
    assertEquals(false, mValidateTor.isPinCode("a28200"));
    assertEquals(false, mValidateTor.isPinCode("123"));
  }

  @Test
  public void hasAtleastOneDigit_shouldReturnTrue_whenStringHasAtleastOneDigit() throws Exception {
    assertEquals(true, mValidateTor.hasAtleastOneDigit("abcde1"));
    assertEquals(true, mValidateTor.hasAtleastOneDigit("a1b2c3"));
    assertEquals(true, mValidateTor.hasAtleastOneDigit("123"));
  }

  @Test
  public void hasAtleastOneDigit_shouldReturnFalse_whenStringDoesnotHaveAtleastOneDigit() throws
      Exception {
    assertEquals(false, mValidateTor.hasAtleastOneDigit("abcde"));
    assertEquals(false, mValidateTor.hasAtleastOneDigit("aaaa"));
    assertEquals(false, mValidateTor.hasAtleastOneDigit("#$%^&"));
  }

  @Test
  public void hasAtleastOneLetter_shouldReturnTrue_whenStringHasAtleastOneLetter() throws
      Exception {
    assertEquals(true, mValidateTor.hasAtleastOneLetter("abcde1"));
    assertEquals(true, mValidateTor.hasAtleastOneLetter("a1b2c3"));
    assertEquals(true, mValidateTor.hasAtleastOneLetter("123abc"));
    assertEquals(true, mValidateTor.hasAtleastOneLetter("abcdef"));
    assertEquals(true, mValidateTor.hasAtleastOneLetter("ABC"));
    assertEquals(true, mValidateTor.hasAtleastOneLetter("AB123"));
    assertEquals(true, mValidateTor.hasAtleastOneLetter("aBcD123#"));
  }

  @Test
  public void hasAtleastOneLetter_shouldReturnFalse_whenStringDoesnotHasAtleastOneLetter() throws
      Exception {
    assertEquals(false, mValidateTor.hasAtleastOneLetter("123456"));
    assertEquals(false, mValidateTor.hasAtleastOneLetter("11#$"));
    assertEquals(false, mValidateTor.hasAtleastOneLetter("#$%^&"));
  }

  @Test
  public void
  hasAtleastOneLowercaseLetter_shouldReturnTrue_whenStringHasAtleastOneLowercaseLetter() throws
      Exception {
    assertEquals(true, mValidateTor.hasAtleastOneLowercaseCharacter("abcde1"));
    assertEquals(true, mValidateTor.hasAtleastOneLowercaseCharacter("a1b2c3"));
    assertEquals(true, mValidateTor.hasAtleastOneLowercaseCharacter("123abc"));
    assertEquals(true, mValidateTor.hasAtleastOneLowercaseCharacter("abcdef"));
    assertEquals(true, mValidateTor.hasAtleastOneLowercaseCharacter("aBcD123#"));
  }

  @Test
  public void
  hasAtleastOneLowercaseLetter_shouldReturnFalse_whenStringDoesnotHasAtleastOneLowercaseLetter()
      throws
      Exception {
    assertEquals(false, mValidateTor.hasAtleastOneLowercaseCharacter("123456"));
    assertEquals(false, mValidateTor.hasAtleastOneLowercaseCharacter("11#$"));
    assertEquals(false, mValidateTor.hasAtleastOneLowercaseCharacter("#$%^&"));
    assertEquals(false, mValidateTor.hasAtleastOneLowercaseCharacter("ABC"));
    assertEquals(false, mValidateTor.hasAtleastOneLowercaseCharacter("ABC123"));
  }

  @Test
  public void
  hasAtleastOneUppercaseLetter_shouldReturnTrue_whenStringHasAtleastOneUppercaseLetter() throws
      Exception {
    assertEquals(true, mValidateTor.hasAtleastOneUppercaseCharacter("ABC123"));
    assertEquals(true, mValidateTor.hasAtleastOneUppercaseCharacter("A1B2C3"));
    assertEquals(true, mValidateTor.hasAtleastOneUppercaseCharacter("123ABC"));
    assertEquals(true, mValidateTor.hasAtleastOneUppercaseCharacter("ABC"));
    assertEquals(true, mValidateTor.hasAtleastOneUppercaseCharacter("aBcD123#"));
  }

  @Test
  public void
  hasAtleastOneUpperLetter_shouldReturnFalse_whenStringDoesnotHasAtleastOneUppercaseLetter()
      throws
      Exception {
    assertEquals(false, mValidateTor.hasAtleastOneUppercaseCharacter("123456"));
    assertEquals(false, mValidateTor.hasAtleastOneUppercaseCharacter("11#$"));
    assertEquals(false, mValidateTor.hasAtleastOneUppercaseCharacter("#$%^&"));
    assertEquals(false, mValidateTor.hasAtleastOneUppercaseCharacter("abc"));
    assertEquals(false, mValidateTor.hasAtleastOneUppercaseCharacter("abcde1"));
  }


  @Test
  public void
  hasAtleastOneSpecialCharacter_shouldReturnTrue_whenStringHasAtleastOneSpecialCharacter() throws
      Exception {
    assertEquals(true, mValidateTor.hasAtleastOneSpecialCharacter("ABC123#"));
    assertEquals(true, mValidateTor.hasAtleastOneSpecialCharacter("$A1B2C3"));
    assertEquals(true, mValidateTor.hasAtleastOneSpecialCharacter("123@ABC"));
    assertEquals(true, mValidateTor.hasAtleastOneSpecialCharacter("!ABC"));
    assertEquals(true, mValidateTor.hasAtleastOneSpecialCharacter(".aBcD123#"));
    assertEquals(true, mValidateTor.hasAtleastOneSpecialCharacter("11#$"));
    assertEquals(true, mValidateTor.hasAtleastOneSpecialCharacter("#$%^&"));
  }

  @Test
  public void
  hasAtleastOneSpecialCharacter_shouldReturnFalse_whenStringDoesnotHasAtleastOneSpecialCharacter()
      throws
      Exception {
    assertEquals(false, mValidateTor.hasAtleastOneSpecialCharacter("123456"));
    assertEquals(false, mValidateTor.hasAtleastOneSpecialCharacter("abc"));
    assertEquals(false, mValidateTor.hasAtleastOneSpecialCharacter("ABC"));
    assertEquals(false, mValidateTor.hasAtleastOneSpecialCharacter("ABCdef123"));
    assertEquals(false, mValidateTor.hasAtleastOneSpecialCharacter("abcde1"));
  }
}
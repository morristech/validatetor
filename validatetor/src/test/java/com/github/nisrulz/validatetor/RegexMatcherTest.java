package com.github.nisrulz.validatetor;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class RegexMatcherTest {

  private RegexMatcher mRegexMatcher;
  private String str;

  @Before
  public void setup() throws Exception {
    mRegexMatcher = new RegexMatcher();
  }

  @After
  public void tearDown() throws Exception {
    mRegexMatcher = null;
  }

  @Test
  public void validate_shouldThrowExeception_whenRegexStringIsNull() throws Exception {

    str = "abc";
    boolean threwException = false;

    try {
      mRegexMatcher.validate(str, (String) null);
    } catch (IllegalArgumentException expectedException) {
      threwException = true;
    }
    assertEquals(true, threwException);
  }

  @Test
  public void validate_shouldThrowExeception_whenRegexStringIsEmpty() throws Exception {

    str = "abc";
    boolean threwException = false;

    try {
      mRegexMatcher.validate(str, "");
    } catch (IllegalArgumentException expectedException) {
      threwException = true;
    }
    assertEquals(true, threwException);
  }

  @Test
  public void validate_shouldReturnFalse_whenStringIsEmpty() throws Exception {
    str = "";
    assertEquals(false, mRegexMatcher.validate(str, RegexPresetPattern.ALPHA));
  }

  @Test
  public void validate_shouldReturnFalse_whenStringIsNull() throws Exception {
    str = null;
    assertEquals(false, mRegexMatcher.validate(str, RegexPresetPattern.ALPHA));
  }


  @Test
  public void validate_shouldReturnTrue_whenStringIsValidAlpha() throws Exception {
    str = "abc";
    assertEquals(true, mRegexMatcher.validate(str, RegexPresetPattern.ALPHA));
  }

  @Test
  public void validate_shouldReturnTrue_whenRegexStringIsValidString() throws Exception {
    str = "abc";
    assertEquals(true, mRegexMatcher.validate(str, "[a-zA-Z]+"));
  }
}
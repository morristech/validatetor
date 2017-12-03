package com.github.nisrulz.validatetor;

import java.util.regex.Pattern;

/**
 * The type Regex matcher.
 */
public class RegexMatcher {

  /**
   * Validate string against a regex.
   *
   * @param dataStr the data str
   * @param regex   the regex
   * @return the boolean
   */
  public boolean validate(String dataStr, String regex) {
    if (regex == null || regex.equals("")) {
      throw new IllegalArgumentException("regex field cannot is be null or empty!");
    } else {
      Pattern p = Pattern.compile(regex);
      return validate(dataStr, p);
    }
  }


  /**
   * Find in string against a regex.
   *
   * @param dataStr the data str
   * @param regex   the regex
   * @return the boolean
   */
  public boolean find(String dataStr, String regex) {
    if (regex == null || regex.equals("")) {
      throw new IllegalArgumentException("regex field cannot is be null or empty!");
    } else {
      Pattern p = Pattern.compile(regex);
      return find(dataStr, p);
    }
  }

  /**
   * Validate string against a pattern.
   *
   * @param dataStr the data str
   * @param pattern the pattern
   * @return the boolean
   */
  public boolean validate(String dataStr, Pattern pattern) {
    return !(dataStr == null || dataStr.equals("")) && pattern.matcher(dataStr).matches();
  }

  /**
   * Find in string against a pattern.
   *
   * @param dataStr the data str
   * @param pattern the pattern
   * @return the boolean
   */
  public boolean find(String dataStr, Pattern pattern) {
    return !(dataStr == null || dataStr.equals("")) && pattern.matcher(dataStr).find();
  }
}

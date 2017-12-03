<h1 align="center">ValidateTor</h1>

<div align="center">
  <strong>ValidateTor: Android library for fast and simple string validation.</strong>
</div>
<br/>
<div align="center">
    <!-- Bintray -->
    <a href="https://bintray.com/nisrulz/maven/com.github.nisrulz%3Avalidatetor/_latestVersion">
        <img src="https://api.bintray.com/packages/nisrulz/maven/com.github.nisrulz%3Avalidatetor/images/download.svg"/>
    </a>
    <!-- API -->
    <a href="https://android-arsenal.com/api?level=14">
        <img src="https://img.shields.io/badge/API-14%2B-orange.svg?style=flat"/>
    </a>
    <!-- GitHub stars -->
    <a href="https://github.com/nisrulz/validatetor">
        <img src="https://img.shields.io/github/stars/nisrulz/validatetor.svg?style=social&label=Star"/>
    </a>
    <!-- GitHub forks -->
    <a href="https://github.com/nisrulz/validatetor/fork">
        <img src="hhttps://img.shields.io/github/forks/nisrulz/validatetor.svg?style=social&label=Fork"/>
    </a>
    <!-- GitHub watchers -->
    <a href="https://github.com/nisrulz/validatetor">
        <img src="https://img.shields.io/github/watchers/nisrulz/validatetor.svg?style=social&label=Watch"/>
    </a>
</div>
<br/>


# Including in your project
ValidateTor is available in Jcenter, so getting it as simple as adding it as a dependency
```gradle
implementation 'com.github.nisrulz:validatetor:{latest version}'
```
where `{latest version}` corresponds to published version in [ ![Download](https://api.bintray.com/packages/nisrulz/maven/com.github.nisrulz%3Avalidatetor/images/download.svg) ](https://bintray.com/nisrulz/maven/com.github.nisrulz%3Avalidatetor/_latestVersion)

# Usage

1. Init ValidateTor

    ```java
    ValidateTor validateTor = new ValidateTor();
    ```
1. Validate string against the type of validation method from ValidateTor

    ```java
    // i.e To validate a password string
    EditText edt_password = findViewById(R.id.edt_password);
    String str = edt_password.getText().toString();

    // Check if password field is empty
    if (validateTor.isEmpty(str)) {
      edt_password.setError("Field is empty!");
    }

    // Check password string to be of minimum length of 8 characters and should have
    // atleast 1 digit, 1 upppercase letter and 1 special character
    if (validateTor.isAtleastLength(str, 8)
        && validateTor.hasAtleastOneDigit(str)
        && validateTor.hasAtleastOneUppercaseCharacter(str)
        && validateTor.hasAtleastOneSpecialCharacter(str)) {

        // Valid Password

    } else {
       // Invalid Password, handle in ui
        edt_password.setError("Password needs to be of minimum length of 8 characters and should have " +
          "atleast 1 digit, 1 upppercase letter and 1 special character ");
    }
    ```

    ... other possible validations are as below:

    |Method Name                                    |Description                                                                              |Return Type
    |-----------------------------------------------|-----------------------------------------------------------------------------------------|-------------
    |`containsSubstring(String str, String seed)`   |Check if the string contains the seed                                                    | boolean
    |`isAlpha(String str)`                          |Check if the string contains only letters                                                | boolean
    |`isAlphanumeric(String str)`                   |Check if the string contains only letters and numbers                                    | boolean
    |`isBoolean(String str)`                        |Check if a string is a boolean                                                           | boolean
    |`isIPAddress(String str)`                      |Check if the string is a ip address                                                      | boolean
    |`isEmail(String str)`                          |Check if the string is a email address                                                   | boolean
    |`isPhoneNumber(String str)`                    |Check if the string is a US phone number                                                 | boolean
    |`isEmpty(String str)`                          |Check if the string has a length of zero                                                 | boolean
    |`isBase64(String str)`                         |Check if a string is base64 encoded                                                      | boolean
    |`isDecimal(String str)`                        |Check if the string represents a decimal number, such as 0.1, .3, 1.1, 1.00003, 4.0, etc | boolean
    |`isAtleastLength(String str, int len)`         |Check if the string is of atleast the specified length                                   | boolean
    |`isAtMostLength(String str, int len)`          |Check if the string is of atmost the specified length                                    | boolean
    |`isLowercase(String str)`                      |Check if the string is all lowercase                                                     | boolean
    |`isUppercase(String str)`                      |Check if the string is all uppercase                                                     | boolean
    |`isValidMD5(String str)`                       |Check if the string is a valid MD5 hash                                                  | boolean
    |`isNumeric(String str)`                        |Check if the string contains only numbers                                                | boolean
    |`isMACAddress(String str)`                     |Check if the string is a MAC address                                                     | boolean
    |`isJSON(String str)`                           |Check if the string is valid JSON                                                        | boolean
    |`isInteger(String str)`                        |Check if the string is an integer                                                        | boolean
    |`isIn(String str, String[] values)`            |Check if the string is present in an array of allowed values                             | boolean
    |`isHexadecimal(String str)`                    |Check if the string is a hexadecimal number                                              | boolean
    |`isPinCode(String str)`                        |Check if the string is a pincode                                                         | boolean
    |`isHexColor(String str)`                       |Check if the string is a hexadecimal color                                               | boolean
    |`hasAtleastOneDigit(String str)`               |Check if the string has atleast one digit                                                | boolean
    |`hasAtleastOneLetter(String str)`              |Check if the string has atleast one letter                                               | boolean
    |`hasAtleastOneLowercaseCharacter(String str)`  |Check if the string has atleast one lowercase character                                  | boolean
    |`hasAtleastOneUppercaseCharacter(String str)`  |Check if the string has atleast one uppercase character                                  | boolean
    |`hasAtleastOneSpecialCharacter(String str)`    |Check if the string has atleast one special character                                    | boolean
    |`validateCreditCard(String str)`               |Check if the string is a valid credit card number                                        | boolean
    |`getCreditCardInfo(String str)`                |Get CreditCard information from string                                                   | CardInformation


# Extending ValidateTor

If you wish to extend ValidateTor, use the `RegexMatcher` class. Create your own regex matchers by passing in a valid regex string to `validate()` or `find()`

    |Method Name                                 |Description                               |Return Type
    |--------------------------------------------|------------------------------------------|-------------
    |`validate(String dataStr, String regex)`    |Validate string against a regex           | boolean
    |`validate(String dataStr, Pattern pattern)` |Validate string against a pattern         | boolean
    |`find(String dataStr, String regex)`        |Find in string against a regex            | boolean
    |`find(String dataStr, Pattern pattern)`     |Find in string against a pattern          | boolean


# Pull Requests
I welcome and encourage all pull requests. It usually will take me within 24-48 hours to respond to any issue or request. Here are some basic rules to follow to ensure timely addition of your request:
  1. Match coding style (braces, spacing, etc.) This is best achieved using CMD+Option+L (Reformat code) on Mac with Android Studio defaults. The code style used in this project is from [raywenderlich](https://github.com/raywenderlich/java-style-guide), so please use the same when editing this project.
  2. If its a feature, bugfix, or anything please only change code to what you specify.
  3. Please keep PR titles easy to read and descriptive of changes, this will make them easier to merge :)
  4. Pull requests _must_ be made against `develop` branch. Any other branch (unless specified by the maintainers) will get rejected.
  5. Check for existing [issues](https://github.com/nisrulz/validatetor/issues) first, before filing an issue.
  6. Have fun!

## License
Licensed under the Apache License, Version 2.0, [click here for the full license](/LICENSE.txt).

## Author & support
This project was created by [Nishant Srivastava](https://github.com/nisrulz/) but hopefully developed and maintained by many others. See the [the list of contributors here](https://github.com/nisrulz/validatetor/graphs/contributors).
